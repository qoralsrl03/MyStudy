package minki.middle_submit;

//█ ╔ ═ ╦ ╗╚║╝╬╠ ╩ ╣
public class Art {
	//목적지에 도착하여 게임이 끝나는 경우 끝을 알리는 메소드
	public static void gameEnd(int count) throws InterruptedException {
		Art.end();
		Thread.sleep(10);
		System.out.println("골~인!");
		Thread.sleep(100);
		System.out.println(count+"회 움직였습니다!");
		Thread.sleep(700);
		Art.gameScore(count);
	}
	
	//이동한 횟수를 계산해서 해당하는 숫자의 도트 모양을 출력시켜주는 클래
	public static void gameScore(int count) {
		
		String countStr = Integer.toString(count);
		for (int i = 0; i < countStr.length(); i++) {
			int temp = countStr.charAt(i) - '0'; // 아스키코드값을 빼줌으로써 문자를 숫자로 형변환 시킨다. 
			//ex). 7의 ASCII값은 55. 여기서 0의 ASCII값 48을 빼주면 55-48을 해서 7이라는 숫자를 얻을 수 있다. 다른 숫자도 모두 적용 가능
			switch (temp) {
			case 0:
				zero();
				break;
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			case 7:
				seven();
				break;
			case 8:
				eight();
				break;
			case 9:
				nine();
				break;
			default:
				break;
			}
		}
	}

	//게임 표지
	public static void gameCover() {
		System.out.println("╔═════════════════════════════════════════════╗");
		System.out.println("║████╗░░░████╗░░░█████╗░░░█████████╗█████████╗║");
		System.out.println("║██╔██╗░██╦██║░██╔════██░╗╚═════███║███╔═════╝║");
		System.out.println("║██║╚████╝║██║░█████████░║░╔═███══╝░█████████╗║");
		System.out.println("║██║░║██║░║██║░██╔════██░║███░╔═══░░███╔═════╝║");
		System.out.println("║██║░╚██║░║██║░██║░░░░██╔╝█████████╗█████████╗║");
		System.out.println("║╚═╝░░░░░░╚══╝░╚═╝░░░░╚═╝░╚════════╝╚════════╝║");
		System.out.println("╚═════════════════════════════════════════════╝");
	}

	//게임 시작을 알리는 표지
	public static void gameStart() {
		System.out.println("░░██████╗████████╗ █████╗░██████╗░████████╗╔███╗ ");
		System.out.println("██╔════╝ ╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝╚║█║╝");
		System.out.println("╚█████╗░░░░ ██║░░░███████║██████╔╝░░░██║░░░░║█║");
		System.out.println("░╚═══██╗░░░ ██║░░░██╔══██║██╔══██╗░░░██║░░░░║█║");
		System.out.println("██████╔╝░░░ ██║░░░██║░░██║██║░░██║░░░██║░░░░░░░");
		System.out.println("░╚═════╝░░░ ╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░░║█║");
	}

	//게임 종료 시 노출되는 메소드
	public static void end() {
		System.out.println("█████████╗██═╗░░░╔██╗████╚══╗░░");
		System.out.println("███╔═════╝████═╗░║██║██░░███╚╗░");
		System.out.println("█████████╗██╔╗██═╣██║██░░░░██║░");
		System.out.println("███╔═════╝██║░░╚████║██░░███╔╝░");
		System.out.println("█████████╗██║░░░░╚██║████╔══╝░░");
		System.out.println("╚════════╝╚═╝░░░░░╚═╝╚═══╝░░░░░");
	}

	public static void zero() {
		System.out.println("╔═══════════╗");
		System.out.println("║ ╔═█████══╗║");
		System.out.println("║║██░░░░░██║║");
		System.out.println("║║██░░░░░██║║");
		System.out.println("║║██░░░░░██║║");
		System.out.println("║ ╚═█████══╝║");
		System.out.println("║░░░░░░░░░░░║");
		System.out.println("╚═══════════╝");
	}

