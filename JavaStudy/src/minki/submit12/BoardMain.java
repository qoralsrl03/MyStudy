package minki.submit12;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		int isstop = 0;
		Scanner scan = new Scanner(System.in);
		BoardDB boarddb = BoardDB.getInstance();
		
		
		while(isstop!=3) {
			System.out.println("행동을 선택해 주세요");
			System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
			System.out.print(">>>");
			isstop = Integer.parseInt(scan.nextLine());
			
			if(isstop==1) {
				boarddb.showBoard();
			}else if(isstop==2) {
				boarddb.writeBoard();
			}else {
				System.out.println("종료합니다");
			}
		}
	}

}
