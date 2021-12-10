package com.kh.test.board.model.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.test.board.model.vo.Board.Board;

@Repository
public class BoardRepository implements BoardMapper{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private BoardMapper boardMapper;
	
	
	public Board selectBoard(String bId) {
		
		
		Board board = boardMapper.selectBoard(bId);
		
		
		
		return board;
		
		
	}

	

	
	
	
}
