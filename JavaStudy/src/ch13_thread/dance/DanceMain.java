package ch13_thread.dance;

import java.util.Scanner;

public class DanceMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0;
		// 선생님은 불규칙하게 앞, 뒤 전환
		// 유저는 엔터를 누르면 춤을 춘다.
		// 선생님이 앞을 볼 때 춤을 추면 게임이 오버된다.
		// 선생님이 뒤를 볼 때 춤을 추면 점수가 증가한다.
		Teacher teacher = new Teacher();
		teacher.start();

		while (true) {
			scan.nextLine();

			// true -:> 선생님이 앞으로 보고 있음
			if (teacher.state == true) {
				System.out.println("으악!! 게임 오버");
				System.out.println("점수 : " + score);
				teacher.isRun = false;
				break;
			}

			System.out.println("춤추는 중~");
			score++;
		}
	}
}
