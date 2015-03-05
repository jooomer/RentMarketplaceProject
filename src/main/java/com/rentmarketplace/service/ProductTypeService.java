package com.rentmarketplace.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentmarketplace.model.entity.ProductType;
import com.rentmarketplace.repository.ProductTypeRepository;

@Service
@Transactional
public class ProductTypeService {
	
	@Autowired
	private ProductTypeRepository productTypeRepository; 
	
//	public List<String> findAll() {
//		List<ProductType> productTypes = productTypeRepository.findAll();
//		List<String> types = new ArrayList<>();
//		for (ProductType productType : productTypes) {
//			types.add(productType.getName());
//		}
//		return types;
//	}

	public List<ProductType> findAll() {
		return productTypeRepository.findAll();
	}

	public ProductType findByName(String name) {
		return productTypeRepository.findOneByName(name);
	}

}
