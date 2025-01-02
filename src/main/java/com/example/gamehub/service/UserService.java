package com.example.gamehub.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gamehub.dto.UserDTO;
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
    public void save(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        // 비밀번호 암호화 후 설정
        userEntity.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        // DB에 저장
        userRepository.save(userEntity);
    }

    public boolean isUserIdAvailable(String userId) {
        return !userRepository.existsByUserId(userId);
    }
}


//UserService.class