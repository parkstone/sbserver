package com.example.sbserver.config;


import com.example.sbserver.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * LoginUserArgumentResolver를 spring에서 인식될 수 있도록
 * WebMvcConfigurer에 추가한다
 * (HandlerMethodArgumentResolver는 항상 WebMvcConfigurer의 addArgumentResolvers()를 통해 추가해야 한다)
 */
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
