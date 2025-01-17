package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.productentity.ProductEntity;
import com.springboot.productmodel.ProductModel;
import com.springboot.productservice.ProductService;



	@Controller
	public class ProductController{ 
	    @Autowired
	    ProductService productService;
		@GetMapping("/homepage")
	    public String home() {
	        return "home"; 
	    }
		
		@GetMapping("/aboutus")
	    public String about() {
	        return "about"; 
	    }
		
		@GetMapping("/contactus")
	    public String contact() {
	        return "contact"; 
	    }
		
	    @GetMapping("/productform")
	    public String add() {
	        return "add-product"; 
	    }
	    
	    @PostMapping("/saveproduct")
	    public String saveProduct(ProductModel productModel) {
	    	productService.saveProductDetails(productModel);
	    	
	    	return "success";
	    }
	    
	    @GetMapping("/getallproducts")
	    public String getAllProducts( Model model ) {
	        List<ProductEntity> products = productService.getAllProducts();
            model.addAttribute("products",products);
	        return "product-list";
	    }

		@GetMapping("/delete/{id}")
		public String deleteProductbyID(@PathVariable("id") long id) 
		
		{
			 productService.deleteProductById(id); 
			 return "redirect:/getallproducts";
		}
		 // Mapping to show the search form
	    @GetMapping("/searchId")
	    public String searchByIdForm() {
	        return "search";
	    }

	    // Handling the POST request for search by ID
	    @PostMapping("/searchbyid")
	    public String searchByIdGet(@RequestParam Long id, Model model) {
	        ProductEntity product = productService.searchById(id);
	        model.addAttribute("product", product);
	        return "search";
	    }

		
	    @GetMapping("/edit/{id}")
	    public String editProductById(@PathVariable("id") long id, Model model) {
	        ProductEntity product = productService.editProductDetails(id); // Fetch product by ID
	        model.addAttribute("product", product);
	        model.addAttribute("id",id);
	        return "productedit"; // Return the edit-product template
	    }

	    @PostMapping("/editproductsave")
	    public String updateProduct(ProductEntity product) {
	        productService.saveUpdatedProduct(product); // Save the updated product details
	        return "redirect:/getallproducts"; // Redirect to product list
	    }

	    
	    
	}  