package com.luxurycity.clc.controller.search;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.SearchDAO;
import com.luxurycity.clc.vo.RouteVO;

public class BusDetail implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/search/BusDetail";
		return view;
	}

}
