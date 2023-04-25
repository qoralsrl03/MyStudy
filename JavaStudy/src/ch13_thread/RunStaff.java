package ch13_thread;

public class RunStaff implements Runnable {
	String name;
	int num;

	public RunStaff() {}

	public RunStaff(String name, int num) {
		this.name = name;
		this.num = num;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + num++);
		}

		try {
			// 현재 이 코드를 실행중인 스레드가 멈추는 것
			// 멀티스레드 환경에서 다른 스레드는 영향 받지 않는다.
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
