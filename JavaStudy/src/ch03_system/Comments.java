package ch03_system;

public class Comments {
	// 자바 문서 (javadoc) 주석 <- **두개 입력 하면 다음 문장의 설명이 됨
	/**
	 * 바나나는 노랗다 
	 */
	static String banana = "바나나";
	public static void main(String[] args) {
		// 주석(Comment)
		// 프로그래밍 언어마다 다른 주석을 사용하는 경우가 많다.
		// 파이썬은 #, Sql은 --, Html <!- ->
		
		//보통은 메소드 사용법에 대해 설명하는 용도
		
		//TODO 주석(개발 중간중간 향후 구현해야할 부분에 대해 미리 말로 작성해놓는 경우 사용)
		//TODO 바나나를 콘솔창에 출력할 예정
		//Window - Show View - Tasks에 TODO 주석들의 위치가 다 뜸
		System.out.println(banana);
	}

}
