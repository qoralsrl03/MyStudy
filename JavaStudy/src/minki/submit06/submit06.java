package minki.submit06;

import java.sql.Array;
import java.util.Arrays;

public class submit06 {

	public static void main(String[] args) {
		// Q.01
		String[] nameList = { "이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민",
				"최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬" };
		returnName(nameList);
		System.out.println("\n=======================\n");
		// Q.02
		int[] intArr = { 23, 456, 213, 32, 464, 1, 2, 4 };
		returnMaxMin(intArr);
		System.out.println("\n========================\n");
		// Q.03
		makeLotto();
		myLotto(makeLotto());
		
	}

	// Q.01
	public static void returnName(String[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i].substring(0, 1)).equals("이")) {
				count++;
			} else {
			}
		}
		System.out.println("이씨 성을 가진 배우가 총 " + count + "명 있습니다.");
	}

	// Q.02
	public static void returnMaxMin(int[] arr) {
		int Max = arr[0], Min = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			Max = (Max > arr[i]) ? Max : arr[i];
			Min = (Min < arr[i]) ? Min : arr[i];
		}
		System.out.println("최댓값 : " + Max);
		System.out.println("최솟값 : " + Min);
	}

	// Q.03
	public static int[] makeLotto() {
		int size = 6;
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = (int) (Math.random() * 45) + 1;
		}
		/*
		 * int idx = 0; outer : while(true) 
		 * { 
		 * rand = (int)(Math.Random() *45) +1; 
		 * idx ++; 
		 * if(idx == 6){ break; }
		 * 
		 * for(int 1=0; i<arr.length; i++){
		 * if(arr[i] == rand)
		 * { continue.outer; } 
		 * 	} 
		 * }
		 */

		for (int i = size - 1; i >= 0; i--) {
			for (int j = size - 1; j >= 0; j--) {
				if (arr[i] == arr[j]) {
					System.out.println("중복 확인" + arr[i] + " " + arr[j]);
					arr[i] = (int) (Math.random() * 45) + 1;
					System.out.println("중복 변화" + arr[i] + " " + arr[j]);
				} else {
					continue;
				}
			}
		}
		return arr;
	}

	public static void myLotto(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			Arrays.sort(arr);
			System.out.print(arr[i] + " ");
		}
	}

}
