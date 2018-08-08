package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/**
	 * 홈 컨트롤러
	 * @return
	 */
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
