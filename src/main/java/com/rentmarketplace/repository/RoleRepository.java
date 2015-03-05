package com.rentmarketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentmarketplace.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
