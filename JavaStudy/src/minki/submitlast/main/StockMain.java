package minki.submitlast.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import minki.submitlast.service.LoginService;
import minki.submitlast.service.RunStock;
import minki.submitlast.service.StockService;
import minki.submitlast.vo.CurrentStockVO;
import minki.submitlast.vo.LoginVO;

public class StockMain {

	public static void main(String[] args) throws SQLException {
		LoginService lservice = new LoginService();
		StockService sservice = new StockService();

		RunStock rstock = new RunStock();
		ArrayList<CurrentStockVO> cvo = sservice.stockBoard();
		rstock.setCsv(cvo);
		rstock.start();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("당신의 최애 기업에게 투자하세요!");
		System.out.println("	-민기 주식-");
		System.out.println("");
		System.out.println("Press Enter Any Key");
		scan.nextLine();

		outer: while (true) {
			System.out.println("--메뉴를 선택해 주세요--");
			System.out.println("1 : 로그인 | 2 : 회원가입 | 3 : 종료 | 4. 회원탈퇴");
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
					// TODO 주식조회 기능 (멀티스레드) 구현 필요
					while (true) {
						System.out.println("1. 주식창 | 2. 나의 주식 | 3. 로그아웃");
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (Exception e) {
							System.err.println("허용되지 않은 입력값입니다.");
						}
						if (select == 1) {
							// 주식조회 기능

							ArrayList<CurrentStockVO> current = rstock.getCsv();
							while (true) {

								for (int i = 0; i < current.size(); i++) {
									double cts = sservice.stockBoard().get(i).getClpr(); // 현재 가격
									double cgs = current.get(i).getClpr(); // 바뀐 가격
									String percentage = cts >= cgs
											? String.format("-" + "%.02f%%", ((cts - cgs) / cts * 100))
											: String.format("+" + "%.02f%%", (cgs - cts) / cts * 100);

									if (current.get(i).getStockname().length() <= 2) {
										System.out.println((i + 1) + ". 종목 : " + current.get(i).getStockname()
												+ " 	\t| 현재가 : " + String.format("%.2f", current.get(i).getClpr())
												+ "(" + percentage + ")" + " \t| 최고가 : "
												+ String.format("%.2f", current.get(i).getHipr()) + " \t| 최저가 : "
												+ String.format("%.2f", current.get(i).getLopr()));
									} else if (current.get(i).getStockname().length() >= 6) {
										System.out.println((i + 1) + ". 종목 : " + current.get(i).getStockname()
												+ "    | 현재가 : " + String.format("%.2f", current.get(i).getClpr()) + "("
												+ percentage + ")" + " \t| 최고가 : "
												+ String.format("%.2f", current.get(i).getHipr()) + " \t| 최저가 : "
												+ String.format("%.2f", current.get(i).getLopr()));
									} else {
										System.out.println((i + 1) + ". 종목 : " + current.get(i).getStockname()
												+ " \t| 현재가 : " + String.format("%.2f", current.get(i).getClpr()) + "("
												+ percentage + ")" + " \t| 최고가 : "
												+ String.format("%.2f", current.get(i).getHipr()) + " \t| 최저가 : "
												+ String.format("%.2f", current.get(i).getLopr()));
									}
								}

								System.out.println("---------------------------------");
								System.out.println("1. 매수 | 2. 매도 | 3. 처음으로");
								try {
									select = Integer.parseInt(scan.nextLine());
								} catch (Exception e) {
									System.err.println("범위 이외의 값");
								}
								if (select == 1) {
									System.out.println("어떤주식을 구매하시겠습니까?(번호 입력)");
									try {
										select = Integer.parseInt(scan.nextLine());
									} catch (Exception e) {
										System.err.println("10 이하의 숫자를 입력해주세요");
									}
									System.out.println(current.get(select - 1).getStockname() + " 몇 주를 구매 하시겠습니까?");
									System.out.println("현재 잔액 : " + vo.getWallet());
									System.out.print(">>> ");
									int choice = Integer.parseInt(scan.nextLine());
									if (vo.getWallet() < (choice * current.get(select - 1).getClpr())) {
										System.out.println("당신의 얄팍한 지갑으로는 살 수 없습니다.");
										System.out.println("-------------------------------");
									} else {
										System.out.println(choice + "주 구매하였습니다.");
										ArrayList<MyStockVO> ams = new ArrayList<>();
										vo.setWallet(vo.getWallet() - (choice * current.get(select - 1).getClpr()));
									}

								} else if (select == 2) {
									System.out.println("2번선택");
								} else if (select == 3) {
									break;
								}
							}
						} else if (select == 2) {
							// TODO 나의주식 조회 기능
						} else if (select == 3) { // 로그아웃
							System.out.println("로그아웃 되었습니다");
							break;
						} else { // 범위값 외 예외처리
							System.out.println("1~3번 사이의 값을 입력해 주세요");
						}
					}
				} else if (select == 2) { // 회원가입
					lservice.insertal();
					continue outer;
				} else if (select == 3) { // 종료
					System.out.println("내일도 이용해주세요!");
					System.exit(0);
				} else if (select == 4) {
					lservice.deleteal();
				} else { // 예외처리
					System.out.println("잘못된 입력입니다!");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해 주세요!");
			}

		}
	}

}
