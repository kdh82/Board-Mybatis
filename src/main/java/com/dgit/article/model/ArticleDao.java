package com.dgit.article.model;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {
	public int insert(Article article) throws SQLException;
	public List<Article> selectList() throws SQLException;
	public Article selectById(int id) throws SQLException;
	public void delete(Article article) throws SQLException;
	public void updateReadcnt(Article article) throws SQLException;
	public void updateContent(Article article) throws SQLException;	
	public int selectLastId() throws SQLException;
}
