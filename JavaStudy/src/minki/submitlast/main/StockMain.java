package minki.submitlast.main;

import java.util.Scanner;

import minki.submitlast.service.LoginService;

public class StockMain {

	public static void main(String[] args) {
		LoginService lservice = new LoginService();
		Scanner scan = new Scanner(System.in);

		System.out.println("당신의 최애 기업에게 투자하세요!");
		System.out.println("-민기 주식-");
		System.out.println("Press Enter");
		scan.nextLine();

		System.out.println("--메뉴를 선택해 주세요--");
		System.out.println("1 : 로그인 | 2 : 종료");
		System.out.print(">>> ");
		int select = Integer.parseInt(scan.nextLine());
		while (true) {
			if (select == 1) {

			} else if (select == 2) {

			} else {

			}
		}
	}

}
