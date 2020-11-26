package com.luxurycity.clc.dao;

import java.sql.*;
import db.*;
import com.luxurycity.clc.sql.*;
import com.luxurycity.clc.vo.*;
import java.util.*;

public class BookmarkDAO {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	ClsDBCP db;
	BookmarkSQL bSQL;
	
	public BookmarkDAO() {
		db = new ClsDBCP();
		bSQL = new BookmarkSQL();
	}
	
	// 정류소 데이터 가져오는 데이터베이스 전담 처리 함수
	public ArrayList<BookmarkVO> getStationList(String id){
		ArrayList<BookmarkVO> list = new ArrayList<BookmarkVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_STATION_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookmarkVO bVO = new BookmarkVO();
				bVO.setBmno(rs.getInt("bmno"));
				bVO.setRoute_id(rs.getInt("route_id"));
				bVO.setStation_id(rs.getInt("station_id"));
				bVO.setRoute_nm(rs.getString("route_nm"));
				bVO.setStation_nm(rs.getString("station_nm"));
				bVO.setMobile_no(rs.getString("mobile_no"));
				bVO.setRegion(rs.getString("region"));
				
				list.add(bVO);
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
	
	// 버스 데이터 가져오는 데이터베이스 작업 전담 처리 함수
	public ArrayList<BookmarkVO> getBusList(String id){
		ArrayList<BookmarkVO> list = new ArrayList<BookmarkVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BUS_LIST);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookmarkVO bVO = new BookmarkVO();
				
				bVO.setBmno(rs.getInt("bmno"));
				bVO.setRoute_id(rs.getInt("route_id"));
				bVO.setStation_id(rs.getInt("station_id"));
				bVO.setRoute_nm(rs.getString("route_nm"));
				bVO.setStation_nm(rs.getString("station_nm"));
				bVO.setMobile_no(rs.getString("mobile_no"));
				bVO.setRoute_tp(rs.getString("route_tp"));
				bVO.setEd_station_nm(rs.getString("ed_station_nm"));
				
				list.add(bVO);
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
	
	// 즐겨찾기 리스트 삭제하는 데이터베이스 작업 전담 처리 함수
	public int delBookmark(int[] bmno) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.DEL_BOOKMARK);
		
		try {
			for(int i = 0; i < bmno.length; i++) {
				pstmt = db.getPSTMT(con, sql);
				pstmt.setInt(1, bmno[i]);
				
				cnt += pstmt.executeUpdate();
				
				db.close(pstmt);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(con);
		}
		return cnt;
	}
	public int AddBusMark(int busid) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_BUS_MARK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, busid);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int AddStaMark(int staid) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_STA_MARK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, staid);
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