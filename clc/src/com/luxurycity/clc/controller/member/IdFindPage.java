package com.luxurycity.clc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;
import java.util.*;

public class IdFindPage implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/FindPage";
	
		// 아디찾기 타입일 경우
		String type="idCk";
		req.setAttribute("TYPE", type);
		
		
		return view;
	}

}
