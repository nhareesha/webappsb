/**
 * 
 */
package com.springboot.webappsb.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.webappsb.beans.Author;

/**
 * @author Hareesha
 * Jul 17, 2017 2017
 */
public interface AuthorRepository  extends CrudRepository<Author, Long>{

}
