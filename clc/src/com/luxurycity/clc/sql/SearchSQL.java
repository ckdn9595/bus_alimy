package com.luxurycity.clc.sql;

public class SearchSQL {
	
		public final int SEL_BUS_LIST = 1005;
		public final int SEL_ST_LIST = 1006;
	
		public final int SEL_BUS_DETAIL = 2005;

		public final int SEL_BUS_LIST_MYPAGE = 2005;
		
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

			case SEL_BUS_DETAIL:
				buff.append("SELECT ");
				buff.append("	rs.direction direction, d.region region, s.station_nm station_nm, ");
				buff.append("	s.mobile_no mobile_no, rs.str_order str_order, r.peek_alloc peek, r.npeek_alloc npeek ");
				buff.append("FROM ");
				buff.append("	routestation rs, station s, district d, route r ");
				buff.append("WHERE ");
				buff.append("	rs.route_id = ? ");
				buff.append("	AND rs.station_id = s.station_id ");
				buff.append("	AND s.district_cd = d.district_cd ");
				buff.append("	AND rs.route_id = r.route_id ");
				buff.append("ORDER BY ");
				buff.append("	str_order ");
				break;
				
			}
			return buff.toString();
		}
}
