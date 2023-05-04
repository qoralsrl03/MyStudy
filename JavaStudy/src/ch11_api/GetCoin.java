package ch11_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetCoin {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "https://api.upbit.com/v1/market/all";
		try {
			URL call_url = new URL(url);
			try {
				HttpURLConnection connection = (HttpURLConnection)call_url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Accept", "application/json");
				if(connection.getResponseCode() != 200) {
					throw new RuntimeException("failed:" + connection.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder result = new StringBuilder();
				String line;
				while((line = br.readLine()) != null) {
					result.append(line);
				}
				// JSONParser를 이용해 파싱
				System.out.println("JSON response:" + result.toString());
				JSONParser parser = new JSONParser();
				try {
					JSONArray arr = (JSONArray)parser.parse(result.toString());
					System.out.println("JsonArray:" + arr.toJSONString());
					JSONObject jsonObj=null;
					for(Object obj : arr) {
						jsonObj = (JSONObject) obj;
						System.out.println(jsonObj.get("korean_name")+":"+jsonObj.get("market"));
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
