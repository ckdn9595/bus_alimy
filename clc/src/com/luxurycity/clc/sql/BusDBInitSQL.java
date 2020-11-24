package com.luxurycity.clc.sql;
/*
	DB에 기반데이터(정류소, 노선, 경유노선)들을
	INSERT 하기 위한 SQL문들을 작성하는 클래스
 */
public class BusDBInitSQL {
	public final int INIT_STATION = 1001;
	public final int INIT_ROUTE = 1002;
	public final int INIT_ROUTESTATION = 1003;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case INIT_STATION:
			buff.append("INSERT INTO ");
			buff.append("    station ");
			buff.append("VALUES( ");
			buff.append("    ?, ?, ?, ?, ?, ? ");
			buff.append(") ");
			break;
		}
		return buff.toString();
	}
}
