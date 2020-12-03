package com.example.sbserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JpaConfig을 통해 @SpringBootApplication과 분리
// @EnableJpaAuditing
@SpringBootApplication
public class SbserverApplication {
	/*

	@SpringBootApplication 부터 설정을 읽어 나가기 시작하기 때문에
	이 클래스는 항상 프로젝트 최상단에 위치해야 한다.

	*/
	public static void main(String[] args) {
		SpringApplication.run(SbserverApplication.class, args);
	}
}
