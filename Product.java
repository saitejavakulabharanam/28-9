package com.teja.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product")
@Component
public class Product {
	@Id
	private String id;
	private String name;
	private String description;
	private String brand;
	@Min(1)
	private int price;
	@Min(1)
	private int quantity;
	@Transient
	private MultipartFile image;

	
	@ManyToOne
	@JoinColumn(name = "cat_Id", insertable = false, updatable = false)
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private String cat_Id;

	public String getCat_Id() {
		return cat_Id;
	}

	public void setCat_Id(String cat_Id) {
		this.cat_Id = cat_Id;
	}

	
	@ManyToOne
	@JoinColumn(name = "supp_Id", insertable = false, updatable = false)
	private Supplier supplier;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	private String supp_Id;

	public String getSupp_Id() {
		return supp_Id;
	}

	public void setSupp_Id(String supp_Id) {
		this.supp_Id = supp_Id;
	}

	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_name", insertable = false, updatable = false)
	private Brand brand;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	private String brand_name;

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
*/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
