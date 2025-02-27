package com.example.gamehub.controller;

import com.example.gamehub.entity.PostEntity;
import com.example.gamehub.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // 모든 게시물 조회
    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    // 게시물 생성
    @PostMapping
    public PostEntity createPost(@RequestBody PostEntity post) {
        return postRepository.save(post);
    }

    // 특정 게시물 조회
    @GetMapping("/{postId}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable Long postId) {
        return postRepository.findById(postId)
                .map(post -> ResponseEntity.ok().body(post))
                .orElse(ResponseEntity.notFound().build());
    }

    // 게시물 수정
    @PutMapping("/{postId}")
    public ResponseEntity<PostEntity> updatePost(@PathVariable Long postId, @RequestBody PostEntity postDetails) {
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postDetails.getTitle());
                    post.setContent(postDetails.getContent());
                    post.setUserId(postDetails.getUserId());
                    post.setDate(postDetails.getDate());
                    PostEntity updatedPost = postRepository.save(post);
                    return ResponseEntity.ok(updatedPost);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 게시물 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        return postRepository.findById(postId)
                .map(post -> {
                    postRepository.delete(post);
                    return ResponseEntity.noContent().<Void>build(); // 수정된 부분
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
