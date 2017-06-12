package com.dgit.article.model;

import java.sql.SQLException;

public interface ArticleContentDao {
	
	public int insert(ArticleContent content) throws SQLException;
	public ArticleContent selectById(int id) throws SQLException;
	public int delete(ArticleContent content) throws SQLException;
	public int update(ArticleContent content) throws SQLException;
}
