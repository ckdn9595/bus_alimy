package com.luxurycity.clc.vo;
import java.sql.Date;
import java.sql.Time;
import java.text.*;
public class MemberVO {
	private int mno;
	private String id, pw, email, sdate, pque, pans;
	private Date wdate;
	private Time wtime;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("YYYY/MM/DD");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		sdate = form1.format(wdate)+ " " + form2.format(wtime);
	}
	public String getPque() {
		return pque;
	}
	public void setPque(String pque) {
		this.pque = pque;
	}
	public String getPans() {
		return pans;
	}
	public void setPans(String pans) {
		this.pans = pans;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public Time getWtime() {
		return wtime;
	}
	public void setWtime(Time wtime) {
		this.wtime = wtime;
		setSdate();
	}
	
}
