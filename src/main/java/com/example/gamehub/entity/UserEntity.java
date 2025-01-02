package com.example.gamehub.entity;

import com.example.gamehub.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "user_table")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIdx;

    @Column(unique = true)
    private String userId;

    @Column(unique = true)
    private String userEmail;

    @Column(unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserIdx(userDTO.getUserIdx());
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserName(userDTO.getUserName());
        
        // 비밀번호는 외부에서 암호화 후 설정
        return userEntity;
    }
    

    
}
//UserEntity.class