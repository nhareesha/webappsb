/**
 * 
 */
package com.springboot.webappsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.webappsb.beans.Post;
import com.springboot.webappsb.service.BlogService;

/**
 * @author Hareesha
 * Jul 17, 2017 2017
 */
@Controller
@RequestMapping("/")
public class BlogController {
	
	@Autowired
	BlogService service;
	
	@RequestMapping("/allposts")
	public String seePosts(){
		
		//access all posts through post repository
		service.getAllPosts();
		return "hello";
	}
	
	/**
	 * this is the home page where it shows all the posts with easers
	 * @param model
	 * @return
	 */
	@RequestMapping("/blogHome")
	public String showAllPosts(Model model){
		
		List<Post> posts = service.getLatestPostOrderByTime();
		model.addAttribute("posts", posts);
		return "views/blog-home";
	}
	
	@RequestMapping("/posts/post/{slug}")
	public String getBySlug(@PathVariable(value="slug") String slug ,Model model){
		Post post = service.getPostBySlug(slug);
		model.addAttribute("post", post);
		return "views/post";
	}
}
