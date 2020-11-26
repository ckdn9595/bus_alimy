package com.luxurycity.clc.controller.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;
import java.util.*;

public class StationDetail implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/search/StationDetail";
		// 1. 파라미터 받고 StationVO에 저장하고
		StationVO sVO = new StationVO();
		sVO.setStation_id(Integer.parseInt(req.getParameter("stationid")));
		sVO.setStation_nn(req.getParameter("stationnm"));
		sVO.setMobile_no(req.getParameter("mobile"));
		sVO.setRegion(req.getParameter("region"));
		
		// 2. 해당 정류소를 경유하는 노선들 정보 가져오고
		SearchDAO sDAO = new SearchDAO();
		ArrayList<RouteVO> rlist = sDAO.getRouteStationDetail(sVO.getStation_id());
//		System.out.println(rlist.get(0).getRoute_nm());
		// 3. 정류소 정보와 경유 노선들 데이터 뿌리고
		req.setAttribute("SDATA", sVO);
		req.setAttribute("ROUTELIST", rlist);
		
		return view;
	}

}
