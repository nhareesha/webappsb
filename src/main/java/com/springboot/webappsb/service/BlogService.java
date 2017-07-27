/**
 * 
 */
package com.springboot.webappsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webappsb.beans.Post;
import com.springboot.webappsb.repository.PostRepository;

/**
 * @author Hareesha
 * Jul 17, 2017 2017
 */
@Service
public class BlogService {
	
	@Autowired
	PostRepository postRepo;
	
	public void getAllPosts(){
		Iterable<Post> allposts = postRepo.findAll();
		for(Post post : allposts){
			System.out.println(post.toString());
		}
		System.out.println("here");
		
	}
	
	public List<Post> getLatestPostOrderByTime(){
		List<Post> posts = postRepo.findFirst10ByOrderByDateTimeDesc();
		System.out.println(posts);
		return posts;
	}
	
	public Post getLatestPost(){
		Post post = postRepo.findFirstByOrderByDateTimeDesc();
		System.out.println(post);
		return post;
	}

	/**
	 * @param slug
	 */
	public Post getPostBySlug(String slug) {
		Post post = postRepo.findBySlug(slug);
		return post;
		
	}

}
