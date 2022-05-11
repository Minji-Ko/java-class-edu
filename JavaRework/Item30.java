package com.test.java;

import java.util.Calendar;

public class Item30 {

	public static void main(String[] args) {
		
		//[SUMMARY] 시각 차이 구하기(Calendar 클래스) (2022. 3. 17. 오전 1:11:01)
		
		Calendar now = Calendar.getInstance(); 
		
		Calendar christmas = Calendar.getInstance();
		christmas.set(now.get(Calendar.YEAR), 11, 25, 0, 0, 0);

		long nowTick = now.getTimeInMillis();
		long christmasTick = christmas.getTimeInMillis();
		
		//남은 일수
		long time = (christmasTick - nowTick) / 1000 / 60 / 60 / 24 + 2; //+2는 보정값 
	}
}
