package minki.submitlast.main;

import java.sql.SQLException;
import java.util.Scanner;

import minki.submitlast.service.LoginService;
import minki.submitlast.vo.LoginVO;

public class StockMain {

	public static void main(String[] args) throws SQLException {
		LoginService lservice = new LoginService();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("당신의 최애 기업에게 투자하세요!");
		System.out.println("	-민기 주식-");
		System.out.println("");
		System.out.println("Press Enter");
		scan.nextLine();

		outer: while (true) {
			System.out.println("--메뉴를 선택해 주세요--");
			System.out.println("1 : 로그인 | 2 : 회원가입 | 3 : 종료");
			System.out.print(">>> ");
			int select;
			try {
				select = Integer.parseInt(scan.nextLine());
				if (select == 1) {
					LoginVO vo = new LoginVO();
					vo = lservice.selectal();
					if (vo.getCustId() != null) {
						System.out.println("\n==========================\n");
						System.out.println(vo.getCustName() + " 님 환영합니다!");
						System.out.println("\n==========================\n");
					}
					// TODO 주식조회 기능 (멀티스레드) 구현
					while (true) {
						System.out.println("1. 주식창 | 2. 나의 주식 | 3. 로그아웃");
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (Exception e) {
							System.err.println("허용되지 않은 입력값입니다.");
						}
						if (select == 1) {

						} else if (select == 2) {

						} else if (select == 3) {
							System.out.println("로그아웃 되었습니다");
							break;
						} else {
							System.out.println("1~3번 사이의 값을 입력해 주세요");
						}
					}
				} else if (select == 2) {
					lservice.insertal();
					continue outer;
				} else if (select == 3) {
					System.out.println("내일도 이용해주세요!");
					break;
				} else {
					System.out.println("잘못된 입력입니다!");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해 주세요!");
			}

		}
	}

}
