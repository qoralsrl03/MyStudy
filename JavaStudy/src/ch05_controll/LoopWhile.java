package ch05_controll;

import java.util.Scanner;

public class LoopWhile {

	public static void main(String[] args) {
		// while문

		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		int i = 1;
		System.out.println("============");
		while (i <= 10) {
			// 조건문이 false가 되면 while문 종료
			// true면 내부 실행 반복
			System.out.println(i);
			i++; // 증감식
		}

		// while문으로 구구단 2단
		// 2 X 2 = 4
		// 2 X 3 = 6...
		int k = 1;
		while (2 * k < 20) {
			System.out.println("2 * " + k + " = " + 2 * k);
			k++;
		}

		// 서로 같은 반복문이긴 하나, 일반적으로
		// While문은 반복횟수가 정해지지 않은 경우 사용
		// for문은 반복횟수가 정해져있는 경우 사용

		System.out.println("\n============================\n");
		Scanner scan = new Scanner(System.in);
		boolean isRun = false;

		while (isRun) {
			System.out.println("이름 입력[종료는 Q 또는 q]");
			System.out.print(":");
			String input = scan.nextLine();
			if (input.equals("q") || input.equals("Q")) {
				System.out.println("프로그램을 종료하겠습니다.");
				isRun = false;
			} else {
				System.out.println("환영합니다.");
			}
		}

		// break 문 사용
//		while (true) {
//			System.out.println("이름 입력[종료는 Q 또는 q]");
//			System.out.print(":");
//			String input = scan.nextLine();
//			if(input.equalsIgnoreCase("q")) { //대소문자 구분없이 문자열 equal 체크하는 메소드
//				System.out.println("프로그램을 종료합니다.");
//				break;
//			}
//			System.out.println("환영합니다.");
//		}

		System.out.println("\n=============================\n");
		// do-while문
		isRun = false;
		// 반복해야할 내용이 최소 한번은 실행되게끔
		// 하고 싶을 때 사용

		do {
			// 반복될 내용 작성
			System.out.println("하이");
		} while (isRun);

		System.out.println("\n===============================\n");
		// while문 또한 다중으로 사용가능
		// while문으로 구구단
		int x = 1, y = 0, result = 0;
		while (x < 10) {
			y = 1;
			while (y < 10) {
				result = x * y;
				System.out.println(x + "*" + y + "=" + result);
				y++;
			}
			x++;
		}

		// 포켓몬스터
		outer: while (true) {//별칭 짓기
			System.out.println("야생의 파이리(가) 나타났다!");
			System.out.println("행동을 선택하시오:");
			System.out.println("1. 공격 | 2. 도망");
			System.out.print(">>> ");

			int command = Integer.parseInt(scan.nextLine());

			if (command == 1) {
				// TODO 공격
				int enemyHP = 100;
				while (true) { 
					System.out.println("공격을 선택하자!");
					System.out.println("1.할퀴기\n2.깨물기\n3.불대문자\n4.취소");
					System.out.print(">>>");
					int select = Integer.parseInt(scan.nextLine());
					if (select == 1) {
						System.out.println("할퀴기!");
						enemyHP -= 15;
					} else if (select == 2) {
						System.out.println("깨물어!");
						enemyHP -= 20;
					} else if (select == 3) {
						System.out.println("가랏 불대문자!");
						enemyHP -= 40;
					} else if (select == 4) {
						System.out.println("취소");
						break;
						// 내부 while문 종료
						// 외부 while문 계속 실행
					}

					System.out.println("파이리의 현재 체력은 : " + enemyHP);
					// 파이리 잡힘
					if (enemyHP <= 0) {
						System.out.println("파이리를 쓰러뜨렸다!");
//						System.exit(0); 프로그램 종료
						break outer;//내부에서 외부 while문 중지 시키기
					}
				}
			} else if (command == 2) {
				// 도망
				System.out.println("도망쳐야겠다!");
				break;
			}

		}
	}
}
