package com.dgit.article.model;

import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dgit.utill.MySqlSessionFactory;

public class ArticleDaoTest {

	@Test
	public void testInsert() {
		SqlSession session = null;
		try{
			session = MySqlSessionFactory.openSession();
			ArticleDao aDao = session.getMapper(ArticleDao.class);
			Article ac = new Article(1, "12", "김두환", "사원", new Date(), new Date() , 0);
			aDao.insert(ac);
			session.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
