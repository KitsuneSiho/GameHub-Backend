package com.example.gamehub.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gamehub.entity.UserEntity;
import com.example.gamehub.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void save(UserEntity userEntity) {
        // 비밀번호 암호화 후 설정
        userEntity.setUserPassword(passwordEncoder.encode(userEntity.getUserPassword()));
        // DB에 저장
        userRepository.save(userEntity);
    }

    public boolean isUserIdAvailable(String userId) {
        return !userRepository.existsByUserId(userId);
    }
    public boolean isUserEmailAvailable(String userEmail) {
        return !userRepository.existsByUserEmail(userEmail);
    }
    
    public boolean isUserNameAvailable(String userName) {
        return !userRepository.existsByUserName(userName);
    }
}


//UserService.class