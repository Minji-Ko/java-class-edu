package com.test.toy.etc;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex03 {

	public static void main(String[] args) throws Exception {
		
			
		System.out.println("[네이버 영화]");
		
		String url = "https://movie.naver.com/movie/running/current.naver";
		
		Document doc = Jsoup.connect(url).get();
		
		//1. 타이틀
		Elements list = doc.select(".lst_detail_t1 > li");
		//System.out.println(list.size());
		
		MovieDAO dao = new MovieDAO();
		
		for (Element item : list) {
			
			//영화 제목
			String title = item.select(".tit > a").text();
			//System.out.println(i + ". " + title);

			
			
			//개요
			//장르
			String category = item.select(".tit_t1 + dd .link_txt").text();
			System.out.println(category);

			
			String dd = item.select(".info_txt1 dd:nth-child(2)").text();
			String[] temp = dd.split("\\|");
			
			String time = "";
			String rdate = "";
			
			if (temp.length == 3) {
				//상영 시간
				time = temp[1].replace("분", "").trim();
				//개봉일
				rdate = temp[2].replace("개봉", "").trim();
			} else {
				//상영 시간
				time = temp[0].replace("분", "").trim();
				//개봉일
				rdate = temp[1].replace("개봉", "").trim();
			}
			
			//감독
			String director = item.select(".tit_t2 + dd .link_txt").text();
			
			//배우
			String actor = item.select(".tit_t3 + dd .link_txt").text();
			
			//포스트
			String poster = item.select(".thumb img").attr("src");
			
			MovieDTO dto = new MovieDTO();
			dto.setTitle(title);
			dto.setCategory(category);
			dto.setTime(time);
			dto.setRdate(rdate);
			dto.setDirector(director);
			dto.setActor(actor);
			dto.setPoster(poster);
			
			
			int result = dao.addMovie(dto);
			
			System.out.println(result);
		}
		
		
		
		
		
		
	}
}
