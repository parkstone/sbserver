package com.example.sbserver.service.posts;

import com.example.sbserver.domain.posts.Posts;
import com.example.sbserver.domain.posts.PostsRepository;
import com.example.sbserver.web.dto.PostsListResponseDto;
import com.example.sbserver.web.dto.PostsResponseDto;
import com.example.sbserver.web.dto.PostsSaveRequestDto;
import com.example.sbserver.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor // 초기화 되지 않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        /*

        [dirty checking]
        transaction 안에서 데이터를 조회 시 조회한 데이터와 DB간 context가 유지된다.
        조회 한 데이터를 변경 시 transaction이 끝나는 시점에 DB에 반영이 된다.

        */
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return  id;
    }

    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(posts);
    }

    @Transactional(readOnly = true) // crud가 없는 곳에서 사용 시 조회속도가 향상된다
    public List<PostsListResponseDto> findAllDesc() {
     // return postsRepository.findAllDesc().stream().map(posts -> new PostsListResponseDto(posts)).collect(Collectors.toList());
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }
}
