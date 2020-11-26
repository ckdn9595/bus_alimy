package com.luxurycity.clc.sql;

public class BookmarkSQL {
	public final int SEL_STATION_LIST = 1001;
	public final int SEL_BUS_LIST = 1002;
	
	public final int DEL_BOOKMARK = 2001;
	
	public final int ADD_BUS_MARK = 3001;
	public final int ADD_STA_MARK = 3002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_STATION_LIST:
			buff.append("SELECT ");
			buff.append("    bmno, NVL(b.route_id, 0) route_id, NVL(b.station_id, 0) station_id, NVL(r.route_nm, 0) route_nm, NVL(s.station_nm, 0) station_nm, NVL(s.mobile_no, 0) mobile_no, NVL(region, 0) region ");
			buff.append("FROM ");
			buff.append("    bookmark b, route r, station s, district d ");
			buff.append("WHERE ");
			buff.append("    b.route_id = r.route_id(+) ");
			buff.append("    AND s.district_cd = d.district_cd(+) ");
			buff.append("    AND b.station_id = s.station_id(+) ");
			buff.append("    AND mno = ( ");
			buff.append("                   SELECT ");
			buff.append("                       mno ");
			buff.append("                   FROM ");
			buff.append("                       member ");
			buff.append("                   WHERE ");
			buff.append("                       id = ? ");
			buff.append("               ) ");
			buff.append("    AND b.route_id IS NULL ");
			buff.append("    AND isshow = 'Y' ");
			break;
		case SEL_BUS_LIST:
			buff.append("SELECT ");
			buff.append("    s.*, station.station_nm AS ed_station_nm ");
			buff.append("FROM ");
			buff.append("        ( ");
			buff.append("            SELECT ");
			buff.append("                bmno, NVL(b.route_id, 0) route_id, NVL(b.station_id, 0) station_id, NVL(r.route_nm, 0) route_nm, NVL(s.station_nm, 0) station_nm, NVL(s.mobile_no, 0) mobile_no, route_tp ");
			buff.append("            FROM ");
			buff.append("                bookmark b, route r, station s, routetype t ");
			buff.append("            WHERE ");
			buff.append("                r.route_cd = t.route_cd ");
			buff.append("                AND b.route_id = r.route_id(+) ");
			buff.append("                AND b.station_id = s.station_id(+) ");
			buff.append("                AND mno = ( ");
			buff.append("                               SELECT ");
			buff.append("                                   mno ");
			buff.append("                               FROM ");
			buff.append("                                   member ");
			buff.append("                               WHERE ");
			buff.append("                                   id = ? ");
			buff.append("                          ) ");
			buff.append("                AND isshow = 'Y' ");
			buff.append("        ) s, route, station ");
			buff.append("WHERE ");
			buff.append("    s.route_id = route.route_id ");
			buff.append("    AND ed_sta_id = station.station_id ");
			break;
		case ADD_BUS_MARK:
			buff.append("INSERT into ");
			buff.append("	bookmark ");
			buff.append("values( ");
			buff.append("		(select NVL(MAX(bmno)+1,1001) from bookmark), ");
			buff.append("		1001, ?, null, 'Y' ");
			buff.append(" 		) ");
			break;
		case ADD_STA_MARK:
			buff.append("INSERT into ");
			buff.append("	bookmark ");
			buff.append("values( ");
			buff.append("		(select NVL(MAX(bmno)+1,1001) from bookmark), ");
			buff.append("		1001, null, ? , 'Y' ");
			buff.append(" 		) ");
			break;
		}
		return buff.toString();
	}
}
