package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.persistence.BoardDAO;
import com.spring.domain.BoardVO;

//@Component("service")
@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired	
	private BoardDAO dao;

	@Override
	public boolean insertBoard(BoardVO vo) {		
		return dao.insert(vo)>0?true:false;
	}
	
	@Override
	public List<BoardVO> getList() {		
		return dao.getList();
	}
}
