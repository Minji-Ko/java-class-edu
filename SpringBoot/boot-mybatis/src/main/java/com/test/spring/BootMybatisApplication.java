package com.test.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.test.repository.TestDAO;

//<contest:component-scan base-package="com.test.spirng"> //spring 설정 

//@ComponentScan(basePackages = "com.test.spring") //기본
//@ComponentScan(basePackages = "com.test.controller")
//@ComponentScan(basePackages = "com.test.service")
//@ComponentScan(basePackages = {"com.test.controller", "com.test.service", "com.test.repository"})
//@ComponentScan(basePackages = "com.test.*") //*의 사용은 권장되지 않음 > 최소한으로!

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.controller", "com.test.repository"})
public class BootMybatisApplication {

	public static void main(String[] args) {
		
		TestDAO controller = new TestDAO();
		System.out.println(controller == null);
		
		SpringApplication.run(BootMybatisApplication.class, args);
	}

}
