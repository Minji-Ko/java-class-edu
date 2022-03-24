package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class qq {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String money;
		while(true) {
			System.out.print("금액(원):");
			money = br.readLine();
			if( Integer.parseInt(money) < 100000000 && Integer.parseInt(money) >= -1 ) break;
		}
		Korean(money);

	}
	private static void Korean(String money) {
		String[] number = {"","일","이","삼","사","오","육","칠","팔","구"};
		String[] unit = {"원","십","백","천","만","십","백","천"};
		String result = "";
		for(int i=0; i<money.length(); i++) {
			int n = money.charAt(i) - '0';
			result += number[n] + unit[money.length()-i-1];
		}
		System.out.printf("일금 %s", result);
	}
}
