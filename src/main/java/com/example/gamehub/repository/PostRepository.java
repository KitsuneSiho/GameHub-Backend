package com.example.gamehub.repository;

import com.example.gamehub.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    // 추가적인 쿼리 메서드를 정의할 수 있습니다.
}
