package com.example.gamehub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gamehub.dto.UserDTO;
import com.example.gamehub.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/") //API 경로 설정
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") //프론트엔드 서버 주소 cors문제 해결용
public class UserController{

    private final UserService userService;

    //회원가입 API
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        if(userService.isUserIdAvailable(userDTO.getUserId())){
            userService.save(userDTO); //아이디를 쓸 수 있으면 DTO 에 사용자정보 저장
            return ResponseEntity.ok("회원가입 성공!!");
        }else{
            return ResponseEntity.badRequest().body("회원가입에 실패했습니다.");
        }
    }

    //아이디 중복확인 API
    @GetMapping("/check-id")
    public ResponseEntity<Boolean> checkUserId(@RequestParam String userId) {
        boolean isAvailable = userService.isUserIdAvailable(userId);
        return ResponseEntity.ok(isAvailable);
    }
}
//UserController.class