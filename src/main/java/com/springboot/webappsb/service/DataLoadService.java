/**
 * 
 */
package com.springboot.webappsb.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webappsb.beans.Author;
import com.springboot.webappsb.beans.Post;
import com.springboot.webappsb.repository.AuthorRepository;
import com.springboot.webappsb.repository.PostRepository;

/**
 * @author Hareesha
 * Jul 17, 2017 2017
 */
@Service
public class DataLoadService {

	private PostRepository postRepo;
	private AuthorRepository authRepo;
	
	
	//autowiring by constructor
	@Autowired
	public DataLoadService(PostRepository postRepo ,AuthorRepository authRepo ){
		this.postRepo = postRepo;
		this.authRepo = authRepo;
	}
	
	/**
	 * this method runs as sson a the dependecy injection comeplets on thsi method
	 */
	@PostConstruct
	private void LoadData(){
		Author auth = new Author();
		auth.setFirstName("Naga");
		auth.setLastName("Hareesha");
		authRepo.save(auth);
		
		Post post = new Post();
		post.setContent("This is Programatic data loading");
		post.setDateTime(new Date());
		post.setTitle("First Post");
		post.setAuthor(auth);
		post.setSlug("slug text");
		post.setTeaser("Lorem Ipsum is simply dummy text"+
				"of the printing and typesetting industry. Lorem Ipsum has been the"
				+"industry's standard dummy text ever since the 1500s, when an"+
				"unknown printer took a galley of type and scrambled it to make a"+
				"type specimen book. It has survived not only five centuries, but"+
				"also the leap into electronic typesetting, remaining essentially"+
				"unchanged. It was popularised in the 1960s with the release of"+
				"Letraset sheets containing Lorem Ipsum passages, and more recently"+
				"with desktop publishing software like Aldus PageMaker including"+
				"versions of Lorem Ipsum.");
		postRepo.save(post);
	}
}
