package ch04_operator;

public class OperatorMain {
	public static void main(String[] args) {
		int number = 10;
		System.out.println(number);
		System.out.println("\n==========증감연산자==========\n");
		// 증감 연산자
		number++; // 1증가
//		System.out.println(number);
		number--; // 1감소
//		System.out.println(number);

		++number; // 1증가는 동일하지만 식이 있을 때 먼저 증감연산을 수행
		System.out.println(++number); // 프린트문 수행전에 먼저 증가
		System.out.println(number++); // 프린트문 수행이후 증가
		System.out.println(number); // 출력

		System.out.println("\n==========대입연산자=============");
		number = 10;
		number += 99;
		System.out.println(number); // 109

		number -= 3;
		System.out.println(number); // 106

		number *= 2;
		System.out.println(number); // 212

		number /= 4;
		System.out.println(number); // 53

		number %= 3;
		System.out.println(number); // 2

		System.out.println("\n===========산술연산자=============\n");
		int numA = 10;
		int numB = 3;

		numA = numB + 5;
		System.out.println(numA);
		System.out.println("붙음 : " + numA + numB); // 문자열과 붙으면서 형변환이 일어남
		System.out.println("더하기 : " + (numA + numB)); // 괄호 사용하면 정상 계산 가능
		System.out.println("빼기 : " + (numA - numB)); // 괄호 사용하면 정상 계산 가능
		System.out.println("곱하기 : " + (numA * numB)); // 괄호 사용하면 정상 계산 가능
		System.out.println("나누기 : " + (numA / numB)); // 괄호 사용하면 정상 계산 가능
		System.out.println("나머지 : " + (numA % numB)); // 괄호 사용하면 정상 계산 가능

		// 먼저 계산할 부분에 대해서는 괄호가 필수
		int temp = 1 + (2 * 3); // 사칙연산 규칙이 지켜지긴 하지만 괄호써서 가시성 증대
		System.out.println(temp);

		System.out.println("\n=========나머지 연산자 사용 예시==========\n");

		// 홀수, 짝수 판별
		int anyNum = 5436;
		// anyNum을 2로 나눈 나머지가 0이면 짝수 1이면 홀수
		System.out.println(anyNum % 2);

		// 게시판 페이징 구현
		int totalCountText = 33; // 게시판에 총 33개의 글이 있음
		int showCountOnePage = 10; // 한 페이지에서 보여줄 글의 수

		// 총 페이지의 수
		// 33/10 = 3.3 -> 올림 해서 4페이지까지 필요함
		// Math.ceil() 올림 처리 해줌, 다만 올림처리해도 더블형을 반환하기 때문에 Int로 캐스팅이 필요함
		int countPage = (int) Math.ceil((double) totalCountText / showCountOnePage);
		System.out.println(countPage);

		// 마지막 페이지에 있는 글의 수
		// 33%10 = 3
		int countLastPageText = totalCountText % showCountOnePage;
		System.out.println(countLastPageText);

		System.out.println("\n============문자열 더하기==============\n");
		// 대입 연산자로도 문자열 더하기가 가능하지만 뒤에만 추가된다.
		String subway = "반석역";
		subway += " 지족역";
		subway = subway + " 노은역";
		System.out.println(subway);

		subway = "종점" + subway + " 월드컵경기장역";
		System.out.println(subway);

		System.out.println("\n=============비교 연산자==============\n");
		int numFive = 5;
		double pi = 3.14;
		int numOne = 1;

		// 비교 결과에 따라 true 또는 false 가 리턴된다.
		System.out.println((numFive > numOne));

		boolean result = numFive < numOne;
		System.out.println(result);

		// 자료형이 달라도 비교 가능함
		System.out.println(numFive >= pi);

		// 1+2 == 3 > ==는 왼쪽과 오른쪽이 같은지 비교
		// 같다면 true / 다르면 false
		System.out.println(1 + 2 == 3);
		System.out.println(numOne == numFive);

		// != 는 왼쪽과 오른쪽이 다른지 비교
		// 다르면 true / 같으면 false 리턴
		System.out.println(numOne != numFive);

		// 문자에 대해서도 비교 연산이 가능
		System.out.println('가' > '나'); // 가 = 44032, 나= 45000 쯤

		// 문자열 정렬 로직
		// 문자열 앞글자만 char 타입으로 꺼낸 후 비교하여 정렬하면 됨

		String stuA = "고동욱";
		String stuB = "김대일";
		System.out.println(stuA.charAt(0) + "" + (stuA.charAt(0) > stuB.charAt(0)));

		// 문자열이 같은지 비교
		// .equals(문자열)
		// 해당 문자열이 괄호안 문자열과 같은지 비교
		String ship = "배";
		String pear = "배";
		String bae = "배";
		System.out.println(ship == pear);
		System.out.println(ship == bae);
		System.out.println(ship.equals(bae));

		// 예시
		// 서버에서 데이터를 가져오는데 문제가 생기면
		// null 값으로 넘어온다.
		// 데이터를 받아오는 쪽에서 null 체크
		String serverDate = null;
		System.out.println(serverDate != null);

		// 사용자의 입력을 가지고 왔더니
		// 입력하지 않은 데이터가 empty로 온다.
		String inputData = "";
		System.out.println(inputData.equals(""));
		System.out.println(inputData.isEmpty());

		System.out.println("\n===========삼항연산자=============\n");
		String inputId = "가나다라마바사";
		// intput id의 길이가 7이상이면 통과, 아니면 재입력
		String check = (inputId.length() >= 7) ? ("통과") : ("재입력");
		System.out.println(check);

		// inputID의 empty가 아니라면 1, 맞다면 0
		int intCheck = (inputId.length() > 0) ? (1) : (0);
		System.out.println(intCheck);

		// 이중 삼항 연산자
		int score = 76;

		// score가 90점보다 크면 grade는 A
		// Score가 80점보다 크면 grade는 B
		// 나머지는 C

		String grade = (score > 90) ? ("A") : ((score > 80) ? "B" : "C");
		System.out.println(grade);

		System.out.println("\n===============논리연산자===================\n");

		// 조건 체크를 여러번 하지 않고,
		// 한번에 끝낼 수 있도록 도와줌

		int inputAge = 24;
		String inputPhone = "01012345678";

		// 나이는 14세 이상, 휴대폰 번호는 11자리 체크
		System.out.println(inputAge >= 14);
		System.out.println(inputPhone.length() == 11);

		// &&(and 연산자)
		// 좌우 조건이 전부 참이어야만 true 리턴
		// 좌우 둘 중 하나라도 false라면 false 리턴
		System.out.println("and 연산자 :" + (inputAge >= 14 && inputPhone.length() == 11));

		// 휴대폰 번호는 10자리 혹은 11자리여야 한다.
		// 10 <= x <= 11
		System.out.println(10 <= inputPhone.length() && inputPhone.length() <= 11);

		// || (or 조건)
		// 좌우 조건 중 하나라도 true면 true리턴, 둘 다 아니면 false 리턴
		// 11보다 큰 경우는 false 임에도 앞조건이 트루라 트루 반환
		System.out.println(10 <= inputPhone.length() || inputPhone.length() > 11);

		// name은 empty면 안되고 phone은 10~11자리, age는 14이상
		String name = "차무식";
		String phone = "01012345678";
		int age = 50;
		boolean checkName = name.length() > 0;
		boolean checkPhone = phone.length() == 10 || phone.length() == 11;
		boolean checkAge = (age >= 14);

		System.out.println("체크 이름, 폰, 나이: \n" + name.isEmpty() + "\n" + checkPhone + "\n" + checkAge + "\n");
		
		//boolean 타입 앞에 !를 붙이면 true/false가 바뀐다.
		checkName = !name.isEmpty();
		System.out.println(checkName);
		
		System.out.println("\n============ 비트 연산자 ==============\n");
		// & 비트연산자 and, 이진수 기준으로 각 자리수를 비교해서
		// 같은 자리의 숫자가 둘 다 1이어야 1로 계산한다.
		int bitTen = 10;//1010
		int bitNine = 9;
		
		System.out.println(bitTen & bitNine); //1000
		
		// | 비트연산자 or
		// 하나의 자리라도 1이 있으면 1로 계산
		System.out.println(bitTen | bitNine); //1011
		
		// ^ XOR
		// 이진수 기준으로 각 자리가 서로 다를 때만 1로 계산
		System.out.println(bitTen ^ bitNine); //0011
		
		// 2진수 사용 예시
		// 4가지 취미를 보관하기 위해 숫자로 저장
		// 0 0 0 1 : 농구를 좋아함
		// 0 0 1 0 : 배구를 좋아함
		// 0 1 0 0 : 야구를 좋아함
		// 1 0 0 0 : 축구를 좋아함
		// 1 1 0 1 : 배구빼고 다 좋아함
		int jongLike = 13;
		
		System.out.println("\n===============================\n");
		
	}
}
