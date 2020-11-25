package com.luxurycity.clc.controller.member;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.*;
import com.luxurycity.clc.dao.*;

public class LoginProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String view = "/clc/main.clc";
		
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		System.out.println(sid);
		System.out.println(spw);
		MemberDAO mDao = new MemberDAO();
		int cnt = mDao.getLoginCnt(sid, spw);
		System.out.println(cnt);
		if(cnt != 1) {
			view = "/clc/member/login.clc";
		} else {
			req.getSession().setAttribute("SID", sid);
		}
		return view;
	}

}
