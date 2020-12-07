package com.luxurycity.clc.controller.search;

import javax.servlet.http.*;

import java.util.*;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;

public class RouteProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/search/BusDetail";
		
		// form 태그로 넘어온 데이터 꺼내기
		String tmp[] = new String[5];
		tmp[0] = req.getParameter("routeid");
		tmp[1] = req.getParameter("routenm");
		tmp[2] = req.getParameter("routetype");
		tmp[3] = req.getParameter("routestnm");
		tmp[4] = req.getParameter("routeednm");
		
		// 데이터 자르기
		StringBuilder builder = new StringBuilder();
		for(int i = 1; i < tmp.length; i++) {
			StringTokenizer token = new StringTokenizer(tmp[i], ":");
			token.nextToken();
			builder.append(token.nextToken());
			tmp[i]=builder.toString().trim();

			builder.setLength(0);
		}
		
		int route_id = 0;
		try {
			route_id = Integer.parseInt(tmp[0]);
		} catch(Exception e) {}
		
		String route_nm = tmp[1];
		String st_sta_nm = tmp[3];
		String ed_sta_nm = tmp[4];
		
		// 데이터 넣고 가져오기
		SearchDAO sDao = new SearchDAO();
		
		ArrayList<RouteVO> list = sDao.getRouteDetail(route_id);
		
		req.setAttribute("ROUTE_ID", route_id);
		req.setAttribute("ROUTE_NM", route_nm);
		req.setAttribute("ST_STA_NM", st_sta_nm);
		req.setAttribute("ED_STA_NM", ed_sta_nm);
		
		// 아래 배차시간 두개의 경우 list에 담았지만 값이 동일하므로 한 개를 추출했다.
		req.setAttribute("PEEK", list.get(0).getPeek_alloc());
		req.setAttribute("NPEEK", list.get(0).getNpeek_alloc());
		req.setAttribute("ROUTE", list);
		return view;
	}

}
