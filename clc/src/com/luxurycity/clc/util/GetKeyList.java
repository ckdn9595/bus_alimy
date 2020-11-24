package com.luxurycity.clc.util;

import java.util.*;
/**
 * 기반정보의 키값들을 반환해주는 클래스
 * 
 * @author		권영선
 * @since		2020.11.21
 * @version		v.1.0
 *
 */
public class GetKeyList {
	ArrayList<String> list;
	public String station = "STATION_ID|STATION_NM|CENTER_ID|CENTER_YN|X|Y|REGION_NAME|MOBILE_NO|DISTRICT_CD";
	public String route = "ROUTE_ID|ROUTE_NM|ROUTE_TP|ST_STA_ID|ST_STA_NM|ST_STA_NO|ED_STA_ID|ED_STA_NM|ED_STA_NO|UP_FIRST_TIME|UP_LAST_TIME|DOWN_FIRST_TIME|DOWN_LAST_TIME|PEEK_ALLOC|NPEEK_ALLOC|COMPANY_ID|COMPANY_NM|TEL_NO|REGION_NAME|DISTRICT_CD|";
	public String routeStation = "ROUTE_ID|STATION_ID|UPDOWN|STA_ORDER|ROUTE_NM|STATION_NM";
	
	public ArrayList<String> getKey(String titles){
		list = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(titles, "|");
		while(token.hasMoreElements()) {
			list.add(token.nextToken());
		}
		return list;
	}
	
}