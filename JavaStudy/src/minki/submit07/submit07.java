package minki.submit07;

import java.util.ArrayList;
import java.util.Collections;

public class submit07 {

	public static void main(String[] args) {
		// Q.1-01
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arr.add((int) (Math.random() * 11) + 10);
		}
		System.out.println("\n=================\n");

		arr = Duplication(arr);
		for (int i = 0; i < 10; i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println("\n===================\n");
		arr = Reverse(arr);
		for (int i = 0; i < 10; i++) {
			System.out.print(arr.get(i) + " ");
		}

		System.out.println("\n=====================\n");
		int rand = makeRandom(10, 12);
		System.out.println(rand);

		System.out.println("\n=====================\n");
		Object();

	}

	// Q.1-02
	public static ArrayList<Integer> Duplication(ArrayList<Integer> al) {
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < al.size(); i++) {
			int num = (int) (Math.random() * (10 + 1)) + 10;
			while (result.contains(num)) {
				num = (int) (Math.random() * (10 + 1)) + 10;
			}
			result.add(num);
		}

		// Q.1-03
		Collections.sort(result);
		return result;
	}

	// Q.1-04
	public static ArrayList<Integer> Reverse(ArrayList<Integer> al) {
		ArrayList<Integer> reverse = new ArrayList<>(al.size());
		for (int i = 1; i <= al.size(); i++) {
			reverse.add(al.get(al.size() - i));
		}
		return reverse;
	}

	// @문제
	public static int makeRandom(int a, int b) {
		int returnval = (int) (Math.random() * (b - a + 1)) + a;
		return returnval;
	}
	//Q.2 답안
	//.retainAll()을 사용하면 교집합만 남는다.
	
	// Q.2-01, 2-02
	public static void Object() {
		String[] Mommy = new String[] { "냉장고", "로봇청소기", "세탁기", "에어컨", "" };
		String[] Daddy = new String[] { "노트북", "티비", "에어컨", "플레이스테이션", "로봇청소기" };
		ArrayList<String> MOM = new ArrayList<>(Mommy.length);
		ArrayList<String> DAD = new ArrayList<>(Daddy.length);
		ArrayList<String> List = new ArrayList<>();
		ArrayList<String> List2 = new ArrayList<>();
		
		for (int i = 0; i < Daddy.length; i++) {
			MOM.add(Mommy[i]);
			DAD.add(Daddy[i]);
		}
//		ratainAll() 을 사용하면 MOM 배열리스트에 교집합만 편하게 남길 수 있다.
//		MOM.retainAll(DAD);
//		System.out.println(MOM);
		
		for (int i = 0; i < Daddy.length; i++) {
		    if (MOM.contains(Daddy[i])) {
		        List.add(Daddy[i]);
		    }
		}
		
		for (int i = 0; i < Mommy.length-1; i++) {
			List2.add(Mommy[i]);
		}
		
		for(int i=0; i<DAD.size(); i++) {
			if(!List2.contains(DAD.get(i))) {
				List2.add(DAD.get(i));
			}
		}
		System.out.println(List);
		System.out.println(List2);
	}
}
