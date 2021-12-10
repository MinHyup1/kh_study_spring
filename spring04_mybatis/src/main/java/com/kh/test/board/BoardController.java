package com.kh.test.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.kh.spring.member.model.service.MemberService;
import com.kh.test.board.model.vo.Board.Board;
import com.kh.test.board.model.vo.Board.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	public String selectBoard(String bId
							,Model model) {
		Board board = new Board();
		
		board = boardService.selectByBId(bId);
		
		model.addAttribute(board);
		
		if(board == null) {
			return "redirect:error.do";
		}
		
		
		return "boardDetail";
	}
}
