package com.luxurycity.clc.dao;

import java.sql.*;
import java.util.*;

import com.luxurycity.clc.sql.*;
import com.luxurycity.clc.vo.*;
import com.luxurycity.clc.util.*;

import db.*;

public class BoardDao {
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	BoardSQL bSQL;
	
	public BoardDao() {
		db = new ClsDBCP();
		bSQL = new BoardSQL();
	}
	
	// 게시글 가져오기 전담 처리함수
	public ArrayList<BoardVO> getBoardList(PageUtil page) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		con = db.getCon();
		
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_LIST);
		
		pstmt = db.getPSTMT(con, sql);
		System.out.println("확인 시작 게시물 번호 : " + page.getStartCont());
		System.out.println("확인 끝 게시물 번호 : " + page.getEndCont());
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bVO = new BoardVO();
				bVO.setAfile(rs.getNString("afile"));
				bVO.setSid(rs.getNString("id"));
				bVO.setWdate(rs.getDate("wdate"));
				bVO.setWtime(rs.getTime("wdate"));
				bVO.setBno(rs.getInt("bno"));
				
				list.add(bVO);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("### BoardDao.getBoardList에서 질의명령 전달실패.");
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return list;
	}
	
	// 게시글 갯수 가져오는 전담 처리함수
	public int getCnt() {
		int cnt = 0;
		
		con = db.getCon();
		
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_CNT);
		
		stmt = db.getSTMT(con);
		
		try {
			rs.next();
			
			cnt = rs.getInt("cnt");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("### BoardDao.getCnt에서 질의명령 전달실패. ###");
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 게시글 추가 처리 전담 함수
	public int addBoard(BoardVO bVO) {
		int cnt = 0;
		
		con = db.getCon();
		
		String sql = bSQL.getSQL(bSQL.ADD_BOARD);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setNString(1, bVO.getSid());
			pstmt.setNString(2, bVO.getBody());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("### BoardDao.addBoard에서 질의명령 전닰실패. ###");
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 게시글 삭제 처리 전담 함수
	public int delBoard(int bno) {
		int cnt = 0;
		
		con = db.getCon();
		
		String sql = bSQL.getSQL(bSQL.DEL_BOARD);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setInt(1, bno);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("### BoardDao.delBoard에서 질의명령 전달실패. ###");
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	
	// 게시글 수정 전담 처리 함수
	public int editBoard(BoardVO bVO) {
		int cnt = 0;
		
		con = db.getCon();
		
		String sql = bSQL.getSQL(bSQL.EDIT_BOARD);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setNString(1, bVO.getBody());
			pstmt.setInt(2, bVO.getBno());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("### BoardDao.editBoard에서 질의명령 전달 실패.");
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

}
