package ch10_extends_interface.starcraft;

import java.util.ArrayList;

public class StarCraftMain extends StarUnit {

	public static void main(String[] args) {
		Marine marine = new Marine("마린", 7, 60, 0);
		System.out.println(marine);

		marine.move(100, 200);
		marine.stimpack();
		System.out.println(marine);

		Marine marine2 = new Marine(); // 중복코드 발생을 막기 위해 클래스 내에 객체 생성
		System.out.println(marine2);

		HighTemplar hightemplar = new HighTemplar();

		Zealot zealot = new Zealot();
		System.out.println(zealot);

		zealot.move(10, 5);

		Zealot zealot2 = new Zealot();
		Zealot zealot3 = new Zealot();
		Zealot zealot4 = new Zealot();
		Zealot zealot5 = new Zealot();
		Zealot zealot6 = new Zealot();

		HighTemplar highTemplar = new HighTemplar();
		System.out.println(highTemplar);

		highTemplar.thunderStorm();

		// 질럿을 드래그로 선택 후 한번에 이동명령 내리기
		ArrayList<Zealot> protossList = new ArrayList<>();

		// 하이템플러도 같이 드래그해서 이동시키고 싶지만
		// ArrayList<Zealot>에는 담을 수 없다.
		// 이럴때 다형성을 사용한다(Polymorphism)
		// 하나의 객체가 여러 타입을 가질 수 있는 것을 의미
		// 자식 객체에서 부모 객체로 형변환이 가능하다.
		StarUnit hightemplar2 = new HighTemplar();
		// 자식에서 부모로의 형변환은 자동 형변환이 된
		// Object로 하면 전부 다형성이 매겨지긴함
		Object obj = hightemplar2;
		Object tmep = new Zealot();

		ArrayList<StarUnit> starList = new ArrayList<>();
		// starList는 StarUnit의 자식 객체들을 전부 담을 수 있다.
		starList.add(zealot);
		starList.add(zealot2);
		starList.add(zealot3);
		starList.add(zealot4);
		starList.add(zealot5);
		starList.add(zealot6);
		starList.add(highTemplar);
		starList.add(hightemplar2);
		starList.add(marine);

		protossList.add(zealot);
		protossList.add(zealot2);
		protossList.add(zealot3);
		protossList.add(zealot4);
		protossList.add(zealot5);
		protossList.add(zealot6);
		for (int i = 0; i < protossList.size(); i++) {
			protossList.get(i).move(50, 70);
		}

		marine.attack(zealot6);
		System.out.println(zealot6);

		System.out.println("\n=======================\n");

		// HighTemplar(자식) 이 StarUnit(부모)로
		// 형변환이 되어있기 때문에
		// 부모가 가지고 있지 않은 메소드는 사용불가
//		starList.get(4).thunderStrom*();

		// 자식 -> 부모 상태인 객체를
		// 부모 -> 자식이 형변환한 후 자식의 메소드 사용
		// 부모 -> 자식은 자동 형변환 안됨(수동)
//		HighTemplar welcome = (HighTemplar) starList.get(4);
//		welcome.thunderStorm();

//		((HighTemplar) starList.get(4)).thunderStorm();

		// for문을 돌려서 이 객체가 원래는 하이템플러였다면
		// 썬더스톰을 쓰도록하기

		// 하이템플러 -> 스타유닛 - > 하이템플러(O) // 개구리가 변신헀다면 다시 돌아갈때는 개구리로 돌아가야 한다.
		// 하이템플러 -> 스타유닛 -> 질럿, 마린(X)

//		((HighTemplar) starList.get(0)).move(5, 5);

		for (int i = 0; i < starList.size(); i++) {
			if (starList.get(i).getName().equals("하이템플러")) {
				((HighTemplar) starList.get(i)).thunderStorm();
			}

			// 객체 instanceof 클래스
			// 좌측의 객체가 우측의 클래스로 형변환이
			// 가능하다면 true, 불가능하다면 false 리턴
			if (starList.get(i) instanceof HighTemplar) {
				((HighTemplar) starList.get(i)).thunderStorm();
			}

			// 마린이면 stimpack() 쓰기
			if (starList.get(i) instanceof Marine) {
				((Marine) starList.get(i)).stimpack();
			}

			// 부모 객체
			StarUnit scv = new StarUnit("SCV", 5, 60, 0);

			// 일반적으로 부모 객체는 자식 객체로 형변환할 수 없다.(부모객체는 자식 객체에 추가적으로 있는 메소드나 기능을 포함하고 있지 않기 때문)
			System.out.println(scv instanceof Zealot);

			// 자식 객체는 부모 객체로 형변환이 가능하다.
			System.out.println(zealot instanceof StarUnit);

			// 부모 객체로 형변환 되었던 자식 객체는
			// 다시 자식 타입으로 형변환이 가능하다
			System.out.println(starList.get(0) instanceof Zealot);
		}

	}
}
