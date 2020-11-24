package com.example.sbserver.web;

import com.example.sbserver.service.posts.PostsService;
import com.example.sbserver.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

/*
    @GetMapping("/")
    public String index() {

        *//*

        src/main/resources/templates/{return value : "index"}.mustache 로 mapping이 가능한 것은
        'org.springframework.boot:spring-boot-starter-mustache' 때문이다

        *//*
        return "index";
    }*/

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        // index.mustache 진입 시마다 List<PostsListResponseDto> 를 전달
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

