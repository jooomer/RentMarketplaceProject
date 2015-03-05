package com.rentmarketplace.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rentmarketplace.model.entity.Product;
import com.rentmarketplace.model.entity.ProductType;
import com.rentmarketplace.model.entity.User;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

	ProductType findOneByName(String name);

}
