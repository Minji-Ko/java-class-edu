package com.test.java;

import java.util.Calendar;

public class Item48 {

	public static void main(String[] args) {
		
		//[SUMMARY] while문 무한루프 만들기 (2022. 3. 20. 오후 10:45:33)
		
		String sel = "4";
		
		boolean loop = true;
		
		while(loop) {
			
			if(sel.equals("1")) {
				//1
			} else if(sel.equals("2")) {
				//2
			} else if(sel.equals("3")){
				//3
			} else {
				//4 : 종료
				loop = false;
			}
		}
	}
}
