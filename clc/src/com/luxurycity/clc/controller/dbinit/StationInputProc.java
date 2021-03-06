package com.luxurycity.clc.controller.dbinit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.BusDBInitDao;

import java.util.*;
import com.luxurycity.clc.util.*;
import com.luxurycity.clc.vo.*;
import com.luxurycity.clc.sql.*;

public class StationInputProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String view = "/clc/main.clc";
		// 1. 기반정보를 처리할 클래스와 키값을 가져올 클래스 인스턴스 생성하고
		BaseFileProc bp = new BaseFileProc();
		GetKeyList gk = new GetKeyList();
		
		// 2. 키값들 가져올 리스트 생성하고 키값 받고
		ArrayList<String> stationKeys = gk.getKey(gk.station);
		String path = BaseFileProc.class.getResource("").getPath() + "stationInfo.txt";
//		System.out.println(path);
		
		// 3. 데이터 리스트 가져오고
		ArrayList<HashMap<String, String>> station = bp.getDataList(path, stationKeys);
		
		/*
		// 출력해보자.
		for(int i = 1; i < 30; i++) {
			System.out.println("###################################");
			for(int j = 0; j < stationKeys.size(); j++) {
				System.out.println(stationKeys.get(j) + " : " + station.get(i).get(stationKeys.get(j)));
			}
		}
		*/
		
		// 4. dao 만들고 디비 처리하고
		int cnt = 0;
		BusDBInitDao bDao = new BusDBInitDao();
		cnt = bDao.initStation(station);
		
		System.out.println("### " + cnt + " 개의 행이 입력되었습니다. ###");
		
		return view;
	}

}
