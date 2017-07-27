/**
 * 
 */
package com.springboot.webappsb.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

/**
 * @author Hareesha
 * Jul 9, 2017 2017
 */

@Entity
@Table(name="POSTS")
public class Post {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	
	@Column(columnDefinition="TIMESTAMP")
	@CreatedDate //Spring data JPA auditing annotation , which actaully stored the current point of time
	private Date dateTime;
	
	
	@Column(columnDefinition="TEXT")
	private String content;
	
	@Column(columnDefinition="TEXT")
	private String teaser;
	
	private String slug;
	
	@ManyToOne
	private Author author;
	
	
	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", dateTime=" + dateTime
				+ ", content=" + content + ", author=" + author + "]";
	}
}
