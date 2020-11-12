package com.example.sbserver.web.dto;

import com.example.sbserver.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    /*

    Builder 패턴을 이용 시 생성자 파라메터가
    변경되어도 관련 코드를 수정할 필요가 없어진다.

    */
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
