package ch09_class.nextit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ch09_class.school.Student;

//main 메소드를 보유하고 있는 클래스(실행의 주체가 됨)
public class NextMain {

	public static void main(String[] args) {
		// 학생 상태 관리
		String changyeonName = "창연";
		int changyeonAge = 30;
		int changyeonLevel = 2;
		int changyeonExp = 80;

		// 하루가 지나면 경험치를 얻고(20~60)
		// 경험치가 100이 넘으면 레벨을 1 올려준다.
		int rand = (int) (Math.random() * 41) + 20;
		changyeonExp += rand;
		System.out.println("창연씨의 현재 경험치 : " + changyeonExp);

		if (changyeonExp >= 100) {
			changyeonLevel++;
			changyeonExp -= 100;
			System.out.println("레벨업!!");
			System.out.println("창연씨의 현재 레벨 : " + changyeonLevel);
			System.out.println("창연씨의 현재 경험치 : " + changyeonExp);
		}

		String minkiName = "민기";
		int minKiage = 28;
		int minkiLevel = 3;
		int minkiExp = 70;

		// 하루가 지났다.
		rand = (int) (Math.random() * 41) + 20;
		minkiExp += rand;
		System.out.println("민기씨의 현재 경험치 : " + minkiExp);

		if (minkiExp >= 100) {
			System.out.println("레벨업!!");
			minkiLevel++;
			minkiExp -= 100;
			System.out.println("민기씨의 현재 레벨 : " + minkiLevel);
			System.out.println("민기씨의 현재 경험치 : " + minkiExp);
		}

		System.out.println("\n=======================\n");
		// 클래스를 통한 객체 생성
		NextStudent junho = new NextStudent();

		// 클래스에 선언된 필드 변수들을 가지고 있다.
		System.out.println(junho.name); // null
		System.out.println(junho.age); // 0
		System.out.println(junho.level); // 0
		System.out.println(junho.exp); // 0

		// 필드의 변수의 값에는 기본적으로 기본값(디폴트)
		// 이 들어있다.
		// 기본타입 : 숫자(0), boolean(false)
		// 참조타입 : null;

		// 객체의 필드변수에 값 넣기
		junho.name = "준호";
		junho.age = 30;
		junho.level = 2;
		junho.exp = 90;
		System.out.println(junho);
		System.out.println(junho.name); // null
		System.out.println(junho.age); // 0
		System.out.println(junho.level); // 0
		System.out.println(junho.exp); // 0

		// 하루가 지났다.
		rand = (int) (Math.random() * 41) + 20;
		junho.exp += rand;
		System.out.println("준호씨의 현재 경험치 : " + junho.exp);

		if (junho.exp >= 100) {
			System.out.println("레벨업!!");
			junho.level++;
			junho.exp -= 100;
			System.out.println("준호씨의 현재 레벨 : " + junho.level);
			System.out.println("준호씨의 현재 경험치 : " + junho.exp);
		}
		// 태윤씨도 추가
		NextStudent taeyoon = new NextStudent();
		taeyoon.name = "태윤";
		taeyoon.age = 28;
		taeyoon.level = 3;
		taeyoon.exp = 70;
		System.out.println("\n========================\n");

		// 하루가 지났다.
		taeyoon.endDay();
		junho.endDay();

		System.out.println("\n=========================\n");

		// 지혜
		// 객체를 생성하면서 필드변수 값을 채운다.
		// 생성자의 파라미터 순서에 유의해서 필드 변수의 값을 넣는다.
		NextStudent jihye = new NextStudent("지혜", 28, 3, 40); // 추가 생성자에서 선언한 인자를 넣지 않아 기본 생성자가 실행되었다.
		System.out.println(jihye.name);
		System.out.println(jihye.age);
		System.out.println(jihye.level);
		System.out.println(jihye.exp);

		// 객체의 상태를 한번에 보고싶다!!
		// 클래스 안에 toString()이라는 메소드 오버라이딩을 한다.
		// syso 내에 객체를 넣게 되면, toString()의 실행결과가
		// 콘솔창에 출력된다.
		System.out.println(jihye);
		System.out.println(jihye.toString());

		System.out.println("\n=====================\n");
		// 여러분들의 짝꿍에 대해 객체로 만들어주시는데
		// 레벨과 경험치는 1, 0으로 고정해서 만들어 보세요
		NextStudent jayoung = new NextStudent("자영", 26, 1, 0);
		NextStudent sungbok = new NextStudent("성복", 36, 1, 0);
		System.out.println(jayoung);
		System.out.println(sungbok);

		// 레벨과 경험치는 1과 0으로 고정
		// 객체를 생성할 때, 레벨과 경험치를 건드리지는 않는다.
		NextStudent junha = new NextStudent("준하", 40);
		System.out.println(junha);

		System.out.println("\n=========================\n");

		// 객체 복사
		// 같은 필드변수 값을 가지는 새로운 객체 생성
		// 클래스 = 클래스는 배열과 같이 Call by Reference이기 때문에 수정시 값이 같이 바뀜
		NextStudent junhaBot = new NextStudent(junha.name, junha.age);
		System.out.println(junhaBot);
		junhaBot.name = "준하봇";
		System.out.println(junhaBot);
		System.out.println(junha);

		// 하루가 지났다.
		jihye.endDay();
		junha.endDay();
		junho.endDay();
		taeyoon.endDay();

		// 다수의 객체를 다루기 위해서 ArrayList에 담기
		ArrayList<NextStudent> stuList = new ArrayList<>();
		stuList.add(jihye);
		stuList.add(taeyoon);
		stuList.add(junhaBot);
		stuList.add(junha);
		stuList.add(sungbok);
		stuList.add(junho);
		System.out.println("\n===========한번에 다루기=============\n");
		for (int i = 0; i < stuList.size(); i++) {
			stuList.get(i).endDay();
		}

		// 향상된 for문
		for (NextStudent stu : stuList) {
			stu.endDay();
		}

		// 객체를 생성하면서 ArrayList에 담기
		stuList.add(new NextStudent("자영2", 26));

		System.out.println(stuList.size());

		// 16일이 지났다..
		for (int i = 1; i <= 16; i++) {
			System.out.println("\n");
			System.out.println(i + "일이 지난 후!");
			for (NextStudent str : stuList) {
				str.endDay();
			}
		}

		System.out.println("\n=============================\n");
		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}

