package minki.submit04;

import java.util.Scanner;
import java.lang.Math;

public class submit04 {

	public static void main(String[] args) {
		// Q.01
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열을 입력하시오");
		String line = scan.nextLine();
		String newline = "";
		for (int i = line.length(); i > 0; i--) {
			newline += line.substring(i - 1, i);
		}
		System.out.print(newline);

		// Q.02
		System.out.println("\n=============희영빌딩 엘리베이터============\n");
		int A = (int) (Math.random() * 10) + 1;
		int B = (int) (Math.random() * 10) + 1;
		int user = 0;

		while (true) {

			System.out.println("승강기 A의 현재 위치 : " + A + "층");
			System.out.println("승강기 B의 현재 위치 : " + B + "층");

			String now = scan.nextLine();

			if (now.equalsIgnoreCase("q") || now.equalsIgnoreCase("exit")) {
				break;
			} else {
				user = Integer.parseInt(now);
				System.out.println(user + "층에서 엘리베이터를 호출합니다.");
				if (Math.abs(user - A) == Math.abs(user - B)) {
					String elevator = (user - A <= user - B) ? "A" : "B";
					System.out.println("승강기 " + elevator + "가 " + user + "층으로 이동하였습니다.");
					if (elevator == "A") {
						A = user;
					} else {
						B = user;
					}
					System.out.println("\n===엘리베이터를 재 호출합니다.===\n");
					continue;
				} else {
					String elevator = (Math.abs(user - A) < Math.abs(user - B)) ? "A" : "B";
					System.out.println("승강기 " + elevator + "가 " + user + "층으로 이동하였습니다.");
					if (elevator == "A") {
						A = user;
					} else {
						B = user;
					}
					System.out.println("\n===엘리베이터를 재 호출합니다.===\n");
					continue;
				}
			}
		}

	}

}
