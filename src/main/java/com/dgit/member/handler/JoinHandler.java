package com.dgit.member.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dgit.controller.CommandHandler;
import com.dgit.member.model.Member;
import com.dgit.member.model.MemberDao;
import com.dgit.utill.MySqlSessionFactory;
import com.sun.jmx.snmp.Timestamp;

public class JoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if (req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/joinForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String pass = req.getParameter("password");

			
			
			SqlSession session = null;

			try {
				session = MySqlSessionFactory.openSession();
				MemberDao dao = session.getMapper(MemberDao.class);
				Member mem = new Member(id, name, pass, new Date());
				//이미 존재하는 회원인지 확인
				Member existMember = dao.selectById(id);
				if(existMember != null){
					req.setAttribute("duplicateId", true);
					return "/WEB-INF/view/joinForm.jsp";
				}
				
				dao.insert(mem);
				session.commit();
				
				req.setAttribute("id", id);
			} finally {
				session.close();
			}
			
			return "/WEB-INF/view/joinSuccess.jsp";
		}
		return null;
	}

}
