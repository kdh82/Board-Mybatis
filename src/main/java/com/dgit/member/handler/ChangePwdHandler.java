package com.dgit.member.handler;


import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.jdbc.JdbcUtil;
import com.dgit.member.model.Member;
import com.dgit.member.model.MemberDao;
import com.dgit.utill.MySqlSessionFactory;

public class ChangePwdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")){
			return "WEB-INF/view/changePwdForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			
			String id = (String)req.getSession().getAttribute("userAuth");
			String pass = req.getParameter("password");
			String chPass = req.getParameter("chpassword");
			System.out.println(chPass);
			Member mb = new Member(id, chPass);
			/*mb.setId(id);
			mb.setPassword(pass);
			mb.setPassword(chPass);*/
			SqlSession session = null;
			try{
				session = MySqlSessionFactory.openSession();
				MemberDao dao = session.getMapper(MemberDao.class);
				Member member = dao.selectById(id);
				if(member ==null){
					req.setAttribute("notJoin", true);
					return "/WEB-INF/view/changePwdForm.jsp";
				}
				if(member.getPassword().equals(pass)==false){
					req.setAttribute("noMatchPassword", true);
					return "/WEB-INF/view/changePwdForm.jsp";
				}
				dao.update(mb);
				session.commit();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				session.close();
			}
			return "WEB-INF/view/changePwdSuccess.jsp";
		}
		return null;
	}

}
