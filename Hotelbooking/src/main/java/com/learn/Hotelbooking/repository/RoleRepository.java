package com.learn.Hotelbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Hotelbooking.Entities.AppRole;
import com.learn.Hotelbooking.Entities.Role;

public interface RoleRepository extends JpaRepository<Role,Integer > {
	Optional<Role> findByRoleName(AppRole approle);
}
