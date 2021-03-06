package com.kh.spring.board.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.spring.board.model.dto.Board;
import com.kh.spring.common.util.file.FileDTO;

@Mapper
public interface BoardRepository {

	@Insert("insert into file_info (fl_idx,type_idx, origin_file_name, rename_file_name, save_path)"
			+ " values(sc_file_idx.nextval, sc_board_idx.currval,#{originFileName}, #{renameFileName}, #{savePath})")
	void insertFileInfo(FileDTO fileDTO);
	
	@Insert("insert into board(bd_idx,user_id,title,content)"
			+ " values(sc_board_idx.nextval, #{userId}, #{title}, #{content})")
	void insertBoard(Board board);

	@Select("select * from board where bd_idx = #{bdIdx}")
	Board selectBoardByIdx(String bdIdx);
	
	@Select("select * from file_info where type_idx = #{bdIdx}")
	List<FileDTO> selectFilesByBdIdx(String bdIdx);
}
