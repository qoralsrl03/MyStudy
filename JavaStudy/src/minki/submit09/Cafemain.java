package minki.submit09;

import java.util.ArrayList;
import java.util.Scanner;

public class Cafemain {

	public static void main(String[] args) {
		Cafe starBucks = new Cafe("스타벅스");
		starBucks.addCoffee(new Coffee("아메리카노", 5000));
		starBucks.addCoffee(new Coffee("카푸치노", 6000));
		starBucks.addCoffee(new Coffee("오곡라떼", 7000));
		
		Cafe conte = new Cafe("꽁떼");
		conte.addCoffee(new Coffee("아메리카노", 2500));
		conte.addCoffee(new Coffee("바닐라라떼", 3000));
		conte.addCoffee(new Coffee("아이스티", 3500));
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 스타벅스 방문 | 2. 꽁떼 방문 | 3. 사무실 복귀..");
			System.out.print(">>> ");
			int select = Integer.parseInt(sc.nextLine());
			
			// 코드 작성 시작	
			if(select == 1) {
				//TODO 스타벅스 방문
				System.out.println("어서오세요 스타벅스 입니다.");
				starBucks.showMenu();
				starBucks.buyCoffee(sc);
				
				
			}else if(select == 2) {
				//TODO 콘테 방문
				System.out.println("어서오세요 콘테 입니다.");
				conte.showMenu();
				conte.buyCoffee(sc);
				
			}else {
				//사무실 복귀
				System.out.println("사무실로 복귀합니다..");
				break;
			}
		}
	}

}
