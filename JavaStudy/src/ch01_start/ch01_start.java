package ch01_start;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ch01_start {
//넘어가는지 git에서 확인
	public static void main(String[] args) throws ParseException {
		// 자동완성 단축키 [ Ctrl + Space ]
		// 코드라인 복사 [ Ctrl + Alt + 방향키 아래 ]
		// 코드라인 삭제 [ Ctrl + D ]
		// 실행 취소 [ Ctrl + Z / Ctrl + Y ]
		// 문장 주석처리 [ Ctrl + / ] 해당 문장 아무데나 갖다놓고 한 번 누르면 주석 / 두 번 누르면 해제
		// 테스트주석==============================================
		System.out.println("Hello World");
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm");
		System.out.println(sdf.format(date));
		String dates = sdf.format(date); 
	}
}
