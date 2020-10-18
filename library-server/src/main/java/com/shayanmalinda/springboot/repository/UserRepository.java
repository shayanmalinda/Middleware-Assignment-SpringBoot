package com.shayanmalinda.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shayanmalinda.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
 