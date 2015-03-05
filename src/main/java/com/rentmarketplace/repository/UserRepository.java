package com.rentmarketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentmarketplace.model.entity.Role;
import com.rentmarketplace.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
