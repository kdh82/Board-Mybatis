package com.dgit.auth.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.jdbc.JdbcUtil;
import com.dgit.member.model.Member;
import com.dgit.member.model.MemberDao;
import com.dgit.utill.MySqlSessionFactory;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/loginForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String id = req.getParameter("id");
			String pass = req.getParameter("password");
			
			SqlSession session = null;
			try{
				
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
				Member member = dao.selectById(id);
				session.commit();
				if(member == null){
					//id가 없을 경우, 회원가입을 유도한다.
					req.setAttribute("notJoin", true);
					return "/WEB-INF/view/loginForm.jsp";
				}
				//비밀번호 일치 여부
				if(member.getPassword().equals(pass) == false){
					req.setAttribute("noMatchPassword", true);
					return "/WEB-INF/view/loginForm.jsp";
				}
				req.getSession().setAttribute("userAuth", id);
				res.sendRedirect(req.getContextPath() + "/index.jsp");
				return null;
				
			}finally{
				session.close();
			}
		}
		return null;
	}

}
