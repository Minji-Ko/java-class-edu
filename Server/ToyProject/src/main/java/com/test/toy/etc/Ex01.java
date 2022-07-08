package com.test.toy.etc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Ex01 {

	public static void main(String[] args) {
		
		try {
			
			//Document > 해당 URL 페이지 소스 내용을 전부 담고 있는 객체
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get();
			
			//System.out.println(doc.html());
			
			Elements list = doc.select("#In_the_news");
			
			System.out.println(list.get(0).text());
			
		} catch (Exception e) {
			System.out.println("Ex01.main");
			e.printStackTrace();
		}
		
		
		
	}
}
