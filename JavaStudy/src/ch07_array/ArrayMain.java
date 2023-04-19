package ch07_array;

import java.util.Arrays;

public class ArrayMain {

	public static void main(String[] args) {
		// 배열 = 동일한 자료형의 값들을 연속적으로 나열한 표현
		// int[] intArray = new int[size] 와 같이 표현함

		String samjang = "삼장";
		String woogong = "오공";
		String saojeong = "사오정";
		String palgye = "저팔계";

		// 배열의 선언
		// 배열의 크기는 바뀌지 않으며, 첨자(괄호 안 숫자)가 배열의 크기를 의미한다.
		int size = 4;
		String[] seoyugi = new String[size];
		// .length 배열의 길이를 리턴 (메소드는 아님)
		System.out.println(seoyugi.length);
		System.out.println(seoyugi); // 자바는 배열의 이름이 배열의 값을 가리키지 않음, 이 구문 출력시 배열이 저장된 메모리 주소값이 불러와짐
		// 배열 내 요소(element) 확인
		// 인덱스 사용(= 인덱싱)
		System.out.println(seoyugi[0]);

		// 처음 생성된 배열 내에는 기본값(default)으로 초기화 되어있다.
		// 참조타입 : Null(String 또는 유저가 만든 클래스)
		// 기본타입 : 숫자면 0 / boolean형이면 false
		int numbers[] = new int[3];
		System.out.println(numbers[0]);
		boolean[] bools = new boolean[3]; // {false, false, false}
		System.out.println(bools[2]);
		System.out.println();

		// 배열에 값 넣기
		seoyugi[0] = samjang;
		System.out.println(seoyugi[0]); // "삼장", null,null,null
		seoyugi[1] = woogong;
		seoyugi[2] = saojeong;
		seoyugi[3] = palgye; // "삼장", "오공", "사오정", "팔계"

		// for문을 이용해서 0부터 array.length 미만까지
		// 인덱스를 순회하면 배열의 모든 요소에 접근이 가능하다.
		for (int i = 0; i < seoyugi.length; i++) {
			System.out.println(seoyugi[i]);
		}
		System.out.println("=====================");
		// 배열 요소를 조회하는 메소드 만들기
		printArray(seoyugi); // 삼장, 오공, 사오정, 저팔계가 출력된다.

		System.out.println("=====================");
		// 배열의 단점
		// 크기가 고정된다.
		// 늘어나지도, 줄어들지도 않으며
		// 값을 추가하거나 제거하지도 못한다.
		// 실행전에 이클립스가 캐치하는 에러는 컴파일 에러, 실행했을 때 발생하는 에러는 런타임 에러

		// 배열의 장점
		// for문을 이용하여 배열에 담긴 모든 요소들을
		// 한번에 처리 할 수 있다.(데이터 처리)
		for (int i = 0; i < seoyugi.length; i++) {
			seoyugi[i] = "서유기" + seoyugi[i];
		}

		printArray(seoyugi);

		System.out.println("==========================");
		for (int i = 0; i < seoyugi.length; i++) {
			// 오공이 포함되어 있으면 true
			if (seoyugi[i].contains("오공")) {
				seoyugi[i] = seoyugi[i].replace("서유기", "드래곤볼");
			}
			System.out.println(seoyugi[i]);
		}
		System.out.println("==========================");
		int[] intArray = new int[6];

		// 기존 값 넣는 방식
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		intArray[4] = 5;
		intArray[5] = 6;
		printArray(intArray);

		for (int i = 0; i < intArray.length; i++) {
			// 로또 번호
			// 1~45 사이의 랜덤 숫자
			// Math.random() -> 0~0.999..
			// 그러므로 인트형으로 표시하려면 (int)(Math.random()*최대값)+최소값
			// (int)(Math.random()*45)+1; -> 0~44 사이의 랜덤 정수
			intArray[i] = (int) (Math.random() * 45) + 1;
		}

		printArray(intArray);

		System.out.println("\n================================\n");
		// 값을 넣으며 배열을 선언
		String[] students = { "백민기", "유동윤", "강민경", "버터플라이" };
		printArray(students);
		int[] intarr = { 1, 2, 3, 4 };
		printArray(intarr);

		System.out.println("==========문자열 나누기===============");
		String subjects = "자바, SQL, 데이터베이스, JSP";
		// .split 문자열 배열로 리턴한다.
		String[] subjectArray = subjects.split(",");

		System.out.println(subjectArray[1]);
		System.out.println(subjectArray.length);

		// 데이터가 잘 정돈되어 있지 않다면
		// ,로 일단 나누고 양쪽 공백을 제거해주면 된다(trim).
		for (int i = 0; i < subjectArray.length; i++) {
			subjectArray[i] = subjectArray[i].trim();
		}
		printArray(subjectArray);

		System.out.println("===========배열의 복사=============");
		// 배열은 배열의 이름으로 삽입시으로 입력시 기존의 배열과 새로운 배열이 바라보는 주소가 같아져서
		// 새로운 배열의 값을 바꾸면, 기존의 배열의 값도 바뀐다.
		String[] sinSeoyugi = seoyugi;
		printArray(sinSeoyugi);

		sinSeoyugi[0] = "강호동";
		sinSeoyugi[1] = "이수근";
		printArray(sinSeoyugi);
		printArray(seoyugi); // 기존 배열에 영향을 줌

		// @앞은 객체의 타입을 얘기함
		// @뒤에 붙은건 hashCode를 16진수로 나타낸 것
		System.out.println(seoyugi);
		System.out.println(sinSeoyugi);
		System.out.println(seoyugi.hashCode());
		System.out.println(sinSeoyugi.hashCode());
		// 숫자를 16진수로 표현
		System.out.println(Integer.toHexString(seoyugi.hashCode()));

		// 해쉬코드(hashcode)
		// 객체의 메모리 주소값을 이용해서
		// 해쉬를 적용한 코드
		// 해쉬란?
		// 해쉬함수(암호화 알고리즘)을 이용해서
		// 데이터를 암호화하는 기법(대표 SHA)

		System.out.println("\n========================\n");
		// 옳바른 배열 복사
		String[] newSeoyugi = seoyugi.clone(); // 같은 주소를 참조하지 않고 복사에 성공

		newSeoyugi[2] = "은지원";
		printArray(newSeoyugi);
		printArray(seoyugi);

		// .clone()을 까먹었다.
		String[] copy = new String[seoyugi.length];
		// copy의 각 인덱스에, seoyugi의 각 인덱스 값을 넣어준다.
		for (int i = 0; i < seoyugi.length; i++) {
			copy[i] = seoyugi[i];
		}
		printArray(copy);

		System.out.println("\n=============================\n");
		// 숫자 배열
		int[] numArray = { 23, 45, 678, 9999, 100000, 1, 0 };
		System.out.println(numArray[0]);
		// 인덱스 0번 값과 인덱스 1번 값의 위치를 바꿔보자
		changePosition(numArray, 1, 3);
		printArray(numArray);

		// 가끔 면접에서 묻는 문제
		// Call by Value 와 Call by Reference 구분
		// 기본타입 변수에 대해서는 Call by Value로 동작
		// 참조타입 변수에 대해서는 Call by Reference로 동작
		int a = 10;
		int b = 3;
		a = 20;
		swap(a, b);
		System.out.println("-->" + a + " " + b + " ");

		// 다차원 배열
		// 1,2,3D,4D -> x,y,z,t축..
		int[] oneDir = { 1, 2, 3 };
		// 2D는 1차원 배열 내에 1차원 배열들이 존재하는 경우
		// 행렬로 나타낸다면
		// 1 2 3
		// 4 5 6
		// 7 8 9
		int[][] twoDir = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// twoDIR으로부터 {7,8,9} 배열을 꺼내고 싶다.
		int[] tempArray = twoDir[2];
		printArray(tempArray);

		int six = twoDir[1][2];
		System.out.println(six);

		// 3차원 배열은 일차원 배열 내 2차원 배열들이 존재
		int[][][] threeDir = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
				{ { 10, 20, 30 }, { 41, 51, 61 }, { 71, 81, 99 } },
				{ { 11, 22, 33 }, { 44, 55, 66 }, { 75, 85, 95 } } };
		// 0층의 헁렬
		// 1 2 3 -0헁의 0열 (= 0,0,0) / 3을 찾으려면 (=0,0,2)
		// 4 5 6
		// 7 8 9
		;
		// --오름차순 정렬
		int[] numberArray = { 23, 32, 13, 1 };
		Arrays.sort(numberArray);
		printArray(numberArray);

