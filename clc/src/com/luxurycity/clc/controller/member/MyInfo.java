package com.luxurycity.clc.controller.member;

import java.util.*;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.*;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;

public class MyInfo implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/MyInfo";
		
		String sid = (String)req.getSession().getAttribute("SID");
		MemberDAO mDao = new MemberDAO();
		
		MemberVO mVO = mDao.getAvtAll(sid);
		
		req.setAttribute("DATA", mVO);
		return view;
	}

}
