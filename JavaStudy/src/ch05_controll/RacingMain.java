package ch05_controll;

public class RacingMain {

	public static void main(String[] args) throws InterruptedException {
		String lane1 = "1.";
		String lane2 = "2.";
		String lane3 = "3.";
		String lane4 = "4.";
		String lane5 = "5.";

		while (true) {
			// 확률에 따른 전진
			// random에 0~7중 숫자가 랜덤으로 들어감
			int random = (int) (Math.random() * 8);

			// 1/8확률
			if (random == 1) {
				lane1 += "=";
			} else if (random == 2) {
				lane2 += "=";
			} else if (random == 3) {
				lane3 += "=";
			} else if (random == 4) {
				lane4 += "=";
			}

			// 콘솔창에 줄바꿈 20번 해서
			// 기존 텍스트를 지운다.
			for (int i = 0; i <= 20; i++) {
				System.out.println(" ");
			}
			// 진행 상황 출력
			System.out.println(lane1 + "🐴");
			System.out.println(lane2+ "🐴");
			System.out.println(lane3+ "🐴");
			System.out.println(lane4+ "🐴");

			// 결승선 통과 처리
			if (lane1.length() == 40) {
				System.out.println("1번 승리!!" + "🐫");
				break;
			} else if (lane2.length() == 40) {
				System.out.println("2번 승리"+ "🐫");
				break;
			} else if (lane3.length() == 40) {
				System.out.println("3번 승리"+ "🐫");
				break;
			} else if(lane4.length() == 40){
				System.out.println("4번 승리"+ "🐫");
				break;
			}
			try {
				Thread.sleep((long) 10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