		// 내림차순 정렬
		// 이 방법은 참조타입 객체를 담은 배열일 경우에만 가능
		// Arrays.sort(numberArray, Collections.reverseOrder());

		// 현재 1, 13,23, 54, 67, 452
		// 내림차순이면 452, ,67, 54 ...

		// numberArray에 모든 요소에 -1을 곱함
		// -1, -13, -23, -54, -67..
		// Arrays.sort(numberArray) 적용
		// -452, -67, -54 ,-23 ...
		// numberArray에 모든 요소에 -1을 다시 곱함
		// 452, 67, 54,....

		sortArray(numberArray);
		printArray(numberArray);

		System.out.println("\n====================\n");
		bubbleSort(numberArray);
		printArray(numberArray);

	}

	public static void bubbleSort(int[] arr) {
		for (int k = 0; k < arr.length - 1; k++) {
			for (int i = 0; i < arr.length - 1; i++) {
				//i>i+1하면 오름차순
				//i<i+1하면 내림차순
				if (arr[i] > arr[i + 1]) {
					int t = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = t;
				}
			}
		}
	}

	public static void sortArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= -1;
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= -1;
		}
	}

	// 이 메소드는 주소가 아닌 값을 참조하는
	// call by Value이기 때문에
	// 해당 메소드에서 바꾼다음 return을 하지 않은것이라면
	// 값은 바뀌지 않음
	// 해당 메소드 내로 들어간 파라미터 a,b는 지역변수로 메소드 안에서만 사용이 가능함
	public static int swap(int a, int b) {
		System.out.println(a + " " + b);
		int temp = a;
		a = b;
		System.out.println(a);
		b = temp;
		System.out.println(b);
		return a;
	}

	public static void changePosition(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr.length - 1 == i) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ",");
			}
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr.length - 1 == i) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ",");
			}
		}
	}
}
