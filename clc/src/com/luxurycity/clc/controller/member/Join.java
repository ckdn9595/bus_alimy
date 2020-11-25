package com.luxurycity.clc.controller.member;

import java.util.*;

import javax.servlet.http.*;

import com.luxurycity.clc.controller.*;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;

public class Join implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/Join";
		
		MemberDAO mDao = new MemberDAO();
		ArrayList<AvatarVO> list = mDao.getAvtInfo();
		ArrayList<FindVO> quest = mDao.getQuest();
		
		req.setAttribute("LIST", list);
		req.setAttribute("QUE", quest);
		return view;
	}

}