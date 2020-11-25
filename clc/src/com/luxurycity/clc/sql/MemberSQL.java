package com.luxurycity.clc.sql;

public class MemberSQL {
	public final int MEM_ID_CK = 1001;
	public final int MEM_LOGIN_CNT = 1002;
	public final int MEM_JOIN = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case MEM_ID_CK:
			buff.append("SELECT COUNT(*) cnt ");
			buff.append("FROM MEMBER ");
			buff.append("WHERE  id = ? and isshow = 'Y' ");
			break;
		case MEM_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    id = ? ");
			buff.append("    AND pw = ? ");
			buff.append("    AND isshow = 'Y' ");
			break;
		case MEM_JOIN:
			buff.append("INSERT INTO MEMBER ");
			buff.append("MEMBER(MNO, ID, PW, EMAIL, P_QUE, P_ANS) ");
			buff.append("VALUES( ");
			buff.append("(SELECT NVL(MAX(MNO)+1, 1001) FROM MEMBER), ");
			buff.append(" ?, ?, ?, ?, ?) ");
			break;
			
		}
		return buff.toString();
	}

}
