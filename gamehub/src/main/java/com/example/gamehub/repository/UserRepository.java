package com.example.gamehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gamehub.entity.UserEntity;

@Repository//너는 레포지토리임 선언
//JPA를 여기서 써야하니까 상속시키기 
//첫번째 인자: 어떤 엔티티인가? , 두번째 인자: PK가 어떤 타입인가? 를 쓴겁니당
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    
}

//UserRepository.interface
