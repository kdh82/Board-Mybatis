package com.dgit.article.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dgit.article.model.Article;
import com.dgit.article.model.ArticleContent;
import com.dgit.article.model.ArticleContentDao;
import com.dgit.article.model.ArticleDao;
import com.dgit.controller.CommandHandler;
import com.dgit.utill.MySqlSessionFactory;

public class DeleteArticleHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int id = Integer.parseInt(req.getParameter("no"));
		System.out.println(id);
		Article ac = new Article();
		ArticleContent acc = new ArticleContent();
		ac.setNumber(id);
		acc.setNumber(id);
		SqlSession session = null;
		try{
			session = MySqlSessionFactory.openSession();
			ArticleDao aDao = session.getMapper(ArticleDao.class);
			ArticleContentDao acDao = session.getMapper(ArticleContentDao.class);
			aDao.delete(ac);
			acDao.delete(acc);
			
			return "listart.do";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

}
