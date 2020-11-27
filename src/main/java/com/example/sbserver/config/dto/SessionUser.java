package com.example.sbserver.config.dto;

import com.example.sbserver.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * [session에 저장하기 위한 user 정보]
 * 1. User class는 Entity 이므로 별도 SessionUser class를 생성한다
 * 2. Serializable을 구현해야 하므로 Entity를 사용하는 것은 바람직하지 않다
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture =user.getPicture();
    }
}
