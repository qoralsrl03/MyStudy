package minki.middle_submit;

import java.util.Scanner;


public class GameMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		GameObject go = new GameObject();
		Scanner scan = new Scanner(System.in);
		
		//게임이 종료되기 전까지 무한 반복
		while (true) {
			Art.gameCover();
			System.out.println("게임을 시작하시겠습니까?(Y/N)");
			if (scan.nextLine().equalsIgnoreCase("Y")) {
				Art.gameStart();
				go.showMap();		
				go.moveMap();
				break;
			}
				
			else {
				break;
			}
		}

	}
}
