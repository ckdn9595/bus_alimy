package com.luxurycity.clc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.luxurycity.clc.vo.*;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.util.*;
import com.luxurycity.clc.controller.ClcMain;

public class Main implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "main";
		String sid = SessionUtil.procSession(req, resp);
		if(sid != null) {
			FindDAO fdao = new FindDAO();
			AvatarVO vo = fdao.findAvt(sid);
			req.getSession().setAttribute("AVT", vo);
		}
		return view;
	}

}
