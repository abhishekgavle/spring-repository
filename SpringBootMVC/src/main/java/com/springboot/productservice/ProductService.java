package com.springboot.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.productentity.ProductEntity;
import com.springboot.productmodel.ProductModel;
import com.springboot.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    
     public List<ProductEntity> getAllProducts() {

    	 List<ProductEntity> products=productRepository.findAll();
    	 return products;
    	 
    	 
	}

    public void saveProductDetails(ProductModel productModel) {

        double stockValue = productModel.getPrice() * productModel.getQuantity();
        double discountPrice = productModel.getPrice() * productModel.getDiscountRate() / 100;
        double taxPrice = productModel.getPrice() * 0.18;
        double offerPrice = productModel.getPrice() - discountPrice;
        double finalPrice = offerPrice + taxPrice;

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productModel.getName());
        productEntity.setBrand(productModel.getBrand());
        productEntity.setMadeIn(productModel.getMadeIn());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setDiscountRate(productModel.getDiscountRate());
        productEntity.setDiscountPrice(discountPrice);
        productEntity.setOfferPrice(offerPrice);
        productEntity.setFinalPrice(finalPrice);
        productEntity.setStockValue(stockValue);
        productEntity.setTaxPrice(taxPrice);

        productRepository.save(productEntity);
        
        
        
    }

	public void deleteProductById(long id) {
		 productRepository.deleteById(id);
		
	}

	public ProductEntity searchById(Long id) {
	    Optional<ProductEntity> optionalData = productRepository.findById(id);
	    if (optionalData.isPresent()) {
	        ProductEntity product = optionalData.get();
	        return product;
	    } else {
	        return null;
	    }
	}

	public ProductEntity editProductDetails(Long id) {
	    Optional<ProductEntity> product = productRepository.findById(id);
	    if(product.isPresent()) {
	        return product.get();
	    } else {
	        return null; // Consider throwing an exception or handling this case differently
	    }
	}


	public void saveUpdatedProduct(ProductEntity updatedProduct) {
	    Optional<ProductEntity> optionalProduct = productRepository.findById(updatedProduct.getId());
	    if (optionalProduct.isPresent()) {
	        ProductEntity existingProduct = optionalProduct.get();
	        
	        existingProduct.setName(updatedProduct.getName());
	        existingProduct.setBrand(updatedProduct.getBrand());
	        existingProduct.setMadeIn(updatedProduct.getMadeIn());
	        existingProduct.setPrice(updatedProduct.getPrice());
	        existingProduct.setQuantity(updatedProduct.getQuantity());
	        existingProduct.setDiscountRate(updatedProduct.getDiscountRate());
	        
	        double stockValue = updatedProduct.getPrice() * updatedProduct.getQuantity();
	        double discountPrice = updatedProduct.getPrice() * updatedProduct.getDiscountRate() / 100;
	        double taxPrice = updatedProduct.getPrice() * 0.18;
	        double offerPrice = updatedProduct.getPrice() - discountPrice;
	        double finalPrice = offerPrice + taxPrice;

	        existingProduct.setDiscountPrice(discountPrice);
	        existingProduct.setOfferPrice(offerPrice);
	        existingProduct.setFinalPrice(finalPrice);
	        existingProduct.setStockValue(stockValue);
	        existingProduct.setTaxPrice(taxPrice);

	        productRepository.save(existingProduct);
	    } 
	}

}