/**
 * 
 */
package com.springboot.webappsb.exceptions;

/**
 * @author Hareesha
 * Jul 24, 2017 2017
 */
public class PostNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public PostNotFoundException(){
		super();
	}
	
	public PostNotFoundException(String msg){
		super(msg);
	}
}
