package com.kh.test.board.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.test.board.model.vo.Board.Board;

@Mapper
public interface BoardMapper {
	
	@Select("select * from board where BID=#{bId}")
	public Board selectBoard(String bId);

}
