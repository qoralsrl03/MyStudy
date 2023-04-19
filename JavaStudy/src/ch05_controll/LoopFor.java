package ch05_controll;

public class LoopFor {

	public static void main(String[] args) throws InterruptedException {
		int[] intArr;
		int size = 30, sum = 0;
		intArr = new int[size];
		for (int i = 0; i < 20; i++) {
			intArr[i] = i + 1;
		}

		for (int i = 0; i < 20; i++) {
			sum += intArr[i];
		}

		System.out.println("1~20까지의 합은 : " + sum);
		sum = 0;
		for (int i = 21; i < 46; i++) {
			intArr[i - 21] = i;
			sum += intArr[i - 21];
		}
		System.out.println("21~45까지의 합은 : " + sum);

		sum = 0;
		// 1부터 40까지 중 짝수들의 합
		for (int i = 1; i < 41; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1~40까지의 짝수들의 합은 " + sum);

		for (int i = 1; i < 5; ++i) {
			System.out.println("a");
		}

		// 0부터 2까지 0.2마다 출력
		for (double i = 0; i <= 2; i += 0.2) {
			System.out.println(i);
		}

		for (int i = 0; i <= 20; i += 2) {
			System.out.println(i / 10.0);
		}
		System.out.println("\n===============\n");
		// 증감식에 i++로 두고 위 코드와 동일하게 출력
		for (int i = 0; i <= 10; i++) {
			System.out.println((i * 2) / 10.0);
		}

		System.out.println("\n=================================\n");
		// 구구단 2단 출력
		// 2*2 = 4
		// 2*3 = 6
		// 2*9 = 18

		for (int i = 1; i <= 9; i++) {
			System.out.println("구구단 2단 출력 : " + "2*" + i + "=" + 2 * i);
		}

		// 구구단
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
		}

		System.out.println("\n=====================\n");
		/*
		 * System.out.println("*"); System.out.println("**"); System.out.println("***");
		 * System.out.println("****"); System.out.println("*****");
		 */

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println("");
		}

		String star = "*";
		for (int i = 0; i < 5; i++) {
			System.out.println(star);
			star += "*";
		}

		for (String i = "*"; i.length() <= 5; i += "*") {
			System.out.println(i);
		}

		// 국수공장에서 면을 20cm 뽑고 있는데
		// 5cm마다 잘라주기
		for (int i = 0; i < 20; i++) {

			if (i % 5 == 0) {
				System.out.println("--------");
			}
			System.out.println(i + 1 + "." + "||||||||");
		}

		// i가 4,9,14,19.. 일때 면을 잘라준다.
		// == 이는 i를 5로 나눈 나머지가 4인 애들이다.
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ".||||||||");
			if (i % 5 == 4) {
				System.out.println("--------");
			}
		}

		System.out.println("\n===========신라면=============\n");
		// 라면 공장에서 30cm면을 뽑는데 6cm마다 잘라야 한다.

		/*
		 * //// \\\\
		 */
		for (int i = 0; i < 30; i++) {
			if (i % 2 == 0) {
				System.out.println("////////");
			} else if (i % 2 == 1) {
				System.out.println("\\\\\\\\\\\\\\\\");
			}
			if (i % 6 == 5) {
				System.out.println("-------");
			}
			// Thread.sleep(600);
		}
		System.out.println("\n=============================\n");
		// 10부터 1까지 순서대로 출력
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}
		System.out.println("\n=======================\n");
		// for문으로 String 가지고 놀기
		// submit01에서 했던,
		// 숫자의 각 자리수에 대한 결과 출력을 for문을 이용해 해결

		String example = 4784593 + "";
		String number = "";
		int add = 0;
		for (int i = example.length(); i > 0; i--) {
			number = example.substring(i - 1, i);
			add += Integer.parseInt(number);
		}
		// System.out.println(example.substring(0,1));

		System.out.println("결과는 : " + add);
		// 슈의 갯수는?
		String syu = "슈슈슈슈슈슈슈슈슈슈슈슈슈슈슛슈슈슈슈사슈ㅏ슈슈슈슈슈슛ㅅ슈";

		// syu를 한글자씩 자르고
		// 자른 값이 "슈"인지 체크
		// "슈"가 맞다면 카운팅을 한다.
		int count = 0;
		for (int i = 0; i < syu.length(); i++) {
			String check = syu.substring(i, i + 1);
			if (check.equals("슈")) {
				count++;
			}
		}
		System.out.println("슈의 갯수는 : " + count);

		System.out.println("\n==========================\n");
		// break 문
		// 반복문 내에서 break문이 실행되면
		// 해당 반복문을 즉시 종료

		// 1부터 N까지 더한다고 했을때,
		// 더한 값이 100 이상이 되는 지점의 n을 구해라
		sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
			if (sum >= 100) {
				System.out.println("i가 " + i + "일때 합이 100 이상이 되며 합은 " + sum + "입니다.");
				break;
			}
		}
		// continue문
		// 구구단 6단을 출력하는데
		// 6*1 ~ 6*3은 쉬우니 출력하지 말자

		for (int i = 1; i <= 9; i++) {
			if (i < 4) {
				// continue가 실행되면
				// 이후 코드는 무시하고
				// 바로 다음 for문으로 진행된다.
				continue;
			} else {
				System.out.println("6*" + i + "=" + (6 * i));
			}
		}
		
	}

}