		// 레벨을 이용하여 정렬하기
		// Collctions.sort()는 정렬 기준을 모르면 에러가 난다.
		// Collections.sort(stuList);
		System.out.println("\n=========================\n");
		// 버블정렬을 이용하여 정렬하기
		// 변수명 한번에 바꾸기 단축키 [ALT + SHIFT + R]
		// stuList [준하][준하봇][준호][자영2]..
		for (int k = 0; k < stuList.size() - 1; k++) {
			for (int i = 0; i < stuList.size() - 1; i++) {
				if (stuList.get(i).level > stuList.get(i + 1).level) {
					NextStudent t = stuList.get(i);
					stuList.set(i, stuList.get(i + 1));
					stuList.set(i + 1, t);
				}
			}
		}

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(i + 1 + "등 " + stuList.get(i));
		}

		System.out.println("\n=========================\n");

		// 정렬 기준을 알려주면
		// Collections.sort()를 사용할 수 있다.
		// 리턴값이 양수면 자리를 바꾸고, 음수면 냅둔다.
		Collections.sort(stuList, new Comparator<NextStudent>() {
			public int compare(NextStudent stuA, NextStudent stuB) {
				return stuA.level - stuB.level;
			}
		});

		// 람다식 사용(오름차순)
		Collections.sort(stuList, (stuA, stuB) -> stuA.level - stuB.level);
		
		for (int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
		
		System.out.println("\n=====================================\n");
		
		//stuB - stuA는 내림차순
		Collections.sort(stuList, (stuA, stuB) -> stuB.level - stuA.level);
		for (int i = 0; i < stuList.size(); i++) {
			System.out.println((i+1) + "등. " + stuList.get(i));
		}
		
	}

}
