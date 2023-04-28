package minki.last_submit;

public class MyStock {
	private String id; 					// 접속시 아이디
	private int password; 				// 접속시 비밀번호
	private int myprice;				// 나의 주식 구매 가격
	private int hopeea;					// 구매 시 원하는 갯수
	private double stockea;				// 나의 주식 보유 갯수((나의 주식 구매 가격 * 구매 수량)/주식의 현재가격)
	private int averagecost; 			// 평균단가
	private int totalcost;				// 총 구매 금액
	private double benefitpercent;	// (나의 주식 보유 갯수 * 현재 주식의 가격)/총 구매 금액
}
