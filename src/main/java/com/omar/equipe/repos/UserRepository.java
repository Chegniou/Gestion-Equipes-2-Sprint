package com.omar.equipe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.equipe.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}