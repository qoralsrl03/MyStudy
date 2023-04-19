package minki.submit05;

import java.util.Scanner;

public class submit05 {

	public static void main(String[] args) {
		makeTree(11);
		System.out.println("\n실행결과\n" + makeBinary(6));
		
		String example = "로꾸꺼 로꾸꺼";
		String result = reverseStr(example);
		System.out.println("\n"+result);
	}

	// Q.01 별 거꾸로 출력
	public static void makeTree(int n) {
		for (int i = 0; i < n; i++) {
			String space = "";
			String stars = "";
			for (int k = 0; k < (n - 1) - i; k++) {
				space += " ";
			}

			for (int k = 1; k <= (i * 2) + 1; k++) {
				stars += "*";
			}
			System.out.println(space + stars);
		}
	}

	// Q.02 숫자 뒤집기
	public static String makeBinary(int num) {
		String str = "";
			while (num / 2 >= 0) {
				str = (num % 2) + str;
				num = num / 2;
				if(num/2 == 0) {
					break;
				}
			}
			int str1 = Integer.parseInt(num+str);
			return str1+"";
		}
		
	

	// Q.03 문자열 뒤집기
	public static String reverseStr(String example) {
		String newline = "";
		for (int i = example.length(); i > 0; i--) {
			newline += example.substring(i - 1, i);
		}
		return newline;
	}
}
