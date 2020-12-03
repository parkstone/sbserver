package com.example.sbserver.config.auth;


import com.example.sbserver.config.auth.CustomOAuth2UserService;
import com.example.sbserver.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // spring security 설정 활성
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // h2-console 사용 위해
                .headers().frameOptions().disable() // h2-console 사용 위해
                .and()
                .authorizeRequests() // URL별 권한 관리 설정 시작~
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated() // 위의 설정 외에 나머지 URL들은 모두 인증된 사용자들에게만 허용
                .and()
                .logout() // 로그아웃 관련 설정 시작 ~
                .logoutSuccessUrl("/") // 로그아웃 성공 시 / 주소로 이동
                .and()
                .oauth2Login() // OAuth2 LogIn 기능 설정 시작~
                .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등
    }
}
