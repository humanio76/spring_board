package com.spring.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

public class BoardClient {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");		
		BoardService service=(BoardService) ctx.getBean("service");
		
		//글 등록 테스트
//		BoardVO vo = new BoardVO();
//		vo.setTitle("스프링 DI 테스트");
//		vo.setContent("스프링 DI 테스트");
//		vo.setWriter("홍길동");
//		System.out.println(service.insertBoard(vo)?"삽입성공":"삽입실패");
		
		//전체 리스트 가져오기
		List<BoardVO> list =service.getList();
		System.out.println(list);
	}
}
