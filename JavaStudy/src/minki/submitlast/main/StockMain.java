package minki.submitlast.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import minki.submitlast.service.LoginService;
import minki.submitlast.service.RunStock;
import minki.submitlast.service.StockService;
import minki.submitlast.vo.CurrentStockVO;
import minki.submitlast.vo.LoginVO;

public class StockMain {

	public static void main(String[] args) throws SQLException, IndexOutOfBoundsException {
		LoginService lservice = new LoginService();
		StockService sservice = new StockService();

		RunStock rstock = new RunStock();
		ArrayList<CurrentStockVO> cvo = sservice.stockBoard();
		HashMap<String, Integer> map1 = new HashMap<>();
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
									System.out.println("현재 잔액 : " + (vo.getWallet()));
									System.out.print(">>>");
									try {
										select = Integer.parseInt(scan.nextLine());
									} catch (Exception e) {
										System.err.println("10 이하의 숫자를 입력해주세요");
									}
									System.out.println(current.get(select - 1).getStockname() + " 몇 주를 구매 하시겠습니까?");
									System.out.print(">>> ");
									int choice = Integer.parseInt(scan.nextLine());
									if (vo.getWallet() < (choice * current.get(select - 1).getClpr())) {
										System.out.println("당신의 얄팍한 지갑으로는 살 수 없습니다.");
										System.out.println("-------------------------------");
									} else {
										System.out.println(choice + "주 구매하였습니다.");
										vo.setWallet(vo.getWallet() - (choice * current.get(select - 1).getClpr()));
										System.out.println("현재 잔액 : " + vo.getWallet());

										// 이부분, 주식 구매시 나의 주식에 구매한 금액, 갯수, 그리고 보유하고 있던 금액에서 차감되도록
										// 보유 금액을 차라리 먼저 생성자에 넣고 구매금액하고 갯수를 전달해서 MyStock에서 빼는 방향으로 하자
										if (map1.containsKey(current.get(select - 1).getStockname())) {
											int EA = map1.get(current.get(select - 1).getStockname());
											map1.put(current.get(select - 1).getStockname(), EA + choice);
										} else {
											map1.put(current.get(select - 1).getStockname(), choice);
										}
									}

								} else if (select == 2) {
									// TODO 매도 기능
									System.out.println("2023-06-01 Comming Soon");
									System.out.println("주식을 매도하는 기능은 현재 개발중입니다. 현재는 매도가 불가능합니다 ^^");
								} else if (select == 3) {
									break;
								}
							}
						} else if (select == 2) {
							// 나의 주식 조회
							System.out.println("현재 보유중인 주식 --");
							for (Entry<String, Integer> entry : map1.entrySet()) {
								String key = entry.getKey();
								Integer value = entry.getValue();
								System.out.println(key + " : " + value + "ea");
							}
							System.out.println("현금 보유액 : " + vo.getWallet());
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
