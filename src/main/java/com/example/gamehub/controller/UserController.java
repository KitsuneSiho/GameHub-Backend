package com.example.gamehub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gamehub.entity.UserEntity;
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
    public ResponseEntity<String> registerUser(@RequestBody UserEntity userEntity){
    //     if(userService.isUserIdAvailable(userEntity.getUserId())){
    //         userService.save(userEntity); //아이디를 쓸 수 있으면 Entity 에 사용자정보 저장
    //         return ResponseEntity.ok("회원가입 성공!!");
    //     }else{
    //         return ResponseEntity.badRequest().body("회원가입에 실패했습니다.");
    //     }
    
    if (!userService.isUserIdAvailable(userEntity.getUserId())) {
        return ResponseEntity.badRequest().body("already_userid");
    }
    if (!userService.isUserEmailAvailable(userEntity.getUserEmail())) {
        return ResponseEntity.badRequest().body("already_useremail");
    }
    if (!userService.isUserNameAvailable(userEntity.getUserName())) {
        return ResponseEntity.badRequest().body("already_username");
    }

    userService.save(userEntity); // 모든 조건을 통과하면 저장
    return ResponseEntity.ok("회원가입 성공!!");

    }

    //아이디 중복확인 API
    @GetMapping("/check-id")
    public ResponseEntity<Boolean> checkUserId(
        @RequestParam String field,
        @RequestParam String value) {
        boolean isAvailable;
        switch (field) {
            case "userId":
                isAvailable = userService.isUserIdAvailable(value);
                break;
            case "userEmail":
                isAvailable = userService.isUserEmailAvailable(value);
                break;
            case "userName":
                isAvailable = userService.isUserNameAvailable(value);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(isAvailable);
    }
}
//UserController.class