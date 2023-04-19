package ch05_controll;

public class LoopForPlus {

	public static void main(String[] args) {
		// 이중 for문
		// 구구단
		for (int i = 2; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(i + " * " + j + " = " + i * j + " | ");
			}
			System.out.println("");
		}

		/*
		 * 디버깅 모드 코드라인 좌측 연두색 부분을 더블 클릭하면 초록색 점이 생김 이 초록점을 break point라고 하며, 만든 후 실행
		 * breakpoint 생성/해제 단축키 [ Ctrl + Shift + B] 디버깅 실행 단축키 : [F11] 디버깅의 목적 코드를 한줄 한줄
		 * 실행해보며, 변수에 어떤 값이 담기고 있는지 확인해볼 수 있다. 처음에 디버깅 모드에 적합한 화면(Perspective)으로의 전환여부를
		 * 물어봄
		 * 
		 * 코드들이 쭉 실행되다가 breakpoint가 있는 지점에 멈춰서 실행 대기를 한다.
		 * 
		 * 이후 상단의 Run - step over [단축키 F6]을 눌러 한줄한줄 코드를 실행해 본다.
		 * 
		 * 디버깅 모드를 종료하려면 Terminate [단축키 CTRL + F2] (콘솔창 쪽에 뜨는 빨간색 중지 버튼)
		 * 
		 * 이후 원래 화면(Perspective)으로 돌아오려면 우측 상단에서 Java Perspective를 클릭
		 */

		System.out.println("\n======================\n");
		// 트리
		// *
		// **
		// ***..
		// i=0 일때, 별은 1개, i=1 일때, 별은 2
		for (int i = 0; i < 5; i++) {
			String space = "";
			for (int k = 0; k < 4 - i; k++) {
				space += " ";
			}
			String stars = "";
			for (int k = 0; k < i + 1; k++) {
				stars += "*";
			}
			System.out.print(space);
			System.out.print(stars);
			System.out.print(stars);
			System.out.println(space);
		}

		System.out.println("\n==============진짜트리===================\n");
		// *
		// ***
		// *****

		// for문 5번 실행
		// i가 0,1,2,3,4, 일때
		// 공백은 4,3,2,1,0
		// 별은 1,3,5,7,9 다.
		for (int i = 0; i < 5; i++) {
			String space = "";
			String stars = "";
			for (int k = 0; k < 4 - i; k++) {
				space += " ";
			}

			for (int k = 1; k <= (i * 2) + 1; k++) {
				stars += "*";
			}
			System.out.println(space + stars);
		}
System.out.println("========================");
		// 트리 뒤집기
		for (int i = 0; i < 5; i++) {
			String space = "";
			String stars = "";
			for (int k = 0; k <= i; k++) {
				space += " ";
			}

			for (int k = 1; k < 9-(i*2); k++) {
				stars += "*";
			}
			System.out.println(space + stars);
		}

	}

}
