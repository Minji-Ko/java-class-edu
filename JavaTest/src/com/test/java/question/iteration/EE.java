package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EE {
	
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



		int sum = 0;
		int num = 0;
		String s = "";


		while (sum <= 100) {

			System.out.print("숫자:");
			num = Integer.parseInt(reader.readLine());



			if (num % 2 == 0) {


				sum += num;
				s += String.valueOf(num) + " + "; // String을 누적


			} else {


				sum -= num;
				s += String.valueOf(num) + " - ";

			}


		}


		System.out.println(s);
		System.out.printf("\b\b = %d ", sum);


	}
}
