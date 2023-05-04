package ch13_thread;

public class ThreadMain {
	public static void main(String[] args) {
		// 클래스 내에 있는 메소드는 사용하기 위해서 메소드에 static 선언 또는 해당 클래스의 객체 선언을 해야한다
//		ThreadMain thread = new ThreadMain();
//		thread.printNumber(50);
//		thread.printNumber(10);

		// 기본적으로 스레드를 나눠주지 않으면
		// 메인 스레드 하나만 일을 해서
		// 위에서부터 차례대로 코드가 실행된다.
		System.out.println("\n=========================\n");

		// 1. Thread를 상속받는 클래스를 만들어서 멀티 스레드를 구현하기
		// >MyStaff.java 클래스 확인<
		MyStaff junho = new MyStaff(10, "준호"); // 스레드 B
		MyStaff yujeong = new MyStaff(50, "유정"); // 스레드 C

		// 객체.start() 를 해주면 해당 메소드의 run() 메소드가 실행된다.
		junho.start();
		yujeong.start();
		// 다른 스레드에게 일을 줄때는 인지해야하는 것은
		// 해당 스레드들이 언제 일이 끝날지 모른다는 것
		// 그래서 일을 주면 먼저 시작한 스레드가 나중에 시작한 스레드보다 늦게끝나기도 함
		// 보통 언제 끝나는지 알 수 없어서 끝나고 나서 ~해라 정도의 명령어가 붙음(success: 또는 fail:이 붙음)
		System.out.println("[메인 스레드] 업무 분담 끝");

		System.out.println("\n==================================\n");

		// 2. Runnable 인터페이스 구현(implements)한
		// 클래스를 이용
		RunStaff donguk = new RunStaff("동욱", 80);
		Thread dongukT = new Thread(donguk);
		dongukT.start(); // RunStaff 내 run 메소드가 실행된다.

		Thread doungyun = new Thread(new RunStaff("동윤", 100));
		doungyun.start();

		// 람다식 사용
		Thread jihye = new Thread(() -> {
			int num = 140;
			for (int i = 0; i < 5; i++) {
				System.out.println(num++);

				try {
					// 현재 이 코드를 실행중인 스레드가 멈추는 것
					// 멀티스레드 환경에서 다른 스레드는 영향 받지 않는다.
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		jihye.start();
		System.out.println("[메인 스레드] 전 이만 퇴근~");
		// 10
		// 11
		// 12
		// 13
		// 14
		int num = 10;
		for (int i = 0; i < 5; i++) {
			System.out.println(num++);
		}

		// 50
		// 51
		// 52
		// 53
		// 54
		num = 50;
		for (int i = 0; i < 5; i++) {
			System.out.println(num++);
		}
	} // main
		// 끝-----------------------------------------------------------------------------------------

	public void printNumber(int num) {
		for (int i = 0; i < 5; i++) {
			System.out.println(num++);

			try {
				// 현재 이 코드를 실행중인 스레드가 멈추는 것
				// 멀티스레드 환경에서 다른 스레드는 영향 받지 않는다.
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
