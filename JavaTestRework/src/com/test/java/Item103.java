package com.test.java;

public class Item103 {

	public static void main(String[] args) {
	
		//[SUMMARY] 인터페이스 다중상속하기 (2022. 4. 3. 오후 11:51:13)
	
	}
}

interface 아빠 {
	//public abstract void 돈을번다();
	void 돈을번다();
	void 아이와놀아준다();
	void 가족을지킨다();
}

interface 남자 {
	void 굵은목소리로말한다();
	void 면도를한다();
}

interface 과장 {
	void 결제를한다();
	void 직원을관리한다();
}

interface 카페사장 {
	void 매장을연다();
	void 매장을닫는다();
	void 음료를판다();
}


class 테스트 implements 아빠, 과장, 남자 {

	@Override
	public void 결제를한다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 직원을관리한다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 돈을번다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 아이와놀아준다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 가족을지킨다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 굵은목소리로말한다() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 면도를한다() {
		// TODO Auto-generated method stub
		
	}
	
}