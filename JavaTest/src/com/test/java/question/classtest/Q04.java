package com.test.java.question.classtest;

public class Q04 {

	public static void main(String[] args) {
		
//		요구사항] 직원(Employee) 클래스를 설계하시오.
//		- Employee 객체의 정보 > 이름, 부서, 직책, 연락처, 직속상사
//			- 멤버 접근을 위한 Setter와 Getter를 정의한다.
//			- 이름 : 읽기/쓰기, 한글 2~5자 이내
//			- 부서 : 읽기/쓰기, 영업부, 기획부, 총무부, 개발부, 홍보부
//			- 직책 : 읽기/쓰기, 부장, 과장, 대리, 사원
//			- 연락처 : 읽기/쓰기, 010-XXXX-XXXX 형식 확인
//			- 직속상사 : 읽기/쓰기, 다른 직원 중 한명, 같은 부서가 아니면 될 수 없음(유효성 검사)
//		- Employee 객체 메소드 > void info() : 직원 정보 확인
		
//		출력]	[홍길동]
//				- 부서: 홍보부
//				- 직위: 부장
//				- 연락처: 010-1234-5678
//				- 직속상사: 없음
//
//			[아무개]
//				- 부서: 홍보부
//				- 직위: 사원
//				- 연락처: 010-2541-8569
//				- 직속상사: 홍길동(홍보부 부장)
		
		
		Employee e1 = new Employee();

		e1.setName("홍길동");
		e1.setDepartment("홍보부");
		e1.setPosition("대리");
		e1.setTel("010-1234-5678");
		e1.setBoss(null); //직속 상사 없음

		e1.info();


		Employee e2 = new Employee();

		e2.setName("아무개");
		e2.setDepartment("홍보부");
		e2.setPosition("사원");
		e2.setTel("010-2541-8569");
		e2.setBoss(e1); //직속 상사 e1(홍길동)

		e2.info();
	}
}

class Employee {
	
	private String name;
	private String department;
	private String position;
	private String tel;
	private Employee boss;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(checkName(name)) {
			this.name = name;
		} else {
			System.out.println("올바르지 않은 이름입니다.");
		}
	}
	public String getDepartment() {		
		return department;
	}
	public void setDepartment(String department) {
		
		String[] departments = { "영업부" , "기획부" , "총무부", "개발부", "홍보부" };
		
		for(int i=0; i<departments.length; i++) {
			if(department != null && department.equals(departments[i])) {
				this.department = department;
				return;
			}
		} 
		System.out.println("부서명이 올바르지 않습니다.");
		
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		String[] positions = { "부장", "과장", "대리", "사원" };
		
		for(int i=0; i<positions.length; i++) {
			if(position != null && position.equals(positions[i])) {
				this.position = position;
				return;
			}
		} 
		System.out.println("직책이 올바르지 않습니다.");
		
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		if(checkTel(tel)) {
			this.tel = tel;
		} else {
			System.out.println("잘못된 번호입니다.");
		}
	}
	public Employee getBoss() {
		return boss;
	}
	public void setBoss(Employee boss) {
		if(boss != null
			&& boss.getName() != null
			&&!boss.getName().equals(this.name) 
			&& boss.getDepartment() != null
			&& boss.getDepartment().equals(this.department)) {
			this.boss = boss;
		} else {
			System.out.println("직속 상사가 올바르게 입력되지 않았습니다.");
		}
	}

	private boolean checkName(String name) {
		
		if(name.length() < 2 || name.length() > 5) {
			return false;
		} 
		
		for(int i=0; i<name.length(); i++) {
			if(name.charAt(i) < '가' || name.charAt(i) > '힣') {
				return false;
			}
		}
		return true;
	}
	private boolean checkTel(String tel) {
		
		if(!tel.startsWith("010-") || tel.charAt(8) != '-') {
			return false;
		} 
		
		String t = tel.replace("-","");
		
		for(int i=0; i<t.length(); i++) {
			if(t.charAt(i) < '0' || t.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	
	public void info() {
		System.out.printf("[%s]\n"
						+ "- 부서: %s\n"
						+ "- 직위: %s\n"
						+ "- 연락처: %s\n"
						+ "- 직속상사: %s\n"
							, this.name
							, this.department
							, this.position
							, this.tel
							, (this.boss == null) ? "없음" : String.format("%s(%s %s)"
																,this.boss.getName()
																,this.boss.getDepartment()
																,this.boss.getPosition()));
	}

}


//		설계] 
//		1. private 멤버변수 > 5개
//		2. Getter, Setter
//			2.1 직속상사 > 다른 직원 && 같은 부서
//		3. void info 메소드