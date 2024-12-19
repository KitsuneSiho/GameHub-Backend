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
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto_Increment
    private Long userIdx;
    
    @Column(unique = true)
    private String userId;

    @Column(unique = true)
    private String userEmail;

    @Column
    private String userPassword;

    @Column(unique = true)
    private String userName;
    
    public static UserEntity toUserEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserIdx(userDTO.getUserIdx());
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserPassword(userDTO.getUserPassword());

        return userEntity;
    }
    
}
