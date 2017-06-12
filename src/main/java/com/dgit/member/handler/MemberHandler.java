package com.dgit.member.handler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dgit.controller.CommandHandler;
import com.dgit.member.model.Member;
import com.dgit.member.model.MemberDao;
import com.dgit.utill.MySqlSessionFactory;

public class MemberHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		SqlSession session = null;

		try {
		
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			List<Member> list = dao.selectList();
			req.setAttribute("viewData", list);
			return "/WEB-INF/view/memberList.jsp";

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
