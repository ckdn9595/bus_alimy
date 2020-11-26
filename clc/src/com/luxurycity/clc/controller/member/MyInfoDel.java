package com.luxurycity.clc.controller.member;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.*;
import com.luxurycity.clc.dao.*;

public class MyInfoDel implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/clc/main.clc";
		req.setAttribute("isRedirect", true);
		String id = (String)req.getSession().getAttribute("SID");
		
		MemberDAO mDao = new MemberDAO();
		
		int mno = mDao.getMno(id);
		String pw = req.getParameter("pw");
		int cnt = mDao.delMember(mno, pw);
		if(cnt == 1) {
			System.out.println("회원탈퇴 성공");
			req.getSession().removeAttribute("SID");
		} else {
			System.out.println("회원탈퇴 실패");
			view = "/clc/member/myinfo.clc";
		}
		return view;
	}

}
