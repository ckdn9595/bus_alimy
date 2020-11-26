package com.luxurycity.clc.sql;

public class SearchSQL {
	
		public final int SEL_BUS_LIST = 1005;
		public final int SEL_ST_LIST = 1006;
	
		public final int STATION_DETAIL = 2001;
		
		public String getSQL(int code) {
			StringBuffer buff = new StringBuffer();
			switch(code) {
			case SEL_BUS_LIST:
				buff.append("select ");
				buff.append("    DISTINCT(route_id), route_NM, r.route_cd, route_tp, st_sta_nm, ed_sta_nm ");
				buff.append("from ");
				buff.append("    route r, routetype t,( ");
				buff.append("                        select ");
				buff.append("                            st_sta_id , station_nm st_sta_nm ");
				buff.append("                       from  ");
				buff.append("                             station, route ");
				buff.append("                        where ");
				buff.append("                           station_id  = st_sta_id  ");
				buff.append("                         ) st,( ");
				buff.append("                                select ");
				buff.append("                                 ed_sta_id , station_nm ed_sta_nm ");
				buff.append("                                  from  ");
				buff.append("                                       station, route ");
				buff.append("                               where ");
				buff.append("                                 station_id  = ed_sta_id  ");
				buff.append("                                  )ed ");
				buff.append("where ");
				buff.append(" 	r.ed_sta_id = ed.ed_sta_id ");
				buff.append(" 	 and ");
				buff.append("    r.st_sta_id = st.st_sta_id ");
				buff.append("    and ");
				buff.append("    r.route_cd = t.route_cd ");
				buff.append("    and route_nm like ? ");
				buff.append(" order by route_nm ");

				break;
			case SEL_ST_LIST:
				buff.append("select ");
				buff.append("station_id, station_nm, x, y, mobile_no, region ");
				buff.append("from  ");
				buff.append("    station s, district d ");
				buff.append("where ");
				buff.append("    station_nm like ? ");
				buff.append("    AND s.district_cd = d.district_cd ");
				buff.append("order by station_nm ");
				break;
			
			case STATION_DETAIL:
				buff.append("SELECT ");
				buff.append("    e.*, st.station_nm AS ed_station_nm ");
				buff.append("FROM ");
				buff.append("    ( ");
				buff.append("        SELECT ");
				buff.append("            r.route_nm AS route_nm, r.route_id route_id, region, ed_sta_id, route_tp ");
				buff.append("        FROM ");
				buff.append("            station s, routestation rs, route r, district d, routetype rt ");
				buff.append("        WHERE ");
				buff.append("            s.station_id = rs.station_id ");
				buff.append("            AND r.route_cd = rt.route_cd ");
				buff.append("            AND rs.route_id = r.route_id ");
				buff.append("            AND d.district_cd = r.district_cd ");
				buff.append("            AND s.station_id = ? ");
				buff.append("    )e, station st ");
				buff.append("WHERE ");
				buff.append("    ed_sta_id = station_id ");
				break;
			}
			return buff.toString();
		}
}
