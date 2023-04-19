package ch05_controll;

public class Conditional {

	// 전역변수
	// class 중괄호 안에 선언된 변수
	// 해당 클래스 내에 어디서든 사용 가능
	static String subject = "나는야 전역변수";

	public static void main(String[] args) {
		// 조건문

		// if문
		int price = 30000;
		int myMoney = 10000;

		// if문의 블록{} 안 명령어가 한 줄이면 블록{} 생략 가능
		if ((myMoney < price)) {
			System.out.println("돈이 부족합니다.");
		} else {
			System.out.println("돈은 충분한듯합니다.");
		}

		System.out.println("\n=============변수의 사용범위(scope)================\n");
		// 중괄호 블록{} 내부에 선언된 변수는
		// 해당 중괄호 바깥에서 사용할 수 없다. (지역 변수)
		String warning = "";
		String review = "맛잇어요~";
		if (review.length() > 12) {
			warning = "리뷰는 12자 이상 작성하세요";
			// if 문 안의 블록에서 선언된 변수는 블록 밖에서 사용 불가하다
		} else {
			warning = "통과";
		}

		warning = (review.length() < 12) ? ("리뷰는 12자 이상 입력하세요") : "통과";
		System.out.println(warning);

		System.out.println(subject);

		System.out.println("\n================================\n");
		// else와 else if
		int numZero = 0;

		if (numZero < 0) {
			System.out.println("0보다 작다");
		} else if (numZero == 0) {
			System.out.println("0과 같다");
		} else {
			System.out.println("0보다 크다");
		}

		System.out.println("\n===========================\n");
		// 리모콘의 전원 버튼의 경우
		// 전원 버튼 하나로 on/off가 가능하다.
		boolean isPowerOn = false;
		for (int i = 2; i > 0; i--) {
			if (isPowerOn) {
				// TV가 켜져있는 경우
				System.out.println("TV를 끕니다.");
				isPowerOn = !isPowerOn;
			} else {
				// TV가 꺼져있는 경우
				System.out.println("TV를 켭니다.");
				isPowerOn = !isPowerOn;
			}
		}

		// boolean의 true/false 값을 스위치의 on/off 처럼
		// 사용하는 boolean 타입의 변수를
		// 토글(toggle) 또는 플래그(flag) 변수라고 한다.

		System.out.println("\n================================\n");
		// 이중 삼항 연산자로 썼던거
		int score = 85;
		String grade = "";

		// 90점 이상 A
		// 80점 이상 B
		// 그 외 C
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else {
			grade = "C";
		}
		System.out.println(grade);

		// 코드 압축 - 하나의 가정문을 초기값으로 고정해놓으면 if문 하나 배제 가
		grade = "C";
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		}
		System.out.println(grade);

		// 순서에 주의해야하는 경우
		score = 92;
		if (score >= 80) {
			grade = "B";
		} else if (score >= 90) {
			grade = "A";
		} else {
			grade = "C";
		}
		System.out.println(grade + ">>\"A\"가 나와야 하지만 첫 if문 실행 후 종료됨");
		// 순서 신경쓰기는 세상이 팍팍하다.
		// 그러면 범위를 명확히 지정해라
		if (score >= 80 && score < 90) {
			grade = "B";
		} else if (score >= 90) {
			grade = "A";
		} else {
			grade = "C";
		}
		System.out.println(grade);

		System.out.println("\n==============================================\n");
		// 회원가입 조건 체크 IF문
		// 이름은 1글자 이상
		// 휴대폰 번호는 10~11자리
		// 나이는 14세 이상
		String name = "길똥";
		String phone = "010456256";
		int age = 13;
		// lv1
		if (name.length() >= 1) {
			System.out.println("이름이 입력되었습니다.");
			if (phone.length() >= 10 && phone.length() <= 11) {
				System.out.println("휴대폰 번호가 입력되었습니다.");
				if (age >= 14) {
					System.out.println("나이가 입력되었습니다.");
					System.out.println("이름 : " + name + "\n휴대폰번호 : " + phone + "\n나이 : " + age);
				} else {
					System.out.println("나이가 14세 미만입니다. 가입이 불가능합니다.");
				}
			} else {
				System.out.println("휴대폰 번호가 규칙에 어긋납니다. 다시입하세요");
			}
		} else {
			System.out.println("이름은 1글자 이상 입력해 주세요, 회원가입 실패!");
		}

		// lv2
		boolean isOkay = false;
		if (name.length() > 0) {
			if (phone.length() == 10 || phone.length() == 11) {
				if (age >= 14) {
					isOkay = true;
				}
			}
		}
		if (isOkay) {
			System.out.println("\n회원가입이 완료되엇습니다.");
		} else {
			System.out.println("\n회원가입에 실패하였습니다.");
		}

		// lv3
		if (name.length() > 0 && (phone.length() == 10 || phone.length() == 11) && age >= 14) {
			System.out.println("\n회원 가입 성공");
		} else {
			System.out.println("\n회원가입 실패");
		}

		System.out.println("\n==============Swith문================\n");
		// 값을 매칭하는 경우가 많을 때 사용
		// 교육기간(단위 : 월)
		int month = 0;
		if (month == 0) {
			System.out.println("열심히 배우는 중");
		} else if (month == 1) {
			System.out.println("DB 마스터");
		} else if (month == 2) {
			System.out.println("자바 마스터");
		} else if (month == 3) {
			System.out.println("화면 구현 마스터");
		} else if (month == 4) {
			System.out.println("JSP 마스터");
		} else if (month == 5) {
			System.out.println("팀 프로젝트 시작");
		} else {
			System.out.println("수료~!");
		}
		
		switch(month) {
		case 0:
			System.out.println("열심히 배우는중");
			break;
		case 1:
			System.out.println("DB 마스터");
			break;
		case 3:
			System.out.println("화면 구현 끝");
			break;
		case 4:
			System.out.println("JSP 끝");
			break;
		case 5:
			System.out.println("팀프로젝트 시작");
			break;
		default :
			System.out.println("예외");
			break;
		}
	}
}
