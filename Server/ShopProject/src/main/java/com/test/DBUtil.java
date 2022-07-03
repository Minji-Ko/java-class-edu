package com.test;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	private static Connection conn;

	public static Connection open() {
		
		String url = "jdbc:oracle:thin:@oraclecloud_high?TNS_ADMIN=/class/download/Wallet_OracleCloud";
				
		String id = "admin";
		String pw = "JAVAjava1234";
	
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			return conn;
			
		} catch (Exception e) {
			System.out.println("DBUtil.open");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Connection open(String server, String id, String pw) {
		
		String url = "jdbc:oracle:thin:@" + server + ":1521:xe";
	
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			return conn;
			
		} catch (Exception e) {
			System.out.println("DBUtil.open");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static void close() {
		
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("DBUtil.close");
			e.printStackTrace();
		}
	}
	
}
