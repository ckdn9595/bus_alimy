package com.luxurycity.clc.dao;
import db.ClsDBCP;
import java.sql.*;
import java.util.ArrayList;

import com.luxurycity.clc.sql.*;
import com.luxurycity.clc.vo.*;

public class SearchDAO {
		ClsDBCP db;
		Connection con;
		Statement stmt;
		PreparedStatement pstmt;
		ResultSet rs;
		SearchSQL sSQL;
		
		public SearchDAO() {
			db = new ClsDBCP();
			sSQL = new SearchSQL();
		}
		public ArrayList<RouteVO> getBusCheck(String Bus) {
			ArrayList<RouteVO> list = new ArrayList<RouteVO>();
			con = db.getCon();
			String sql = sSQL.getSQL(sSQL.SEL_BUS_LIST);
			
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setString(1, Bus+ "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					RouteVO vo = new RouteVO();
					vo.setRoute_nm(rs.getString("route_NM"));
					vo.setRoute_cd(rs.getInt("route_cd"));
					vo.setRoute_tp(rs.getString("route_tp"));
					vo.setRoute_id(rs.getInt("route_id"));
					vo.setSt_sta_nm(rs.getString("st_sta_nm"));
					vo.setEd_sta_nm(rs.getString("ed_sta_nm"));
					list.add(vo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			return list;
		}
		public ArrayList<StationVO> getstaCheck(String sta) {
			ArrayList<StationVO> list = new ArrayList<StationVO>();
			con = db.getCon();
			String sql = sSQL.getSQL(sSQL.SEL_ST_LIST);
			
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setString(1, sta+ "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					StationVO vo = new StationVO();
					vo.setStation_id(rs.getInt("station_id"));
					vo.setStation_nn(rs.getString("station_nm"));
					vo.setLoc_x(rs.getDouble("x"));
					vo.setLoc_y(rs.getDouble("y"));
					vo.setMobile_no(rs.getString("mobile_no"));
					vo.setRegion(rs.getNString("region"));
					list.add(vo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			return list;
		}
		
		// 버스 노선 상세정보 처리 전담 함수
		public ArrayList<RouteVO> getRouteDetail(int route_id) {
			ArrayList<RouteVO> list = new ArrayList<RouteVO>();
			
			con = db.getCon();
			
			String sql = sSQL.getSQL(sSQL.SEL_BUS_DETAIL);
			
			pstmt = db.getPSTMT(con, sql);
			
			try {
				pstmt.setInt(1, route_id);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					RouteVO rVO = new RouteVO();
					rVO.setDirection(rs.getNString("direction"));
					rVO.setRegion(rs.getNString("region"));
					rVO.setStation_nn(rs.getString("station_nm"));
					rVO.setMobile_no(rs.getNString("mobile_no"));
					rVO.setStr_order(rs.getInt("str_order"));
					rVO.setPeek_alloc(rs.getInt("peek"));
					rVO.setNpeek_alloc(rs.getInt("npeek"));
					
					list.add(rVO);
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("SearchDao.getRouteDetail에서 질의명령 전달 실패.");
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			
			return list;
		}
}
