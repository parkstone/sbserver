package com.example.sbserver.service.posts;

import com.example.sbserver.domain.posts.PostsRepository;
import com.example.sbserver.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor // 초기화 되지 않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
