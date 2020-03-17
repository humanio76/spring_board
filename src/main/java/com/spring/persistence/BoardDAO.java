package com.spring.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;
import static com.spring.persistence.JDBCUtil.*;

//@Component("dao")
@Repository("dao")
public class BoardDAO {
	public int insert(BoardVO vo) {
		int result=0;
		String sql="insert into spring_board(bno,title,content,writer) values(seq_board.nextVal,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {			
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			result=pstmt.executeUpdate();
			if(result>0) {
				commit(con);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			rollback(con);
		}finally {
			close(con);
			close(pstmt);
		}
		return result;
	}
	
	public List<BoardVO> getList(){
		String sql = "select * from spring_board";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) { 
				while(rs.next()) {
					BoardVO vo = new BoardVO();
					vo.setBno(rs.getInt("bno"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setContent(rs.getNString("content"));					
					vo.setRegdate(rs.getDate("regdate"));
					list.add(vo);
				}	
				
				
		}catch (Exception e) {
				e.printStackTrace();
					
		}
		return list;					
		
	}

}
