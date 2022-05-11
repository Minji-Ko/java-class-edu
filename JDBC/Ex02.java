package com.test.java;

import java.sql.Connection;
import mylibrary.db.DBUtil;

public class Ex02 {

	public static void main(String[] args) {
		
		try {
			Connection conn = DBUtil.open();
			System.out.println(conn.isClosed() ? "연결 안됨" : "연결됨");
			
			DBUtil.close();
			
//			conn = DBUtil.open("localhost", "system", "java1234");
			
//			Case1. 서버 주소 오류
//			- IO 오류: The Network Adapter could not establish the connection
//			conn = DBUtil.open("localhost2", "system", "java1234");
//			conn = DBUtil.open("200.0.0.1", "system", "java1234");
			
//			Case2. 아이디, 비번 오류
//			- ORA-01017: invalid username/password; logon denied
//			conn = DBUtil.open("localhost", "hi", "java1234");
			
//			Case3. 서버 중지 > service.msc의 OracleSeriveXE 중지
//			- Listener refused the connection with the following error:
			
//			Case4. 연결 문자열 오타
//			- 부적합한 Oracle URL이 지정되었습니다
			
//			Case5. 포트 번호 오류
//			- IO 오류: The Network Adapter could not establish the connection
			
//			Case6. SID 오류
//			- Listener refused the connection with the following error:
//			- ORA-12505, TNS:listener does not currently know of SID given in connect descriptor
		
//			Case7. 드라이브 오류
//			- oracle.jdbc.driver.OracleDrivr
			
//			Case8. ojdbc.jar 파일이 부존재
//			- oracle.jdbc.driver.OracleDriver
			
			conn = DBUtil.open("localhost", "system", "java1234");
			
			System.out.println(conn.isClosed() ? "연결 안됨" : "연결됨");
			
			DBUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
