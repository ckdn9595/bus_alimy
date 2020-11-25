package com.luxurycity.clc.sql;

public class FindSQL {
	public final int ID_COUNT = 1001;
	public final int FIND_ID = 1002;
	public final int SEL_QUEST_LIST = 1003;	
	public final int FIND_PW = 1004;
	
	public final int EDIT_PW = 2001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case ID_COUNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	mail = ? ");
			break;
		case FIND_ID:
			buff.append("SELECT ");
			buff.append("    id ");
			buff.append("FROM ");
			buff.append("    member ");
			buff.append("WHERE ");
			buff.append("    mail = ? ");
			break;
		case SEL_QUEST_LIST:
			buff.append("SELECT ");
			buff.append("    qno, quest ");
			buff.append("FROM ");
			buff.append("    quest ");
			break;
		case FIND_PW:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    find f, member m ");
			buff.append("WHERE ");
			buff.append("    f.mno = m.mno ");
			buff.append("    AND id = ? ");
			buff.append("    AND qno = ? ");
			buff.append("    AND answer = ? ");
			break;
		case EDIT_PW:
			buff.append("UPDATE ");
			buff.append("    member ");
			buff.append("SET ");
			buff.append("    pw = ? ");
			buff.append("WHERE ");
			buff.append("    id = ? ");
			break;
		}
		return buff.toString();
	}
}
