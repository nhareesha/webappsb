/**
 * 
 */
package com.springboot.webappsb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.webappsb.beans.Post;

/**
 * @author Hareesha
 * Jul 17, 2017 2017
 */
public interface PostRepository extends CrudRepository<Post, Long> {
	
	public Post findFirstByOrderByDateTimeDesc();

	/**
	 * @return
	 */
	public List<Post> findFirst10ByOrderByDateTimeDesc();

	/**
	 * @param slug
	 */
	public Post findBySlug(String slug);

	/**
	 * @param id
	 * @return
	 */
	public Post findById(long id);

}
