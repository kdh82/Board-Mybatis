package com.dgit.article.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dgit.article.model.Article;
import com.dgit.article.model.ArticleContent;
import com.dgit.article.model.ArticleContentDao;
import com.dgit.article.model.ArticleDao;
import com.dgit.controller.CommandHandler;
import com.dgit.member.model.Member;
import com.dgit.member.model.MemberDao;
import com.dgit.utill.MySqlSessionFactory;

public class WriteArticleHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")){
			return "WEB-INF/view/newArticleForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String title = req.getParameter("title");
			String content = req.getParameter("content");			
			int number =Integer.parseInt((req.getParameter(String.format("number"))));

			SqlSession session = null;
			try{
				session = MySqlSessionFactory.openSession();
				session.rollback();
				MemberDao mDao = session.getMapper(MemberDao.class);
				ArticleDao aDao = session.getMapper(ArticleDao.class);
				String id = (String)req.getSession().getAttribute("userAuth");
				Member member = mDao.selectById(id);
				Date now = new Date();
				//게시물 제목, 날짜, 카운트
				Article article = new Article(0, id, member.getName(), title, now, now, 0);
				aDao.insert(article);
				number = aDao.selectLastId();
				
				// int number = aDao.insert(article);
				
				
				ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);
				//게시물 내용
				ArticleContent con = new ArticleContent(number, content);
				contentDao.insert(con);
				session.commit();//table 적용 트랜잭션
				
				return "WEB-INF/view/newArticleSuccess.jsp";
				
			}catch(Exception e){
				session.rollback();
				e.printStackTrace();
			}finally{
				session.close();
				
			}
		}
		return null;
	}

}
