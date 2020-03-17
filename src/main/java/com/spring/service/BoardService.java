package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	//등록
	public boolean insertBoard(BoardVO vo);
	//전체보기
	public List<BoardVO> getList();
}
