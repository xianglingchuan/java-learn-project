package com.myspringmvc.annotation.demo.entity;

import com.myspringmvc.annotation.demo.AnnColumn;
import com.myspringmvc.annotation.demo.AnnTable;

@AnnTable("tb_article")
public class Article {

	@AnnColumn("uuid")
	private int uuid;

	@AnnColumn("title")
	private String title;

	@AnnColumn("author")
	private String author;

	@AnnColumn("content")
	private String content;

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
