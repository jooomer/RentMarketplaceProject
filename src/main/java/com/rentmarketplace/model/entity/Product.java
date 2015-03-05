package com.rentmarketplace.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rentmarketplace.service.ProductTypeService;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String description;

	@Column(name = "published_date")
	private Date publishedDate;
	
	@ManyToOne
	@JoinColumn(name = "product_type_id")
	private ProductType productType;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

//	public void setProductType(String type) {
//		ProductTypeService productTypeService = new ProductTypeService();
//		ProductType productType = productTypeService.findByName(type);
//		this.productType = productType;
//	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}


}
