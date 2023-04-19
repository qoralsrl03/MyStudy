package ch09_class.typing;

import java.util.ArrayList;
import java.util.Scanner;

public class TypingMain {
	public static void main(String[] args) {

		// 타자 연습 게임
		Scanner scan = new Scanner(System.in);

		// 단어 목록
		// Dictionary dict = new Dictionary(); --static으로 선언한 다른 메소드는 클래스명.메소드명 으로만 써도
		// 사용 가능,
		// 굳이 객체로 선언하지 않아도 괜찬음
		// Math.Random 도 static 메소드이기에 클래스명.메소드명으로만 써도 사용 가능함
		ArrayList<String> wordList = Dictionary.makeWordList(Dictionary.OPTION_RANDOM_ALPHABET);
		

		// 현재 시간 저장
		// 1970년 1월 1일을 기준으로
		// 현재까지 경과된 시간을 밀리초 단위로 리턴(1초 = 1000밀리)
		long before = System.currentTimeMillis();
		System.out.println(before);

		while (true) {
			// wordList에 담긴 단어가 랜덤하게 출력
			// 랜덤 실행 결과가 wordList의 인덱스 중 하나
			// = wordList의 인덱스 0 ~ wordList.size() -1
			int rand = (int) (Math.random() * wordList.size());
			System.out.println(wordList.get(rand));
			// 출력된 단어를 입력
			System.out.println(">>> ");
			String input = scan.nextLine();

			// 입력한 단어가 출력된 단어와 일치하는지 체크
			if (wordList.get(rand).equals(input)) {
				// 일치한다면 wordList에서 해당 단어를 삭제
				wordList.remove(rand);
			}
			// 일치하지 않으면 해당 단어가 삭제되지 않아서 또 입력하게 된다.

			// 위 과정을 반복(wordList.size()가 0이 될때까지)
			if (wordList.size() == 0) {
				break;
			}
		}
		long after = System.currentTimeMillis();
		// after에서 before를 빼면, 타자를 친 시간이 구해진다.
		long diff = after - before; // diff는 밀리초 단위

		// 초 단위로 변환
		// 31.872초가 걸렸다면 31872밀리초가 노출된다.
		double result = diff / 1000.0; // 31.0초
		System.out.println(result + "초 걸리셨습니다.");
	}
}
