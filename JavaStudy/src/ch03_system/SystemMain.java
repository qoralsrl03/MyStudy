package ch03_system;

import java.util.Scanner;

public class SystemMain {
	public static void main(String[] args) {
		// 표준 출력
		// 콘솔창에 텍스트 출력하기
		// println()
		// 콘솔창에 괄호안 내용을 출력 후 줄바꿈(개행) 해준다.
		System.out.println("Start");
		System.out.println(); // 줄바꿈만 일어남
		System.out.println("End");

		// .print() 줄 안바뀌는 출력문
		// 콘솔창에 포맷 문자열(format String) 형태로 내용을 출
		System.out.print("괄호안 내용을 출력하고 줄은 안바뀜");
		System.out.print(" / / 그래서 줄이 안바뀜");

		// .printf() C언어 형식 출력
		int a = 30;
		double c = 3.1415922563;
		String b = "영어듣기";
		System.out.printf("\n%d명이 수업을 듣고 있습니다.\n", a);
		System.out.printf("\n%d명이 %s을(를) 듣고 있습니다.\n", a, b);
		System.out.printf("%02d장 표준입출력\n", 3); // 일의자리 수 부터 시작하여 채워지고 나머지는 0으로 채움
		System.out.printf("%03d장 표준입출력\n", 13); // 03이면 3자리 000이 생기며 13을 채우면 013이 출력됨
		System.out.printf("원주율은%.02f\n", c); // 03이면 3자리 000이 생기며 13을 채우면 013이 출력됨

		System.out.println("===========================================");
		System.out.println("역슬래시(\\) 기능");
		// 제어문자, 문자열 내에 역슬래시(\)를 사용하여 특정 기능 이용 가능
		// \n 줄바꿈
		System.out.print("노\n는\n게\n제\n일\n좋\n아\n");
		System.out.println("중간에 \n을 넣어보자");

		// \t 탭, 탭을 이용해서 달력 만들기도 쉬움
		System.out.println("너와\t나의\t연결\t고리\n");

		// 문자열 내에서 기능을 가지는 문자(/, ", ')
		// 를 출력하고 싶으면 앞에 \를 붙인다.
		System.out.println("개행문자는 \\n");
		System.out.println("소크라테스 왈 :\"너 자신을 알라\"");

		// 특수문자도 출력 가능하다.
		System.out.println("★");

		System.out.println("\n===============================\n");

		// 표준입력
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력해 주세요 : ");
		System.out.print(">>> ");

		// 키보드 입력 받기
		System.out.println(scan.nextLine());

		// scan.nextLine = 공백을 포함하여 출력하고 \n앞까지 가져옴 | scan.next = 공백을 구분점으로 나눠서 공백 이전까지만
		// 출력함
		/*
		 * System.out.println("이름을 입력해 주세요 : "); System.out.print(">>> ");
		 * System.out.println(scan.next());
		 */

		// **다만 .next() 또는 .nextInt()와 같은 애들은 한번 출력한 이후 다시 Scan문을 사용시 문제가 발생함
		// 입력 후 엔터를 치면 \n 개행문자가 입력이 되는데 .nextLine()을 제외하고는 \n을 인식하지 못함
		int temper = 0;
		System.out.println("난방/냉방 선택");
		System.out.println(scan.next());
		System.out.println("희망 온도 입력 : ");
		System.out.println(scan.nextInt());

		// 주로 .nextLine()을 사용하는거를 추천함, 이후 Integer.parseInt()로 형변환 시켜준다.

	}
}
