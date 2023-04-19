package minki.submit08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class submit08 {

	public static void main(String[] args) {
		System.out.println("\n========Q.01=============\n");
		System.out.println(ArrayLotto());
		System.out.println(setLotto(ArrayLotto()));
		System.out.println("\n=========================\n");

		System.out.println("\n========Q.02=============\n");
		HashMap<String, String> infoMap = new HashMap<>();

		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");

		loginMap(infoMap);

	} // 메인---------------------------------------------------

	// Q.01 ArrayList
	public static ArrayList<Integer> ArrayLotto() {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			while (result.contains(num)) {
				num = (int) (Math.random() * 45) + 1;
			}
			result.add(num);
		}

		return result;
	}

	// Q.01 Hashset
	public static HashSet<Integer> setLotto(ArrayList<Integer> al) {
		HashSet<Integer> result = new HashSet<>();
		Collections.sort(al);
		for (int num : al) {
			result.add(num);
		} // 정렬이 안되네잉..
		return result;
	}

	// Q.02
	public static void loginMap(HashMap<String, String> infoMap) {
		Scanner scan = new Scanner(System.in);
		String id = "", pw = "";
		boolean ids = false, pws = false;
		System.out.println("아이디를 입력해주세요");
		id = scan.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		pw = scan.nextLine();

		/*
		 * if(infoMap.get(id) ! = null{ //id가 map안에 key값으로 존재 // TODO 비밀번호 체크
		 * if(infoMap.get(id).equals(pw)){ System.out.println(("로그인 성공")
		 * }else{"System.out.println("비밀번호가 틀립니다."}} else{
		 * System.out.println("아이디가 틀립니다.") }
		 */

		// 순회를 하자
		Set<String> keyset = infoMap.keySet();
		for (String a : keyset) {
			ids = infoMap.containsKey(id);
			pws = infoMap.containsValue(pw);
		}
		if (ids && pws == true) {
			System.out.println("로그인 성공");
		} else if (ids == false) {
			System.out.println("존재하지 않는 아이디입니다.");
		} else if (pws == false) {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
}
