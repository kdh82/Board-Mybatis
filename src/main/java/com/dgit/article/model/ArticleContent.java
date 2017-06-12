package com.dgit.article.model;

public class ArticleContent {
	int number;
	String content;
	
	public ArticleContent() {
		// TODO Auto-generated constructor stub
	}
	public ArticleContent(int number, String content) {
		super();
		this.number = number;
		this.content = content;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
