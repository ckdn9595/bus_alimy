package com.luxurycity.clc.controller.member;
import javax.servlet.http.*;

import com.luxurycity.clc.controller.*;

public class LogOut implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/clc/main.clc";
		req.setAttribute("isRedirect", true);
		try {
			req.getSession().removeAttribute("SID");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return view;
	}

}