package com.test.java.student;

import java.util.Scanner;

//학생 처리 업무 담당 클래스 => CRUD
public class Work {
	
	public Scanner scan;
	
	public Work() {
		this.scan = new Scanner(System.in);
	}

	//학생 추가하기
	public void add() {
		
		Output.subtitle("학생 추가하기");
		
		System.out.print("이름: ");
		String name = scan.nextLine();
	
		System.out.print("나이: ");
		String age = scan.nextLine();
		
		System.out.print("성별(1.남자, 2.여자): ");
		String gender = scan.nextLine();
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		String seq = getSeq();
		
		Student s = new Student(seq, name, age, gender, address);
		
		Data.slist.add(s); //학생 추가하기
		
		System.out.println();
		System.out.println("학생 추가 완료");
		
		Output.pause();
		
	}

	private String getSeq() {

		int max = 0;
		
		for (Student s : Data.slist) {

			int seq = Integer.parseInt(s.getSeq());

			if(seq > max) {
				max = seq;
			}
		}
		
		return max + 1 + "";
	}

	public void list() {

		showList();
		
		boolean loop = true;
		
		while(loop) {
		
			Output.submenu();
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
				//상세보기
				view();
			} else if(input.equals("2")) {
				//수정하기
				edit();
			} else if(input.equals("3")) {
				//삭제하기
				delete();
			} else {
				//상위메뉴 
				loop = false;
			}
			
			Output.pause();
		}
		
	}

	private void showList() {
		
		Output.subtitle("학생 목록보기");

		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		
		for (Student s : Data.slist) {
			System.out.printf("%4s\t%s\t%4s\t%3s\n"
								, s.getSeq()
								, s.getName()
								, s.getAge()
								, s.getGender().equals("1") ? "남자" : "여자");
		}
		
		System.out.println();
	}

	private void delete() {
		
		System.out.print("학생 선택(번호): ");
		
		String input = scan.nextLine(); //학생번호(seq)
		
		Student result = null;
		
		for(Student s : Data.slist) {
			if (s.getSeq().equals(input)) {
				result = s;
				break;
			}
		}		
		
		if (result != null) {
			Data.slist.remove(result);
			System.out.println("삭제 완료");
		} else {
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
		}
		
		
		Output.pause();
		
		showList();
		
	}

	private void edit() {

		//수정하기
		System.out.print("학생 선택(번호): ");
		
		String input = scan.nextLine(); //학생번호(seq)
		
		Student result = null;
		
		for(Student s : Data.slist) {
			if (s.getSeq().equals(input)) {
				result = s;
				
			}
		}
		
		System.out.println();
		
		if (result != null) {
			//수정 작업
			//> 수정하기 싫으면 그냥 엔터만 입력
			System.out.print("[이름]" + result.getName() + "\t▷ 수정: ");
			String name = scan.nextLine();
			
			//입력하지 않았을 때 null을 반환하는지, ""(빈문자열)을 반환하는지는 만드는 사람 마음 -> Scanner, BufferedReader는 ""
			if(!name.equals("")) {
				result.setName(name);
			}
			
			
			System.out.print("[나이]" + result.getAge() + "\t▷ 수정: ");
			String age = scan.nextLine();
			
			if(!age.equals("")) {
				result.setAge(age);
			}
			
			
			System.out.print("[성별]" + result.getGender() + "\t▷ 수정(1.남자, 2.여자): ");
			String gender = scan.nextLine();

			if(!gender.equals("")) {
				result.setGender(gender);
			}
			
			
			System.out.print("[주소]" + result.getAddress() + "\t▷ 수정: ");
			String address = scan.nextLine();
			
			if(!address.equals("")) {
				result.setAddress(address);
			}
			
			System.out.println("수정 완료");
			
		} else {
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
		}
		
		Output.pause();
		
		showList();
		
	}

	private void view() {

		//위의 출력 목록에서 한명 선택(번호)
		System.out.print("학생 선택(번호): ");
		
		String input = scan.nextLine(); //학생번호(seq)
		
		Student result = null;
		
		for(Student s : Data.slist) {
			if (s.getSeq().equals(input)) {
				result = s;
				
			}
		}
		
		if(result != null) {
			System.out.println("[번호]" + result.getSeq());
			System.out.println("[이름]" + result.getName());
			System.out.println("[나이]" + result.getAge());
			System.out.println("[성별]" + (result.getGender().equals("1") ? "남자" : "여자"));
			System.out.println("[주소]" + result.getAddress());
			
			System.out.println();
			System.out.println("[성적]");
			//성적 출력
			for(Score s : Data.clist) {
				if(s.getSeq().equals(result.getSeq())) {
					System.out.printf("국어(%d), 영어(%d), 수학(%d) = 평균(%.1f)\n"
										, s.getKor()
										, s.getEng()
										, s.getMath()
										, (s.getKor() + s.getEng() + s.getMath()) / 3.0);
				}
			}
			
		} else {
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
		}
		
		
	}

	public void search() {

		Output.subtitle("학생 검색하기");

		//검색조건 입력
		//이름 or 주소 검색
		System.out.print("검색어(이름/주소): "); 
		String input = scan.nextLine();
		
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		
		for (Student s : Data.slist) {
			
			if( s.getName().contains(input) 
					|| s.getAddress().replace(" ", "").contains(input.replace(" ", ""))) {

				System.out.printf("%4s\t%s\t%4s\t%3s\n"
						, s.getSeq()
						, s.getName()
						, s.getAge()
						, s.getGender().equals("1") ? "남자" : "여자");
			}
		}
		
		System.out.println();
		
		Output.pause();
	}

}







