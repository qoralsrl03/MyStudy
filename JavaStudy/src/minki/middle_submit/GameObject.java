package minki.middle_submit;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//게임 구성에 필요한 요소를 모은 클래스
public class GameObject {
	private int distance; // 한번이동거리
	private int x, y, count = 0; // x축, y축, 이동횟수
	int rand; // 쌓일 벽의 갯수를 지정해줄 확률값을 정해줄 랜덤
	private static char[][] map = new char[10][20]; // 이중 배열을 통한 맵 및 유저 이동좌표
	User user = new User();
	Scanner scan = new Scanner(System.in);

	GameObject() {
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void wallCheck() {
		int ea = 0;
		int rand2 = 0;
		for (y = 1; y < map[x].length; y += 2) {
			for (int i = 0; i < map.length; i++) {
				if (map[i][y] == '❗') {
					ea++;
				}
				if (ea == map.length) {
					ea = 0;
					rand2 = (int) (Math.random() * 10);
					map[rand2][y] = '➖';
				}
			}

		}
	}

	// 맵, 사용자, 목적지를 그려주는 메소드
	public void showMap() throws InterruptedException {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				rand = (int) (Math.random() * 10);
				map[x][y] = '➖';
				if (y % 2 == 1) {
					if (rand < 7) {
						map[x][y] = '❗';
					}
				}
				if (x == 0 && y == 0) {
					map[x][y] = user.shape();
				}

				if (map[x][y] == map[map.length - 1][map[x].length - 1]) {
					map[map.length - 1][map[x].length - 1] = '⛱';
				}
				System.out.print(map[x][y]);
				Thread.sleep(10); // 맵이 천천히 구현되어 게임이 시작되는 느낌 구현
			}
			
			System.out.println();
		}
	}

	// 유저가 이동시 맵에서 유저의 위치가 업데이트 되도록 해주는 메소드
	public void moveMap() throws InterruptedException {
		boolean call = collide();
		long beforeTime = System.currentTimeMillis();
		wallCheck();
		System.out.print("현재시간! : ");
		nowTime();
		outer: while (true) {
			// 목적지 도착 전까지 무한 반복
			System.out.println("방향키 입력:(W,A,S,D)");
			System.out.print(">>> ");
			String str = scan.nextLine(); // 방향키를 받을 변수
			user.convertInput(str);
			count++;
			// 유저가 배열의 범위 밖으로 나가는지 체크
			if (user.getX() < 0 || user.getY() < 0 || user.getX() >= map.length || user.getY() >= map[x].length) {
				call = true;
			} else {
				call = collide();
			}
			// 벽에 부딪힌 경우
			if (call == true) {
				clearScreen();
				System.out.println("벽과 충돌하였습니다~");
				user.reverseInput(str);
				Thread.sleep(10);
				for (int x = 0; x < map.length; x++) {
					for (int y = 0; y < map[x].length; y++) {
						if (x == user.getX() && y == user.getY()) {
							System.out.print(user.shape());
						} else {
							System.out.print(map[x][y]);
						}
					}
					System.out.println();
				}
				continue outer;

			} else if (call == false) {// 정상적으로 이동하는 경우
				clearScreen();
				map[0][0] = '➖';
				for (int x = 0; x < map.length; x++) {
					for (int y = 0; y < map[x].length; y++) {
						if (x == user.getX() && y == user.getY()) {
							System.out.print(user.shape());
						} else {
							System.out.print(map[x][y]);
						}
					}
					System.out.println();
				}
			}
			// 목적지에 도착한 경우
			if (map[user.getX()][user.getY()] == map[map.length - 1][map[x].length - 1]) {
				long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
				long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
				clearScreen();
				Art.gameEnd(count);
				System.out.println(secDiffTime + "초 걸렸습니다!");
				break;
			}
		}
	}

	public void clearScreen() {
		for (int i = 0; i < 40; i++) {
			System.out.println("");
		}
	}

	public char[][] getMap() {
		return map;
	}

	@SuppressWarnings("static-access")
	public void setMap(char[][] map) {
		this.map = map;
	}

	public boolean collide() { // 충돌했을때 true 리턴
		if (map[user.getX()][user.getY()] == '❗') {
			return true;
		} else {
			return false;
		}
	}

	public void nowTime() {
		ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(
		    Instant.ofEpochMilli(System.currentTimeMillis()), seoulZoneId);

		// 시간 형식을 지정합니다.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		// 시간을 형식화합니다.
		String formattedTime = formatter.format(zonedDateTime);

		System.out.println(formattedTime);
	}
}
