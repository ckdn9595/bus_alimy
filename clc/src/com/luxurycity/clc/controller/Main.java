package com.luxurycity.clc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;

public class Main implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "main";
		return view;
	}

}
