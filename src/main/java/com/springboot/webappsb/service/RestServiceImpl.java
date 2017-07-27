/**
 * 
 */
package com.springboot.webappsb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webappsb.beans.Post;
import com.springboot.webappsb.repository.PostRepository;

/**
 * @author Hareesha
 * Jul 24, 2017 2017
 */
@Service
public class RestServiceImpl implements RestServiceInterface {

	
	public PostRepository repo;
	
	@Autowired
	public RestServiceImpl(PostRepository repo){
		this.repo = repo;
	}
	
	@Override
	public Post readPostById(long id) {
		Post post = repo.findById(id);
		System.out.println(post);
		return post;
	}


	@Override
	public Iterable<Post> readAllPosts() {
		Iterable<Post> posts = repo.findAll();
		return posts;
	}


	@Override
	public Post createPost(Post post) {
		Post p = repo.save(post);
		return p;
	}


	@Override
	public Post updatePost(Post post , long id) {
		Post existing = null;
		if(repo.findOne(id)!=null){
			existing = repo.findOne(id);
			existing.setAuthor(post.getAuthor());
			existing.setTitle("THIS IS AWESOME POST - Http PUT");
		}
		return existing;
	}


	@Override
	public void deletePost(long id) {
		if(repo.findOne(id)!=null){
			repo.delete(id);
		}
	}

}
