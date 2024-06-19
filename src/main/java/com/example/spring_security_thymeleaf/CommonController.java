package com.example.spring_security_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/")
	public String getHomepage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String getAboutPage() {
		return "about";
	}
	
	@GetMapping("/dashboard")
	public String getDashboardPage() {
		return "dashboard";
	}
}
