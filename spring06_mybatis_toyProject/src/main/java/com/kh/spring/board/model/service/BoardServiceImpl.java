package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dto.Board;
import com.kh.spring.board.model.repository.BoardRepository;
import com.kh.spring.common.util.file.FileDTO;
import com.kh.spring.common.util.file.FileUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;

	public void insertBoard(List<MultipartFile> multiparts, Board board) {
		boardRepository.insertBoard(board);
		
		FileUtil util = new FileUtil();
		for (MultipartFile multipartFile : multiparts) {
			
			if(multipartFile.isEmpty()) {
				boardRepository.insertFileInfo(util.FIleUpload(multipartFile));
			}//파일업로드 예외처리 파일없이 게시글 올렸을때
			
		}
		
	}

	@Override
	public Map<String, Object> selectBoardByIdx(String bdIdx) {
		
		Board board = boardRepository.selectBoardByIdx(bdIdx);
		List<FileDTO> files = boardRepository.selectFilesByBdIdx(bdIdx);
		
		return Map.of("board",board,"files",files);
		
	}
}