	public static void one() {
		System.out.println("╔═══════════╗");
		System.out.println("║ ╔████╗░░░░║");
		System.out.println("║██╔╗██║░░░░║");
		System.out.println("║╚═╝║██║░░░░║");
		System.out.println("║░░░║██║░░░░║");
		System.out.println("║╔█████████╗║");
		System.out.println("║╚═════════╝║");
		System.out.println("║░░░░░░░░░░░║");
		System.out.println("╚═══════════╝");
	}

	public static void two() {
		System.out.println("╔═══════════╗");
		System.out.println("║╔═█████══╗░║");
		System.out.println("║╚██═╗  ██╝░║");
		System.out.println("║░░╔═╝██╝░░░║");
		System.out.println("║╔═╝██╝░░░░░║");
		System.out.println("║║█████████╗║");
		System.out.println("║░░░░░░░░░░░║");
		System.out.println("╚═══════════╝");
	}

	public static void three() {
		System.out.println("╔═══════════╗");
		System.out.println("║╔═█████═╗░░║");
		System.out.println("║╚██═══╗██░░║");
		System.out.println("║░░░░══██ ║░║");
		System.out.println("║╔██════██░░║");
		System.out.println("║╚═█████═╝░░║");
		System.out.println("║░░░░░░░░░░░║");
		System.out.println("╚═══════════╝");
	}

	public static void four() {
		System.out.println("╔═══════════╗");
		System.out.println("║╔██╗░╔██╗░░║");
		System.out.println("║║██║░║██║░░║");
		System.out.println("║║██╚═╝██╚═╗║");
		System.out.println("║║█████████║║");
		System.out.println("║╚════╗██╔═╝║");
		System.out.println("║░░░░░╚══╝░░║");
		System.out.println("╚═══════════╝");
	}

	public static void five() {
		System.out.println("╔═══════════╗");
		System.out.println("║╔████████╗░║");
		System.out.println("║║██╔═════╝░║");
		System.out.println("║║████████╗░║");
		System.out.println("║╚═════╗██║░║");
		System.out.println("║╔████████║░║");
		System.out.println("║╚════════╝░║");
		System.out.println("╚═══════════╝");
	}

	public static void six() {
		System.out.println("╔═══════════╗");
		System.out.println("║╔████████╗░║");
		System.out.println("║║██╔═════╝░║");
		System.out.println("║║████████╗░║");
		System.out.println("║║██░░░░██║░║");
		System.out.println("║║████████║░║");
		System.out.println("║╚════════╝░║");
		System.out.println("╚═══════════╝");
	}

	public static void seven() {
		System.out.println("╔═══════════╗");
		System.out.println("║╔████████╗░║");
		System.out.println("║║██╔══╗██║░║");
		System.out.println("║║██║░░║██║░║");
		System.out.println("║╚══╝░░║██║░║");
		System.out.println("║░░░░░░║██║░║");
		System.out.println("║░░░░░░╚══╝░║");
		System.out.println("╚═══════════╝");
	}

	public static void eight() {
		System.out.println("╔═══════════╗");
		System.out.println("║╔████████╗░║");
		System.out.println("║║██░░░░██║░║");
		System.out.println("║║████████║░║");
		System.out.println("║║██░░░░██║░║");
		System.out.println("║║████████║░║");
		System.out.println("║╚════════╝░║");
		System.out.println("╚═══════════╝");
	}

	public static void nine() {
		System.out.println("╔═══════════╗");
		System.out.println("║╔████████╗░║");
		System.out.println("║║██░░░░██║░║");
		System.out.println("║║████████║░║");
		System.out.println("║╚═════╗██║░║");
		System.out.println("║╔████████║░║");
		System.out.println("║╚════════╝░║");
		System.out.println("╚═══════════╝");
	}
}
