package com.rentmarketplace.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.rentmarketplace.model.entity.Product;
import com.rentmarketplace.model.entity.ProductType;
import com.rentmarketplace.model.entity.User;
import com.rentmarketplace.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findOne(int id) {
		return productRepository.findOne(id);
	}

	public List<Product> findAllByUserName(String name) {
		List<Product> myProducts = productRepository.findAllByUserName(name);
		return myProducts;
	}

	public void save(Product product, String name) {
		User user = userService.findOneWithProducts(name);
		product.setUser(user);
		String productTypeName = product.getProductType().getName();
		ProductType productType = productTypeService.findByName(productTypeName);
		product.setProductType(productType);
		productRepository.save(product);
	}

	public Product findOneByName(String name) {
		return productRepository.findOneByName(name);
	}

	@PreAuthorize(value = "#product.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("product") Product product) {
		productRepository.delete(product);
	}

}
