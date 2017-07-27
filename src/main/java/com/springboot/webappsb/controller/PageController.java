package com.springboot.webappsb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hareesha
 * Jul 6, 2017
 */
@Controller
@RequestMapping("/")
public class PageController {
	
	
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
}
