package com.learn.Hotelbooking.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Hotelbooking.Entities.User;

public interface UserRepository extends JpaRepository<User,String> {
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);


}
