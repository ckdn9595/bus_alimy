package com.luxurycity.clc.controller.member;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.*;
import com.luxurycity.clc.dao.*;

public class MyInfoEdit implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/clc/member/myinfo.clc";
		
		req.setAttribute("isRedirect", true);
		
		String sid = (String)req.getSession().getAttribute("SID");
		String mail = req.getParameter("email");
		
		MemberDAO mDao = new MemberDAO();
		int cnt = mDao.editMail(mail, sid);
		if(cnt == 1) {
			System.out.println("회원정보 수정 성공");
		} else {
			System.out.println("회원정보 수정 실패");
		}
		return view;
	}

}
