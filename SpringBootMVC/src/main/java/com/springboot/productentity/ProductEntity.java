package com.springboot.productentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="productData")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
    private String brand;
    private String madeIn;
    private double price;
    private int quantity; 
    private int discountRate;
    private double taxPrice;
    private double discountPrice;
    private double offerPrice;
    private double finalPrice;
    private double stockValue;
    
}

