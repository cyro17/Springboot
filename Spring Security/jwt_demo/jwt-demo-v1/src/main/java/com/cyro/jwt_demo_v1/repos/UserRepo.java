package com.cyro.jwt_demo_v1.repos;

import com.cyro.jwt_demo_v1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
