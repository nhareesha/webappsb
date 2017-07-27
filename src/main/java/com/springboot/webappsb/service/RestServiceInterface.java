/**
 * 
 */
package com.springboot.webappsb.service;

import com.springboot.webappsb.beans.Post;

/**
 * @author Hareesha
 * Jul 24, 2017 2017
 */

public interface RestServiceInterface {
	
	Post readPostById(long id);
	
	Iterable<Post> readAllPosts();
	
	Post createPost(Post post);
	
	void deletePost(long id);

	/**
	 * @param post
	 * @param id
	 * @return
	 */
	Post updatePost(Post post, long id);
	
}
