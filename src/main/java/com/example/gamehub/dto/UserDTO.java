package com.example.gamehub.dto;

import com.example.gamehub.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//lombok 어노테이션 추가하기
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private Long userIdx;//UID 유저 고유번호. 기본키
    private String userId;//user id
    private String userEmail; //userEmail
    private String userName;
    private String userPassword;

    public static UserDTO toUserDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserIdx(userEntity.getUserIdx());
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserPassword(userEntity.getUserPassword());

        return userDTO;
    }
    
}
//UserDto.class
