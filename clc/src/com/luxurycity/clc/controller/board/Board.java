package com.luxurycity.clc.controller.board;

import javax.servlet.http.*;

import java.util.*;

import com.luxurycity.clc.controller.ClcMain;
import com.luxurycity.clc.dao.*;
import com.luxurycity.clc.vo.*;
import com.luxurycity.clc.util.*;

public class Board implements ClcMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "board/Board";

		BoardDao bDao = new BoardDao();

		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		} catch(Exception e) {}
		
		int total = 0;
		total = bDao.getCnt();
		
		PageUtil page = new PageUtil(nowPage, total);
		String sid = SessionUtil.procSession(req, resp);
		ArrayList<BoardVO> list = bDao.getBoardList(page);		

		
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		return view;
	}

}
