package com.luxurycity.clc.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionUtil {
	public static String procSession(HttpServletRequest req, HttpServletResponse resp) {
		String sid = "";
		try {
			sid = (String)req.getSession().getAttribute("SID");
		}catch(Exception e) {
			try {
				resp.sendRedirect("/cls/member/login.cls");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return sid;
	}
}