package com.luxurycity.clc.controller.member;
import javax.servlet.http.*;

import com.luxurycity.clc.controller.*;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;

public class JoinProc implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/clc/main.clc";
		req.setAttribute("isRedirect", true);
		
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		String sname = req.getParameter("name");
		String smail = req.getParameter("mail");
		String sgen = req.getParameter("gen");
		String savt = req.getParameter("avatar");
		String sqt = req.getParameter("qt");
		String sans = req.getParameter("ans");
		
		MemberVO mVO = new MemberVO();
		
		mVO.setId(sid);
		mVO.setPw(spw);
		mVO.setName(sname);
		mVO.setMail(smail);
		mVO.setGen(sgen);
		mVO.setAno(Integer.parseInt(savt));
		
		// 멤버 테이블에 데이터 저장
		MemberDAO mDao = new MemberDAO();
		int cnt1 = mDao.getJoin(mVO);
		
		if(cnt1 == 0) {
			view = "/clc/member/join.clc";
		} else {
			// 멤버 테이블에 저장된 회원의 번호 가져오기
			int mno = mDao.getMno(sid);
			FindVO fVO = new FindVO();
			fVO.setMno(mno);
			fVO.setQno(Integer.parseInt(sqt));
			fVO.setAnswer(sans);
			
			// find 테이블 데이터 저장
			FindDAO fDao = new FindDAO();
			int cnt2 = fDao.addFind(fVO);
			
			if(cnt2 == 0) {
				view = "/clc/member/join.clc";
			} else {
				req.getSession().setAttribute("SID", sid);
//				req.getSession().setAttribute("SAVT", savt);
			}
		}
		return view;
	}

}

