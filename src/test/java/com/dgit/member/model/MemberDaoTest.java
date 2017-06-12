package com.dgit.member.model;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dgit.utill.MySqlSessionFactory;

public class MemberDaoTest {
/*	@Test
	public void insertTest(){
		SqlSession session = null;
		
		try{
			
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member mem = new Member("prettytest", "이쁘니", "111", new Date());
			dao.insert(mem);
			session.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
	}*/
	@Test
	public void selectTest(){
		SqlSession session = null;
		try{
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			
			Member mem = dao.selectById("prettytest");
			System.out.println(mem.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
