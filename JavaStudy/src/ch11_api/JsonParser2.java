package ch11_api;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser2 {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		String serverData = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"numOfRows\":10,\"pageNo\":1,\"totalCount\":2130122,\"items\":{\"item\":[{\"basDt\":\"20230503\",\"srtnCd\":\"900110\",\"isinCd\":\"HK0000057197\",\"itmsNm\":\"이스트아시아홀딩스\",\"mrktCtg\":\"KOSDAQ\",\"clpr\":\"167\",\"vs\":\"2\",\"fltRt\":\"1.21\",\"mkp\":\"163\",\"hipr\":\"171\",\"lopr\":\"161\",\"trqu\":\"5890487\",\"trPrc\":\"978338059\",\"lstgStCnt\":\"291932050\",\"mrktTotAmt\":\"48752652350\"},{\"basDt\":\"20230503\",\"srtnCd\":\"900270\",\"isinCd\":\"HK0000214814\",\"itmsNm\":\"헝셩그룹\",\"mrktCtg\":\"KOSDAQ\",\"clpr\":\"334\",\"vs\":\"4\",\"fltRt\":\"1.21\",\"mkp\":\"330\",\"hipr\":\"338\",\"lopr\":\"327\",\"trqu\":\"676047\",\"trPrc\":\"225656271\",\"lstgStCnt\":\"82824858\",\"mrktTotAmt\":\"27663502572\"},{\"basDt\":\"20230503\",\"srtnCd\":\"900260\",\"isinCd\":\"HK0000295359\",\"itmsNm\":\"로스웰\",\"mrktCtg\":\"KOSDAQ\",\"clpr\":\"980\",\"vs\":\"3\",\"fltRt\":\".31\",\"mkp\":\"990\",\"hipr\":\"996\",\"lopr\":\"970\",\"trqu\":\"65268\",\"trPrc\":\"63902323\",\"lstgStCnt\":\"36031288\",\"mrktTotAmt\":\"35310662240\"},{\"basDt\":\"20230503\",\"srtnCd\":\"900290\",\"isinCd\":\"HK0000307485\",\"itmsNm\":\"GRT\",\"mrktCtg\":\"KOSDAQ\",\"clpr\":\"3545\",\"vs\":\"45\",\"fltRt\":\"1.29\",\"mkp\":\"3500\",\"hipr\":\"3580\",\"lopr\":\"3485\",\"trqu\":\"42149\",\"trPrc\":\"149303990\",\"lstgStCnt\":\"67375000\",\"mrktTotAmt\":\"238844375000\"},{\"basDt\":\"20230503\",\"srtnCd\":\"900300\",\"isinCd\":\"HK0000312568\",\"itmsNm\":\"오가닉티코스메틱\",\"mrktCtg\":\"KOSDAQ\",\"clpr\":\"181\",\"vs\":\"-9\",\"fltRt\":\"-4.74\",\"mkp\":\"190\",\"hipr\":\"192\",\"lopr\":\"181\",\"trqu\":\"4786066\",\"trPrc\":\"885205062\",\"lstgStCnt\":\"185263481\",\"mrktTotAmt\":\"33532690061\"},{\"basDt\":\"20230503\",\"srtnCd\":\"900310\",\"isinCd\":\"HK0000341732\",\"itmsNm\":\"컬러레이\",\"mrktCtg\":\"KOSDAQ\",\"clpr\":\"1022\",\"vs\":\"-1\",\"fltRt\":\"-.1\",\"mkp\":\"1008\",\"hipr\":\"1025\",\"lopr\":\"1000\",\"trqu\":\"183315\",\"trPrc\":\"185517873\",\"lstgStCnt\":\"64041675\",\"mrktTotAmt\":\"65450591850\"},{\"basDt\":\"20230503\",\"srtnCd\":\"900340\",\"isinCd\":\"HK0000449303\",\"itmsNm\":\"윙입푸드\",\"mrktCtg\":\"KOSDAQ\",\"clpr\":\"960\",\"vs\":\"1\",\"fltRt\":\".1\",\"mkp\":\"962\",\"hipr\":\"972\",\"lopr\":\"956\",\"trqu\":\"115829\",\"trPrc\":\"111538504\",\"lstgStCnt\":\"47973428\",\"mrktTotAmt\":\"46054490880\"},{\"basDt\":\"20230503\",\"srtnCd\":\"000020\",\"isinCd\":\"KR7000020008\",\"itmsNm\":\"동화약품\",\"mrktCtg\":\"KOSPI\",\"clpr\":\"8470\",\"vs\":\"40\",\"fltRt\":\".47\",\"mkp\":\"8420\",\"hipr\":\"8520\",\"lopr\":\"8380\",\"trqu\":\"41096\",\"trPrc\":\"346212260\",\"lstgStCnt\":\"27931470\",\"mrktTotAmt\":\"236579550900\"},{\"basDt\":\"20230503\",\"srtnCd\":\"000040\",\"isinCd\":\"KR7000040006\",\"itmsNm\":\"KR모터스\",\"mrktCtg\":\"KOSPI\",\"clpr\":\"681\",\"vs\":\"36\",\"fltRt\":\"5.58\",\"mkp\":\"655\",\"hipr\":\"709\",\"lopr\":\"645\",\"trqu\":\"2449487\",\"trPrc\":\"1668916146\",\"lstgStCnt\":\"96138465\",\"mrktTotAmt\":\"65470294665\"},{\"basDt\":\"20230503\",\"srtnCd\":\"000050\",\"isinCd\":\"KR7000050005\",\"itmsNm\":\"경방\",\"mrktCtg\":\"KOSPI\",\"clpr\":\"10490\",\"vs\":\"-30\",\"fltRt\":\"-.29\",\"mkp\":\"10610\",\"hipr\":\"10610\",\"lopr\":\"10390\",\"trqu\":\"3329\",\"trPrc\":\"34934250\",\"lstgStCnt\":\"27415270\",\"mrktTotAmt\":\"287586182300\"}]}}}}";
		System.out.println(serverData);

		// JSONParser를 이용해서 파싱
		JSONParser parser = new JSONParser();

		JSONObject result = (JSONObject) parser.parse(serverData);
		JSONObject response = (JSONObject) result.get("response");
		JSONObject body = (JSONObject) response.get("body");
		JSONObject items = (JSONObject) body.get("items");
		JSONArray itemArray = (JSONArray) items.get("item");
		
		String[] itmsNm = new String[itemArray.size()];
		
		for (int i = 0; i < itemArray.size(); i++) {
			JSONObject item = (JSONObject) itemArray.get(i);
			itmsNm[i] = (String) item.get("itmsNm");
			System.out.println(itmsNm[i]);
		}
		System.out.println("검색할 주식회사 이름 : ");
		String company = scan.nextLine();
		for (int i = 0; i < itemArray.size(); i++) {
			if (itmsNm[i].equals(company)) {
				System.out.println(itemArray.get(i));
			}
		}
	}

}
