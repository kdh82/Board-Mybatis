package com.dgit.member.model;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
	public void insert(Member mem) throws SQLException;
	public Member selectById(String id) throws SQLException;
	public List<Member> selectList() throws SQLException;
	public void update(Member mem) throws SQLException;
}
