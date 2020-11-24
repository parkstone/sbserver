package com.example.sbserver.domain.posts;

import com.example.sbserver.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /*

    이동 시, 혹은 참조 시 식별이 쉽도록 가급적 Entity Class와 함께 위치시킨다.

    */

    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
