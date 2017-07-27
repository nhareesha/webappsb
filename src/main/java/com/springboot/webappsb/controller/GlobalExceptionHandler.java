/**
 * 
 */
package com.springboot.webappsb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Hareesha
 * Jul 10, 2017 2017
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e , HttpServletRequest req , Model m){
		m.addAttribute("e", e);
		m.addAttribute("msg","this is from Global handler");
		return "ExceptionHandler-Specific";
	}
}
