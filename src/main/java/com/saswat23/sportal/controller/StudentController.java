package com.saswat23.sportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("/")
	public String getHomePage() {
		return "index.jsp";
	}
	
}
