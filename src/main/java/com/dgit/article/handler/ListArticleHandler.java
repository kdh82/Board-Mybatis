package com.dgit.article.handler;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dgit.article.model.Article;
import com.dgit.article.model.ArticleDao;
import com.dgit.controller.CommandHandler;
import com.dgit.utill.MySqlSessionFactory;

public class ListArticleHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
			
			SqlSession session = null;

			try{
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			List<Article> article = dao.selectList();
			req.setAttribute("contentData", article);
		
			return "WEB-INF/view/listArticle.jsp";
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally{
				session.close();
			}
		
		return null;
	}

}
