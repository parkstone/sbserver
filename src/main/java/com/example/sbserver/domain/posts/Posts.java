package com.example.sbserver.domain.posts;

import com.example.sbserver.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    /*

    기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다
    SalesManager.java -> sales_manager table

    Entity Class 에서는 절대 Setter 는 만들지 않는다
    변경이 필요한 경우 목적(Command)에 맞게 메소드를 생성한다

    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500, nullable = false) // varchar(500)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false) // varchar(255) 이상의 길이가 예상될 경우 TEXT 로
    private String content;
    // 속성을 변경하지 않을 경우 기본적인 @Column은 생략 가능
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
