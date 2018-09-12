package com.mycompany.repository;


import com.mycompany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByNickName(String nickName);
    User findByEmail(String email);
}
