package edu.esprit.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product implements Serializable {

	@Id
	@NotEmpty
	@Size(min=3)
	private String reference;
	@NotEmpty
	private String designation;
	@NotNull
	private Double price;
	@Min(1)
	@NotNull
	private Integer quantity;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product() {
		super();
	}

	public Product(String reference, String designation, Double price,
			Integer quantity) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.price = price;
		this.quantity = quantity;
	}

}
