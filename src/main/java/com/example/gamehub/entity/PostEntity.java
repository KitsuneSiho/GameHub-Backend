package com.example.gamehub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id") // 데이터베이스의 컬럼 이름이 post_id인 경우
    private Long postId; // 데이터베이스에서 자동 생성되는 ID 필드

    @Column(nullable = false) // 제목은 필수
    private String title;

    @Column(nullable = false) // 내용은 필수
    private String content;

    private String userId; // 작성자 ID
    private String date; // 작성일
}
