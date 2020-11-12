package com.example.sbserver.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /*

    이동 시, 혹은 참조 시 식별이 쉽도록 가급적 Entity Class와 함께 위치시킨다.

    */
}
