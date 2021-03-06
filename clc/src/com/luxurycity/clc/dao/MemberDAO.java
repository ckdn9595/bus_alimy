package com.luxurycity.clc.dao;

import db.ClsDBCP;
import java.sql.*;

import com.luxurycity.clc.sql.*;
import com.luxurycity.clc.vo.*;

public class MemberDAO {
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberSQL mSQL;
	
	public MemberDAO() {
		db = new ClsDBCP();
		mSQL = new MemberSQL();
	}
	public int getIdCheck(String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_ID_CK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int getLoginCnt(String id, String pw) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_LOGIN_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
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
//	public int getJoin(MemberVO vo) {
//		int cnt = 0 ; 
//		con = db.getCon()	;
//		String sql = mSQL.getSQL(mSQL.MEM_JOIN);
//		pstmt = db.getPSTMT(con, sql);
//		try {
//			pstmt.setString(1, vo.getId());
//			pstmt.setString(2, vo.getPw());
//			pstmt.setString(3, vo.getEmail());
//			pstmt.setString(4, vo.getPque());
//			pstmt.setString(5, vo.getPans());
//			
//			cnt = pstmt.executeUpdate()	;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			db.close(pstmt);
//			db.close(con);
//		}
//		
//		return cnt;
//	}
}
