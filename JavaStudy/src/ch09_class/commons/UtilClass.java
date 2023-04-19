package ch09_class.commons;

import java.util.ArrayList;

import ch09_class.nextit.NextStudent;
import ch09_class.school.Student;

//유용한 메소드들을 가지고 있는 클래스
public class UtilClass {
	
	// ch06_Method/Main에서 했던 weRound
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
	
	public static ArrayList<Student> BubbleSort(ArrayList<Student> stuList){
		for (int k = 0; k < stuList.size() - 1; k++) {
			for (int i = 0; i < stuList.size() - 1; i++) {
				if (stuList.get(i).getAvg() > stuList.get(i + 1).getAvg()) {
					Student t = stuList.get(i);
					stuList.set(i, stuList.get(i + 1));
					stuList.set(i + 1, t);
				}
			}
		}
		return stuList;
	}
}
