package com.luxurycity.clc.dao;

import java.sql.*;
import db.*;
import com.luxurycity.clc.sql.*;
import java.util.*;
import com.luxurycity.clc.vo.*;

public class FindDAO {
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	FindSQL fSQL;
	
	public FindDAO() {
		db = new ClsDBCP();
		fSQL = new FindSQL();
	}
	
	// 이메일로 아이디 찾기 데이터베이스 작업 전담 처리 함수
	public String findId(String mail) {
		String id = "";
		con = db.getCon();
		String sql = fSQL.getSQL(fSQL.FIND_ID);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			rs.next();
			
			id = rs.getString("id");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return id;
	}
	
	// 해당 메일의 아이디가 존재하는지 검사하는 작업 전담 처리 함수
	public int idCount(String mail) {
		int cnt = 0;
		con = db.getCon();
		String sql = fSQL.getSQL(fSQL.ID_COUNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mail);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 비번찾기 질문 목록 리스트 가져오는 데이터베이스 작업 전담 처리 함수
	public ArrayList<FindVO> getQuestList(){
		ArrayList<FindVO> list = new ArrayList<FindVO>();
		con = db.getCon();
		String sql = fSQL.getSQL(fSQL.SEL_QUEST_LIST);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				FindVO fVO = new FindVO();
				fVO.setQno(rs.getInt("qno"));
				fVO.setQuest(rs.getString("quest"));
				
				list.add(fVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	
	// 질문과 아이디가 일치하는지 검사하는 데이터베이스 작업 전담 처리 함수
	public int pwCheck(String id, int qno, String answer) {
		int cnt = 0;
		con = db.getCon();
		String sql = fSQL.getSQL(fSQL.FIND_PW);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setInt(2, qno);
			pstmt.setString(3, answer);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 비밀번호 변경 데이터베이스 작업 전담 처리 함수
	public int pwEdit(String pw, String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = fSQL.getSQL(fSQL.EDIT_PW);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
