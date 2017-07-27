/**
 * 
 */
package com.springboot.webappsb.restfulService;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webappsb.beans.Post;
import com.springboot.webappsb.exceptions.PostNotFoundException;
import com.springboot.webappsb.service.RestServiceInterface;

/**
 * @author Hareesha
 * Jul 24, 2017 2017
 */
@RestController
@RequestMapping("/restful")
public class HomeRestController {
	
	private RestServiceInterface servInt;
	
	@Autowired
	public HomeRestController(RestServiceInterface serviceInt){
		this.servInt = serviceInt;
	}
	
	
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	Iterable<Post> readAll(){
		Iterable<Post> posts = servInt.readAllPosts();
		return posts;
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	Post readPostById(@PathVariable(value="id", required=true)long id) throws PostNotFoundException{
		Post post = servInt.readPostById(id);
		if(post==null){
			throw new PostNotFoundException("Post with given id not found");
			
		}
		return post;
	}
	
	@RequestMapping(value="/" , method = RequestMethod.POST)
	Post createpost(@RequestBody Post p){
		Post  post = servInt.createPost(p);
		return post;
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.PUT)
	Post updatPost(@PathVariable(value="id") long id , @RequestBody Post post){
		Post p = servInt.updatePost(post, id);
		return p;
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.DELETE)
	void deletePost(@PathVariable(value="id") long id){
		servInt.deletePost(id);
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public void handlePostNotFoundException(PostNotFoundException e , HttpServletResponse resp) throws IOException{
		resp.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}
	
}
