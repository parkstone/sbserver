package com.example.sbserver.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 상속받은 서브클래스에도 필드 추가
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 추가
public abstract class BaseTimeEntity {
    @CreatedDate // Entity가 생성되어 저장 시 시간이 자동 저장
    private LocalDateTime createdDate;
    @LastModifiedDate // 조회한 Entity의 값을 변경 시 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
