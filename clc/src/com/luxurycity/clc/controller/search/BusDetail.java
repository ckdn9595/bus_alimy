package com.luxurycity.clc.controller.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;

public class BusDetail implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/search/BusDetail";
		return view;
	}

}
