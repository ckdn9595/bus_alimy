package com.luxurycity.clc.dao;

import java.util.*;

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
		System.out.println("여기는 나오냐?");
		String sql = mSQL.getSQL(mSQL.MEM_ID_CK);
		System.out.println("씨발 머지" + sql);
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
	
	// 로그인 전담 처리 함수
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
	
	// 아바타 정보 가져오기 전담 처리 함수
	public ArrayList<AvatarVO> getAvtInfo() {
		ArrayList<AvatarVO> list = new ArrayList<AvatarVO>();
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_AVT_INFO);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				AvatarVO aVO = new AvatarVO();
				aVO.setAno(rs.getInt("ano"));
				aVO.setAfile(rs.getString("afile"));
				aVO.setDir(rs.getString("dir"));
				aVO.setGen(rs.getString("gen"));
				
				list.add(aVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	// 질문 가져오기 전담 처리 함수
	public ArrayList<FindVO> getQuest() {
		ArrayList<FindVO> list = new ArrayList<FindVO>();
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_QUE_INFO);
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
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	// 멤버 회원가입 전담 처리함수
	public int getJoin(MemberVO mVO) {
		int cnt = 0 ; 
		con = db.getCon()	;
		String sql = mSQL.getSQL(mSQL.MEM_JOIN);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mVO.getId());
			pstmt.setString(2, mVO.getPw());
			pstmt.setString(3, mVO.getName());
			pstmt.setString(4, mVO.getMail());
			pstmt.setString(5, mVO.getGen());
			pstmt.setInt(6, mVO.getAno());
			
			cnt = pstmt.executeUpdate()	;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 회원가입한 회원의 회원번호 가져오기 함수
	public int getMno(String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_GET_MNO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			cnt = rs.getInt("mno");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 아이디 체크 데이터 베이스 전담 처리함수
	public int getIdCnt(String id) {
		int cnt = 0 ;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_ID_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
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
	
	// 회원정보 아바타, 이메일 가져오기 전담 처리 함수
	public MemberVO getAvtAll(String id) {
		MemberVO mVO = new MemberVO();
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_GET_AVT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			mVO.setAfile(rs.getString("afile"));
			// dir
			mVO.setName(rs.getString("dir"));
			mVO.setAno(rs.getInt("ano"));
			mVO.setMail(rs.getString("mail"));
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}
	
	// 이메일 바꾸기 전담 처리 함수
	public int editMail(String mail, String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_EDIT_MAIL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, mail);
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
	
	// 회원정보 삭제 함수
	public int delMember(int mno, String pw) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.MEM_INFO_DEL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, mno);
			pstmt.setString(2, pw);
			
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
