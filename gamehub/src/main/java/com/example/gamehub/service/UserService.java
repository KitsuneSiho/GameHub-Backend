package com.example.gamehub.service;

import org.springframework.stereotype.Service;

import com.example.gamehub.entity.UserEntity;
import com.example.gamehub.repository.UserRepository;
import com.example.gamehub.dto.UserDTO;

import lombok.RequiredArgsConstructor;

@Service//님은 서비스임
@RequiredArgsConstructor//controller랑 비슷한 역할. final 맴버 변수 생성자 만드는 역할이다.
public class UserService {

    private final UserRepository userRepository;

    public void save(UserDTO userDTO) {
        //repository 의 매소드 호출
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
        userRepository.save(userEntity);
        //JPA Repository에 있는 save매소드 호출(조건: entity 객체를 꼭 넘겨줘야함!)

    }
    
}
//memberService.class
