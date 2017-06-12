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

public class ContentModifyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			int id = Integer.parseInt(req.getParameter("no"));
			SqlSession session = null;
			try {
				session = MySqlSessionFactory.openSession();
				ArticleDao aDao = session.getMapper(ArticleDao.class);
				ArticleContentDao acDao = session.getMapper(ArticleContentDao.class);
				Article ac = aDao.selectById(id);
				ArticleContent acc = acDao.selectById(id);

				req.setAttribute("article", ac);
				req.setAttribute("articlecontent", acc);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return "/WEB-INF/view/contentModify.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			SqlSession session = null;
			int number = Integer.parseInt(req.getParameter("id"));
			String id = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			Article ac = new Article();
			ac.setId(id);
			ac.setTitle(title);
			ArticleContent acc = new ArticleContent();
			acc.setContent(content);
			acc.setNumber(number);
			try {
				session = MySqlSessionFactory.openSession();
				ArticleContentDao acDao = session.getMapper(ArticleContentDao.class);
				acDao.update(acc);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return "/WEB-INF/view/contentModifySuccess.jsp";
		}
		return null;
	}
}
