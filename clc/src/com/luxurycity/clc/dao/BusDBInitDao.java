package com.luxurycity.clc.dao;

import java.sql.*;

import com.luxurycity.clc.sql.BusDBInitSQL;
import com.luxurycity.clc.vo.*;
import db.*;
import java.util.*;

public class BusDBInitDao {
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	BusDBInitSQL bSQL;
	
	public BusDBInitDao() {
		db = new ClsDBCP();
		bSQL = new BusDBInitSQL();
	}
	
	// station 테이블에 데이터를 집어넣는 데이터베이스 작업 전담 처리 함수
	public int initStation(ArrayList<HashMap<String, String>> station) {
		int cnt = 0;
		// 커넥션 생성
		con = db.getCon();
		// sql문 가져오기
		String sql = bSQL.getSQL(bSQL.INIT_STATION);
		try {
			// station list의 사이즈만큼 반복
			for(int i = 1; i < station.size(); i++) {
				// pstmt 생성
				pstmt = db.getPSTMT(con, sql);
				
				pstmt.setInt(1, Integer.parseInt(station.get(i).get("STATION_ID")));
				pstmt.setString(2, station.get(i).get("STATION_NM"));
				pstmt.setDouble(3, Double.parseDouble(station.get(i).get("X")));
				pstmt.setDouble(4, Double.parseDouble(station.get(i).get("Y")));
				pstmt.setString(5, station.get(i).get("MOBILE_NO"));
				pstmt.setInt(6, Integer.parseInt(station.get(i).get("DISTRICT_CD")));
				
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
	
	// route 테이블에 데이터를 집어넣는 데이터베이스 작업 전담 처리 함수
	public int initRoute(ArrayList<HashMap<String, String>> route) {
		int cnt = 0;
		// 커넥션 생성
		con = db.getCon();
		// sql문 가져오기
		String sql = bSQL.getSQL(bSQL.INIT_ROUTE);
		try {
			// route list의 사이즈만큼 반복
			for(int i = 1; i < route.size(); i++) {
				// pstmt 생성
				pstmt = db.getPSTMT(con, sql);
				
				pstmt.setInt(1, Integer.parseInt(route.get(i).get("ROUTE_ID")));
				pstmt.setString(2, route.get(i).get("ROUTE_NM"));
				pstmt.setInt(3, Integer.parseInt(route.get(i).get("ROUTE_TP")));
				pstmt.setInt(4, Integer.parseInt(route.get(i).get("ST_STA_ID")));
				pstmt.setInt(5, Integer.parseInt(route.get(i).get("ED_STA_ID")));
				pstmt.setString(6, route.get(i).get("UP_FIRST_TIME"));
				pstmt.setString(7, route.get(i).get("UP_LAST_TIME"));
				pstmt.setString(8, route.get(i).get("DOWN_FIRST_TIME"));
				pstmt.setString(9, route.get(i).get("DOWN_LAST_TIME"));
				pstmt.setInt(10, Integer.parseInt(route.get(i).get("PEEK_ALLOC")));
				pstmt.setInt(11, Integer.parseInt(route.get(i).get("NPEEK_ALLOC")));
				pstmt.setInt(12, Integer.parseInt(route.get(i).get("DISTRICT_CD")));
				
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
	
	// routestation 테이블에 데이터를 집어넣는 데이터베이스 작업 전담 처리 함수
	public int initRouteStation(ArrayList<HashMap<String, String>> routestation) {
		int cnt = 0;
		// 커넥션 생성
		con = db.getCon();
		// sql문 가져오기
		String sql = bSQL.getSQL(bSQL.INIT_ROUTESTATION);
		try {
			// routestation list의 사이즈만큼 반복
			for(int i = 1; i < routestation.size(); i++) {
				// pstmt 생성
				pstmt = db.getPSTMT(con, sql);
				
				pstmt.setInt(1, Integer.parseInt(routestation.get(i).get("ROUTE_ID")));
				pstmt.setInt(2, Integer.parseInt(routestation.get(i).get("STA_ORDER")));
				pstmt.setInt(3, Integer.parseInt(routestation.get(i).get("STATION_ID")));
				pstmt.setString(4, routestation.get(i).get("UPDOWN"));
				
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
}
