package ch11_api;

import java.util.regex.Pattern;

public class ApiPattern {
	public static void main(String[] args) {
		//	정규 표현식
		//	특정한 규칙을 가진 문자열의 집합을
		//	표현하기 위해 쓰는 형식
		
		//	전화번호 (3자리 - 4자리 - 4자리), (전부 숫자)
		//	주민등록번호(6자리-7자리), (전부 숫자)
		//	이메일 (영어와 숫자로 이루어진 문자열@영어.영어)
		//	위와 같이 정해진 형식에 대해 정규표현식과
		//	Pattern을 이용하여 검증할 수 있다.
		
		//	숫자만 존재하는지 검증(Validation)
		String example = "137657863";
		//	문자열의 시작(^)과 끝($) 사이에 숫자([0-9])가 1개 이상(+)인지 체크
		String regex = "^[0-9]+$";
	
		// Pattern.matches를 하면 검증 결과가 true/false로 리턴
		boolean result = Pattern.matches(regex, example);
		System.out.println(result);
		
		//	문자열에 .matches(regex) 해도 된다.
		System.out.println(example.matches(regex));
	
		System.out.println("\n=========숫자 검증============\n");
		//	숫자만 존재하는지 검증 2
		// [0-9] == \\d;
		regex = "\\d+";
		result = Pattern.matches(regex, example);
		System.out.println(result);
		
		System.out.println("\n==========알파벳 검증=============\n");
		
		//	알파벳만 존재하는지 검증
		example = "JeongChanung";
		regex = "[a-zA-Z]+";
		System.out.println(example.matches(regex));
		
		System.out.println("\n==========띄어쓰 검증=============\n");
		//	띄어쓰기를 포함시키기
		//	띄어쓰기 = \\s;
		example = "Jeong Chanung";
		regex = "[a-zA-Z\\s]+";
		System.out.println(example.matches(regex));
		
		System.out.println("\n==========한 검증=============\n");
		//	한글만 존재하는지 검증
		example = "찬웅흏ㄱㄱㅎㅎㅏㅠ";
		regex = "[가-힣ㄱ-ㅎㅏ-ㅣ]+";
		result = example.matches(regex);
		System.out.println(result);
		
		System.out.println("\n========비밀번호 패턴============\n");
		// 6자리 숫자 like pin 번호
		example = "637843";
		regex = "[0-9]{6,}"; // 6자리부터 N자리까지(, 뒤에 숫자 없는경우 무한 / 있는경우 해당 숫자까지)
		result = example.matches(regex);
		System.out.println(result);
		System.out.println("helloworld");
		
	}
}
