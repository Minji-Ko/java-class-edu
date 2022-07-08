package com.test.toy.etc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex04 {

	public static void main(String[] args) throws IOException {
		
		
		//String url = "http://lms1.sist.co.kr/worknet/SMember/index.asp?strCode=I202203010002";
		//Document doc = Jsoup.connect(url).get();
		//System.out.println(doc.html());

		/*
		 * 
		 Jsoup 방식
		 - 인증이 불필요한 페이지에서 사용 가능
		 - 인증이 필요한 페이지에서 사용 불가능 > 고비용
		 - JavaScript 실행이 필요한 페이지에서 사용 불가능 > Ajax 페이지 
		  
	  	웹 응용 프로그램 자동화 프로그램
	  	- 셀레니움
	  	- 사람 대신에 프로그램이 사람처럼 웹 사이트에 방문해서 여러가지 행동을 하는 프로그램
	  	- 크롤링 작업도 가능하다
	  	- 인증이 필요한 페이지에서 사용 가능
	  	- JavaScript 실행이 필요한 페이지에서 사용 가능
	  	- 준비물 > 드라이버 > 브라우저 종류 + 버전 
		  
		 */
		
		//m1();
		
		//m2();
		
		//m3();
		
		bana();
	}

	private static void bana() throws IOException {

		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\server\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		
		
		WebDriver driver = new ChromeDriver(options);
		
		String url = "https://www.banapresso.com/menu";
		
		driver.get(url);
		
		List<WebElement> menus = driver.findElements(By.cssSelector("#menuGroup_4 .menu_box"));
		
		Iterator<WebElement> iter = menus.iterator();
		
		
		ArrayList<BanaDTO> list = new ArrayList<BanaDTO>();
		
		EtcDAO dao = new EtcDAO();

		
		int i = 1;
		while(iter.hasNext()) {
			BanaDTO dto = new BanaDTO();
			
			WebElement temp = iter.next();
			
			dto.setImg(temp.findElement(By.cssSelector(".img > img")).getAttribute("src"));
			dto.setEngName(temp.findElement(By.cssSelector(".menu_name > strong")).getText());
			dto.setKorName(temp.findElement(By.cssSelector(".menu_name > i")).getText());
			
			list.add(dto);
			
			System.out.println(dao.addBana(dto));

			
			String OUTPUT_FILE_PATH = "C:/class/server/ToyProject/src/main/webapp/bana/img" + i + ".jpg"; //출력 파일 경로
			String FILE_URL = dto.getImg(); //리소스 경로
			
			try(InputStream in = new URL(FILE_URL).openStream()){
				Path imagePath = Paths.get(OUTPUT_FILE_PATH);
				Files.copy(in, imagePath);
			} catch (Exception e) {
				System.out.println("실패");
			}
			
			i++;
		}
		
		
		
		
		driver.close();
	}

	private static void m3() {
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\server\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		//client-combined-3.141.59.jar
		ChromeOptions options = new ChromeOptions();
	    options.setCapability("ignoreProtectedModeSettings", true);
	    
	    WebDriver driver = new ChromeDriver(options);
	    
	    String url = "http://lms1.sist.co.kr/worknet/SLogin.asp";
	    
	    driver.get(url);
	    
	    WebElement id = driver.findElement(By.id("strLoginID"));
	    id.sendKeys("고민지");

	    WebElement pwd = driver.findElement(By.id("strLoginPwd"));
	    pwd.sendKeys("9972");
	    
	    WebElement btn = driver.findElement(By.cssSelector(".login-btn > input"));
	    btn.click();
	    
	    WebElement td = driver.findElement(By.cssSelector("#content tr:nth-child(5) > td:nth-child(2)"));
	    System.out.println("나의 교육기간: " + td.getText());
	    
	    
	}

	private static void m2() {
		
		String webDriverID = "webdriver.chrome.driver";
		String path = "C:\\class\\server\\chromedriver.exe";
		
		System.setProperty(webDriverID, path);
		
		//client-combined-3.141.59.jar
		ChromeOptions options = new ChromeOptions();
	    options.setCapability("ignoreProtectedModeSettings", true);
	    
	    WebDriver driver = new ChromeDriver(options);
	    
	    String url = "http://localhost:8090/toy/etc/expage.do";
	    
	    driver.get(url);
	    
	    WebElement name = driver.findElement(By.id("name"));
	    
	    System.out.println(name.getText());
	    
	    
		
	}

	private static void m1() throws IOException {
		
		String url = "http://localhost:8090/toy/etc/expage.do";
		
		Document doc = Jsoup.connect(url).get();
		
		
		Element span = doc.selectFirst("body > main > section > div > span");
		System.out.println(span.text());
		
		Element span2 = doc.selectFirst("#name");
		System.out.println(span2.text());
		
		
	}
	
	
}
