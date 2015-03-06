package com.rentmarketplace.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rentmarketplace.model.entity.Product;
import com.rentmarketplace.model.entity.User;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByUser(User user, Pageable pageable);

	List<Product> findAllByUserName(String name);

	Product findOneByName(String name);

}
