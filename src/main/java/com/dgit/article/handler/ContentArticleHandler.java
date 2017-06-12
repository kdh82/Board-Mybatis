package com.dgit.article.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dgit.article.model.Article;
import com.dgit.article.model.ArticleContent;
import com.dgit.article.model.ArticleContentDao;
import com.dgit.article.model.ArticleDao;
import com.dgit.controller.CommandHandler;
import com.dgit.utill.MySqlSessionFactory;

public class ContentArticleHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("no"));
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao aDao = session.getMapper(ArticleDao.class);

			Article ac = aDao.selectById(id);

			ac.setReadCount(ac.getReadCount() + 1);
			aDao.updateReadcnt(ac);

			ArticleContentDao acDao = session.getMapper(ArticleContentDao.class);
			Map<String, String> artMap = new HashMap<>();
			ArticleContent acc = acDao.selectById(id);

			req.setAttribute("aclist", ac);
			req.setAttribute("acclist", acc);

			return "/WEB-INF/view/contentDetail.jsp";
		} finally {
			session.close();
		}

	}

}
