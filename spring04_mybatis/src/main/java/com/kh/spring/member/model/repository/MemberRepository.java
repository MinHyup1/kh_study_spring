package com.kh.spring.member.model.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
	
	@Autowired
	private SqlSession session;

	public String selectPasswordByUserId(String userId) {
		return session.selectOne("com.kh.spring.mybatis.MybatisMapper.selectPasswordByUserId",userId);
	}

}
