package com.luxurycity.clc.util;

import java.io.*;
import java.util.*;
/**
 * 기반정보를 보기 쉽게 한 줄 단위로 가공하고
 * ArrayList 형태로 저장해서 바로 DB에 저장할 수 있도록 만들어주는 클래스
 * 
 * @author		권영선
 * @since		2020.11.21
 * @version		v.1.0
 *
 */
public class BaseFileProc {
	FileInputStream fin;
	PrintStream ps;
	FileReader fr;
	BufferedReader br;
	
	// 한 줄 단위로 가공한 파일을 다시 '|' 단위로 끊어서, ArrayList로 만드는 클래스
	public ArrayList<HashMap<String, String>> getDataList(String loc, ArrayList<String> keyList){
		 ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		 
		 // 문자단위 타겟 스트림 준비
		 fr = null;
		 // 문자단위 필터스트림 준비
		 br = null;
		 try {
			 // 타겟 스트림 만들고
			 fr = new FileReader(loc);
			 br = new BufferedReader(fr);
			 
			 // 반복해서 읽어들이고
			 while(true) {
				 // 1. 한 줄 데이터 담을 해쉬맵 만들고
				 HashMap<String, String> map = new HashMap<String, String>();
				 
				 // 2. 한 줄 읽는다.
				 String line = br.readLine();
				 if(line == null) {
					 break;
				 }
				 
				 // 3. '|' 단위로 자르고
				 StringTokenizer token = new StringTokenizer(line, "|");
				 
				 // 4. 매개변수로 받은 키값에 따라 데이터 집어넣기
				 int i = 0;
				 while(token.hasMoreElements()) {
					 map.put(keyList.get(i), token.nextToken());
					 i++;
				 }
				 
				 // 5. 완성된 맵 list에 담고
				 list.add(map);
			 }
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 try {
				 br.close();
				 fr.close();
			 } catch(Exception e) {}
		 }
		 System.out.println("### 리스트 가져오기 성공");
		 // 완성된 리스트 반환하고
		 return list;
	}
	
	// 파일의 내용을 한 줄의 String 문자열로 변환 처리 함수
	public String getFileToString(String loc) {
		StringBuffer buff = new StringBuffer();
		
		fin = null;
		try {
			// 파일 경로에 따른 FileInputStream 생성
			fin = new FileInputStream(loc);
			// 파일 정보를 담을 byte 설정
			byte[] tmp = new byte[8192];
			
			while(true) {
				Arrays.fill(tmp, (byte)0);
				int len = fin.read(tmp);
				if(len == -1) {
					break;
				}
				String str = new String(tmp, 0, len);
				buff.append(str);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch(Exception e) {}
		}
		
		return buff.toString();
	}
	
	// 변환한 문자열을 '^' 토큰 단위로 끊어서 한줄씩 새로운 파일에 저장하는 함수
	public void makeNewFile(String allFile, String newFileLoc) {
		StringTokenizer token = new StringTokenizer(allFile, "^");
		
		PrintStream ps = null;
		try {
			ps = new PrintStream(newFileLoc);
			
			while(token.hasMoreElements()) {
				ps.println(token.nextToken());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ps.close();
		}
		
		System.out.println("### 저장 완료!");
	}
	
	public BaseFileProc() {}
	
	public static void main(String[] args) {
		new BaseFileProc();
	}
}
