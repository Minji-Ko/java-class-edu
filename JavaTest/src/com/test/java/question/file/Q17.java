package com.test.java.question.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Q17 {

	public static void main(String[] args) {
		
/*
 	요구사항] 직원들의 지각과 조퇴를 카운트하시오.
			출근 : 오전 9시
			퇴근 : 오후 6시
	리소스]	파일 > 출결.dat
	출력]		[이름]    [지각]    [조퇴] 
			홍길동      4회       0회 
			아무개      0회       0회 
			하하하      2회       3회 
 */
		
		File file = new File("C:\\class\\java\\파일_입출력_문제\\출결.dat");
		
		if(!file.exists()) {
			System.out.println("파일의 경로를 찾을 수 없습니다.");
			return;
		}	
		
		if(!file.isFile()) {
			System.out.println("파일이 아닙니다.");
			return;
		}	

		try {
		
			ArrayList<Employee> employee = new ArrayList<Employee>();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
		
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Employee member = null;
				for(Employee e : employee) {
					if(e.getName().equals(temp[1])){
						member = e;
						break;
					}
				}
				
				if(member == null) {
					member = new Employee(temp[1]);
					employee.add(member);
				}
				
				//지각check
				int hour = Integer.parseInt(temp[2].split(":")[0]);
				int min = Integer.parseInt(temp[2].split(":")[1]);
				
				if(hour > 9 || hour == 9 && min > 0) {
					member.setLateCheck(temp[0], temp[2]);
				}

				
				//조퇴check
				hour = Integer.parseInt(temp[3].split(":")[0]);
				min = Integer.parseInt(temp[3].split(":")[1]);
				
				if(hour < 18) {
					member.setEarlyCheck(temp[0], temp[3]);
				}
	
			}
			
			reader.close();
		
			System.out.println("[이름]\t[지각]\t[조퇴]");
			
			for(Employee e : employee) {
				System.out.println(e); 
			}

		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	
	}
}

class Employee {	
	
	private String name;
	private ArrayList<String[]> lateCheck;  //지각
	private ArrayList<String[]> earlyCheck; //조퇴
	
	public Employee(String name) {
		this.name = name;
		//*mj* ArrayList 참조변수만 만들면 안되고 반드시 초기화를 해야 사용가능!!!
		this.lateCheck = new ArrayList<String[]>();  
		this.earlyCheck = new ArrayList<String[]>();
	}


	public String getName() {
		return name;
	}


	public String getLateCheck() {
		
		StringBuilder record = new StringBuilder(this.name + " 지각정보\n");
		
		for(String[] time : this.lateCheck) {
			record.append(time[0]);					
			record.append(" ");					
			record.append(time[1]);					
			record.append("\n");					
		}
		return record.toString();
	}


	public String getEarlyCheck() {
		
		StringBuilder record = new StringBuilder(this.name + " 조퇴정보\n");
		
		for(String[] time : this.earlyCheck) {
			record.append(time[0]);					
			record.append(" ");					
			record.append(time[1]);					
			record.append("\n");					
		}
		return record.toString();
	}


	public void setLateCheck(String lateDate, String lateTime) {
		String[] lateCheck = {lateDate, lateTime};
		this.lateCheck.add(lateCheck);
		
	}
	
	public void setEarlyCheck(String earlyDate, String earlyTime) {
		String[] earlyCheck = {earlyDate, earlyTime};
		this.earlyCheck.add(earlyCheck); 
	}

	@Override
	public String toString() {
		return String.format("%s\t%3d회\t%3d회", this.name, this.lateCheck.size(), this.earlyCheck.size());
	}
	
	
	
	
}

/*
	설계]
	1. 파일 읽기
	2. 이름 추출하기
		2.1 이름이 있으면 지각, 조퇴 카운트++
		2.2 이름이 없으면 새로추가
	3. 출력
	
*/