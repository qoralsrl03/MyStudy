package ch13_thread.isac;

public class IssacMain {

	public static void main(String[] args) {
		Chef mingi = new Chef();

		// mingi의 일이 언제끝날지는 모르지만
		// 끝나고 ~해라는 할 수 있다. => 콜백함수 (인터페이스 사용)

		mingi.endcook = new EndCook() {

			@Override
			public void finish() {
				System.out.println("민기 : 장사 끝~ 퇴근합니다~");
			}
		};

		Customer sungbok = new Customer(4, "성복");
		Customer jayoung = new Customer(7, "자영");
		Customer changyeon = new Customer(1, "창연");

		mingi.start();
		sungbok.start();
		jayoung.start();
		changyeon.start();
	}

}
