package com.test.toy.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class OpenAPIDAO {

	public ResultDTO search(HashMap<String, String> map) {
		
		String clientId = "zO8i3kMzhFrZ9hV84SxQ"; //애플리케이션 클라이언트 아이디값"
		String clientSecret = "lmHxnlMehH"; //애플리케이션 클라이언트 시크릿값"
		
		
		String text = null;
		
		try {
		    text = URLEncoder.encode(map.get("query"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
		    throw new RuntimeException("검색어 인코딩 실패",e);
		}
		
		
		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text + "&start=" + map.get("start");    // json 결과

		
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL,requestHeaders);
		
		
		
		try {
		
			JSONParser parser = new JSONParser();
		
			JSONObject obj = (JSONObject)parser.parse(responseBody);
			
			JSONArray jlist = (JSONArray)obj.get("items");

			
			
			ArrayList<BookDTO> list = new ArrayList<BookDTO>();
			
			for (Object item : jlist) {
				
				BookDTO dto = new BookDTO();
				JSONObject book = (JSONObject)item;
				
				dto.setTitle((String)book.get("title"));
				dto.setLink((String)book.get("link"));
				dto.setImage((String)book.get("image"));
				dto.setAuthor((String)book.get("author"));
				dto.setPrice((String)book.get("price"));
				dto.setDiscount((String)book.get("discount"));
				dto.setPublisher((String)book.get("publisher"));
				dto.setPubdate((String)book.get("pubdate"));
				
				list.add(dto);
			}
			
			ResultDTO rdto = new ResultDTO();
			rdto.setList(list);
			rdto.setTotal(obj.get("total").toString());
			
			return rdto;
			
		} catch (Exception e) {
			System.out.println("OpenAPI01.main");
			e.printStackTrace();
		}
		
		return null;
	}


    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
