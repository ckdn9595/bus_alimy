package com.luxurycity.clc.sql;

public class SearchSQL {
	
		public final int SEL_BUS_LIST = 1005;
	
		
		public String getSQL(int code) {
			StringBuffer buff = new StringBuffer();
			switch(code) {
			case SEL_BUS_LIST:
				buff.append("select ");
				buff.append("	route_NM, r.route_cd, route_tp ");
				buff.append("from ");
				buff.append("	route r, routetype t ");
				buff.append("where ");
				buff.append("	r.route_cd = t.route_cd ");
				buff.append("	and route_nm like ? ");
				break;
			}
			return buff.toString();
		}
}
