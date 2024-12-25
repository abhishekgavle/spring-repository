package com.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller


public class MyController {
	
	
	@GetMapping("/form")
	public String form () {
		return "employeee";
	}
	
	@PostMapping("/form")
	public String  succes(Employee employee){
		System.out.println(employee);
		
		return "succes";
	}
}
	
