/**
 * 
 */
package com.springboot.webappsb.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.webappsb.beans.Post;

/**
 * @author Hareesha Jul 9, 2017 2017
 */
@Controller
@RequestMapping("/posts")
public class BlogPostsController {
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping("/")
	public String posts(Locale locale, Model model) {
		model.addAttribute("pageTitle", "Blog Posts page");
		model.addAttribute("posts", getPostList());

		return "views/posts";
	}

	public ArrayList<Post> getPostList(){
		Post p1 =new Post();
		p1.setTitle("First Post");
	//	p1.setAuthor("Guest1");
		p1.setContent("Lorem Ipsum is simply dummy text"+
							"of the printing and typesetting industry. Lorem Ipsum has been the"
							+"industry's standard dummy text ever since the 1500s, when an"+
							"unknown printer took a galley of type and scrambled it to make a"+
							"type specimen book. It has survived not only five centuries, but"+
							"also the leap into electronic typesetting, remaining essentially"+
							"unchanged. It was popularised in the 1960s with the release of"+
							"Letraset sheets containing Lorem Ipsum passages, and more recently"+
							"with desktop publishing software like Aldus PageMaker including"+
							"versions of Lorem Ipsum.");
	//	p1.setDateTime(LocalDateTime.now());
		
		Post p2 =new Post();
		p2.setTitle("Second Post");
	//	p2.setAuthor("Guest2");
		p2.setContent("This is the first post  and thought of writing in ore details and will update soon");
	//	p2.setDateTime(LocalDateTime.now());
		
		ArrayList<Post> p = new ArrayList<Post>();
		p.add(p1);
		p.add(p2);
		
		return p;
	}
	
	
	@RequestMapping("/testExHandler")
	public String testExceptionHandlerWorking(Model m ,HttpServletRequest req) throws Exception{
		Post post = null;
		if(post==null){
			throw new Exception("Deliberately exception is thrown");
		}
				
		return "index";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e , HttpServletRequest req , Model m){
		m.addAttribute("e", e);
		m.addAttribute("msg","this is from controller based Exception handler");
		return "ExceptionHandler-Specific";
	}
}
