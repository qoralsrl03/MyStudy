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

public class GetCoin2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo?serviceKey=0%2B3Gj89DOxwiJjsnataz9C3MPI%2Fm1kMa1xeaGWGWpK14Ty0lqIz9NHA4m1s6wSMdaK0yPsYgZSo%2FeL%2FPYbldTg%3D%3D&numOfRows=100&resultType=json";
		try {
			URL call_url = new URL(url);
			try {
				HttpURLConnection connection = (HttpURLConnection) call_url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Accept", "application/json");
				if (connection.getResponseCode() != 200) {
					throw new RuntimeException("failed:" + connection.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder res = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					res.append(line);
				}
				// JSONParser를 이용해 파싱
				System.out.println("JSON response:" + res.toString());

				JSONParser parser = new JSONParser();

				JSONObject result;
				try {
					result = (JSONObject) parser.parse(res.toString());
					JSONObject response = (JSONObject) result.get("response");
					JSONObject body = (JSONObject) response.get("body");
					JSONObject items = (JSONObject) body.get("items");
					JSONArray itemArray = (JSONArray) items.get("item"); // itemArray 는 items 항목 내에 값들을 저장한 배열
					String[] itmsNm = new String[itemArray.size()];
					double[] clpr = new double[itemArray.size()];
					double[] hipr = new double[itemArray.size()];
					double[] lopr = new double[itemArray.size()];

					for (int i = 0; i < itemArray.size(); i++) {
						JSONObject item = (JSONObject) itemArray.get(i); // 1행만 가져와서 item에 저장
						itmsNm[i] = (String) item.get("itmsNm"); // item내의 itmsNm이라는 이름의 속성 값 호출
						clpr[i] = Double.parseDouble((String)item.get("clpr")); 
						hipr[i] = Double.parseDouble((String) item.get("hipr"));
						lopr[i] = Double.parseDouble((String) item.get("lopr"));
						System.out.println(itmsNm[i]);
					}
					System.out.println("검색할 주식회사 이름 : ");
					String company = scan.nextLine();
					for (int i = 0; i < itemArray.size(); i++) {
						if (itmsNm[i].equals(company)) {
							System.out.println("이름 : " + itmsNm[i] + " 현재가 : " + clpr[i] + " 최고가 : " + hipr[i] + " 최저가 : " + lopr[i]);

						}
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
