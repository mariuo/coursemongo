package com.devsuperior.coursemongo.models.embedded;

import java.time.Instant;

public class Comment {
	
	private String text;
	private Instant moment;
	
	private Author author;
	
	public Comment() {
		
	}

	public Comment(String text, Instant moment, Author author) {
		super();
		this.text = text;
		this.moment = moment;
		this.author = author;
	}

	
	
	
}
