package com.dgit.member.handler;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;

import com.dgit.controller.CommandHandler;
import com.dgit.member.model.Member;
import com.dgit.member.model.MemberDao;
import com.dgit.utill.MySqlSessionFactory;

public class IdCheckHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Map<String, String> map = new HashMap<>();
			//id 중복 체크
			Member member = dao.selectById(id);
				
			if(member == null){
				map.put("result", "usable");
				
			}else{
				map.put("result", "duplicated");
			}
				res.setContentType("application/json;charset=utf-8");
				ObjectMapper om = new ObjectMapper();  // json-core-asl 라이브러리사용
				String json = om.writeValueAsString(map); //객체의 값을 json string으로 변환함.				
				PrintWriter pw = res.getWriter();
				pw.print(json);//response에 json string을 담음.
				pw.flush();
			
		}finally{
			session.close();
		}
		return null;
	}

}
