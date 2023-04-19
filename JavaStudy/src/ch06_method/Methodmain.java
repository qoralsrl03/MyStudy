package ch06_method;

import java.util.Scanner;

public class Methodmain {

	public static void main(String[] args) {

		// 메소드 = method = 함수 = function
		// 굳이 나누자면 method는 클래스에 종속된 함수를 의미
		// function은 클래스에 독립적인 함수를 말한다.

		// 1부터 100까지의 합은?
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

		sum = 0;
		for (int i = 30; i <= 60; i++) {
			sum += i;
		}
		System.out.println(sum);

		sum = 0;
		for (int i = 25; i <= 50; i++) {
			sum += i;
		}
		System.out.println(sum);

		// 위 작업을 함수로 만들자
		// 70~90 까지의 합을 메소드로 이용하면?
		printSum(5000, 6000);

		// 함수를 쓰면 좋은점
		// 실행부의 코드가 간결해진다.(가독성 증가)
		// 중복된 코드를 함수로 만들어서 사용하면
		// 해당 코드를 한 곳에서 관리할 수 있기 때문에 수정할 때 좋다.

		int returnVar = returnSum(500, 600);
		System.out.println(returnVar);

		System.out.println("\n===============================\n");

		// print를 만들어보자
		print("신기");

		System.out.println("파이썬 저리가라~");
		System.out.println(returnSum(10, 20));
		print("파이썬 저리가라~");
		print(returnSum(1, 10) + "");

		int number = 640;
		print(absolute(400 - number));

		// 이름, 국어 점수, 영어 점수, 수학 점수를
		// 파라미터로 넣으면
		// 이름 : ~씨
		// 국어 : ~점
		// 영어 : ~점
		// 평균 : ~점
		// 등급 : B등급 과 같이 출력하는 메소드 생성
		// 등급은 (90점 이상 A, 80점 이상 B, 나머지 C)
		makeCard("유정", 90, 91, 90);

		// LoopFor에서 했던 각 자리수 더하기 메소드화
		int sumMethod = eachAdd(33334);
		System.out.println(sumMethod);

		System.out.println("\n=========================\n");
		// LoopWhile에서 했던 포켓몬스터도 메소드로 만들기
		// 리턴 타입이 없는 void 메소드도 사용이 가능하다.
//		playPokemon();

		System.out.println("\n========재귀함수========\n");
		recursionPrint(5);

		System.out.println("\n======팩토리얼========\n");
		long no = factorial(5);
		System.out.println(no);
		
		System.out.println(recFactorial(5));
	} // main 메소드 끝

	public static long factorial(int num) {
		//팩토리얼을 어디서 했더라?
		//단축키 [CTRL + H]
		long lrst = 1;
		for(int i=1; i<=num; i++) {
			lrst *= i;
		}
		return lrst;
	}
    
	public static long recFactorial(long num) {
		if(num==1) {
			return 1;
		}
		return num * recFactorial(num-1);
	}
	
	public static void recursionPrint(int num) {
		if (num <= 0) {
			return;
		}
		System.out.println(num);
		recursionPrint(num - 1);

	}

	public static void playPokemon() {
		Scanner scan = new Scanner(System.in);
		/* outer: */ while (true) {// 별칭 짓기
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
						// break outer;
						return;// 내부에서 외부 while문 중지 시키기, outer 대신에 return값을 주지않고 즉시 끝내
					}
				}
			} else if (command == 2) {
				// 도망
				System.out.println("도망쳐야겠다!");
				break;
			}

		}
	}

	public static int eachAdd(int num) {
		String example = num + "";
		String number = "";
		int add = 0;
		for (int i = example.length(); i > 0; i--) {
			number = example.substring(i - 1, i);
			add += Integer.parseInt(number);
		}
		return add;
	}

	public static void makeCard(String name, int korean, int english, int math) {
		double avg = (korean + english + math) / 3.0;
		// 반올림
		// 89.66 -> 90
		// 89.67
		int score = (int) Math.round(avg);
		String grade = "";
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else {
			grade = "C";
		}
		System.out.println("이름 : " + name);
		System.out.println("국어점수 : " + korean);
		System.out.println("수학점수 : " + math);
		System.out.println("영어점수 : " + english);
		System.out.printf("평균점수 : %.02f\n", avg);
		System.out.println("등급 : " + grade);

		System.out.println(weRound(avg, 2));

	}

	/**
	 * 입력한 소수를 반올림하여 소수 n번째 자리로 리턴해주는 함수입니다.
	 * 
	 * @param num 반올림할 값
	 * @param n   소수점 아래 n번째 자리
	 * @return 소수점 반올림값
	 */
	public static double weRound(double num, int n) {
		// Math.round() 소수 첫째 자리에서
		// 반올림한 정수를 리턴
		// 3.141592에 Math.round(3.141592) 를 하면
		// 3이 된다. 그런데 3.1로 만들고 싶다면?

		// 3.141592에 10을 곱한다 -> 31.41592
		// Math.round(31.41592) -> 결과는 31이된다.
		// 31을 10으로 나누면 -> 3.1이 된다.

		// 3.141592에 100을 곱해서 Math.round(314.1592)로 넣으면
		// 314가 나오고, 이를 100으로 다시 나누면 3.14가 된다.
		double val = 1;
		for (int i = 0; i < n; i++) {
			val = val * 10;
//			Math.pow(10, 2) 제곱수 구하는 메소드
		}

		return Math.round(num * val) / val;
	}

	// 메소드 선언
	// [접근제어자 static] 리턴타입 메소드명(){ }
	public static void printSum(int x, int y) {
		int sum = 0;
		for (int i = x; i <= y; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

	// 리턴값이 존재하는 함수 만들기
	public static int returnSum(int x, int y) {
		int sum = 0;
		for (int i = x; i < y; i++) {
			sum += i;
		}
		// 메소드 내에 return이 실행되면
		// 그 즉시 메소드를 종료
		return sum;
		// return 이후 코드는 의미가 없는 코드가 됨

	}

	public static void print(String msg) {
		System.out.println(msg);
	}

	// 하나의 클래스 내에 있는 메소드는 기본적으로
	// 메소드명이 중복되면 안된다.
	// 메소드 오버로딩
	// 하나의 클래스 내에 파라미터의 타입, 수를
	// 다르게 지정하는 경우 중복된 메소드명을 사용할수있다.
	// ==메소드 오버로딩이라고 부름
	public static void print(int num) {
		System.out.println(num);
	}

	// 절댓값 구해주는 메소드 만들기
	public static int absolute(int num) {
		if (num < 0) {
			return -num;
		} else {
			return num;
		}
	}
}
