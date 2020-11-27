package com.example.sbserver.web;

import com.example.sbserver.config.LoginUser;
import com.example.sbserver.config.dto.SessionUser;
import com.example.sbserver.service.posts.PostsService;
import com.example.sbserver.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

/*  1.
    @GetMapping("/")
    public String index() {

        *//*

        src/main/resources/templates/{return value : "index"}.mustache 로 mapping이 가능한 것은
        'org.springframework.boot:spring-boot-starter-mustache' 때문이다

        *//*
        return "index";
    }*/

/*  2.
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        // index.mustache 진입 시마다 List<PostsListResponseDto> 를 전달
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }*/

/*  3.
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        // index.mustache 진입 시마다 List<PostsListResponseDto> 를 전달
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }*/

    // 4.
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        // index.mustache 진입 시마다 List<PostsListResponseDto> 를 전달
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

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

