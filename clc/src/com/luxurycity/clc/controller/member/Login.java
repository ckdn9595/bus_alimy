package com.luxurycity.clc.controller.member;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;

public class Login implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/Login";
		return view;
	}

}
