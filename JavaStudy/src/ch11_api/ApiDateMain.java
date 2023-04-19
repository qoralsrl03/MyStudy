package ch11_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ApiDateMain {

	public static void main(String[] args) throws ParseException {
		// 현재 시간 출력
		// 1. Date 클래스 사용
		Date dateToday = new Date();

		// Date 객체가 new Date()로 생성되는 순간
		// 해당 Date 객체 내부에 그 때의 시간이 세팅된다.
		System.out.println(dateToday);

		// 날짜 포맷 설정
		// 2023년 04월 4월 18일 10시 39분 30초
		// SimpleDateFormat 생성자 안에 날짜 포맷 문자열 넣기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 MM분 SS초");
		// .format의 파라미터에 Date 객체를 넣으면
		// 해당 Date 객체의 날짜에 대해 포맷을 적용한 문자열을 리턴
		sdf.format(dateToday);
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * Date dateAfter = new Date(); System.out.println(dateAfter);
		 */
		String strToday = sdf.format(dateToday);
		System.out.println(strToday);

		// 2023/04/18 10:39:40
		sdf = new SimpleDateFormat("yyyy/MM HH:mm:ss");
		strToday = sdf.format(dateToday);
		System.out.println(strToday);

		System.out.println("\n==================================\n");

		// 2. Calendar 클래스 사용
		// .getInstance() 이지만 싱글톤 패턴이 적용되지 않음
		// new Date()와 마찬가지로 .getInstance()가 실행된
		// 시점으로 세팅된 Calendar 객체가 생성된다.
		Calendar calToday = Calendar.getInstance();
		System.out.println(calToday);

		// calendar 객체의 .getTime()을 실행하면
		// 해당 calendar 객체에 세팅된 날짜를 가지는
		// Date 객체를 리턴
		Date calToDate = calToday.getTime();
		System.out.println(calToDate);

		// 날짜 포맷 적용
		strToday = sdf.format(calToDate);
		System.out.println(strToday);

		System.out.println("\n=================================\n");

		// 3. System 클래스 사용
		long longToday = System.currentTimeMillis();
		System.out.println(longToday);

		// 날짜 포맷 적용
		// sdf.format()은 파라미터로 Date 객체 또는 long 타입을 받는다.
		strToday = sdf.format(longToday);
		System.out.println(strToday);

		// 0일 경우에는 처음 세팅된 시간이 나옴
		strToday = sdf.format(0L);
		System.out.println(strToday);

		System.out.println("\n===============================\n");

		// 다양한 날짜 포맷 만들기
		// 1. 23/04/18 11:16:33
		// 2. 2023-04-18 오전 11:16:33
		// 3. 화 오전 11:16:33
		// 4. 화요일 11:16
		// @. 2023.04.18 AM 11:16:33

		Date dateNow = new Date();
		sdf = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		System.out.println("1. " + sdf.format(dateNow));

		sdf = new SimpleDateFormat("yyyy-M-dd a hh:mm:ss");
		System.out.println("2. " + sdf.format(dateNow));

		sdf = new SimpleDateFormat("E a hh:mm:ss");
		System.out.println("3. " + sdf.format(dateNow));

		sdf = new SimpleDateFormat("E요일 hh:mm");
		System.out.println("4. " + sdf.format(dateNow));

		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss", Locale.US);
		System.out.println("@. " + sdf.format(dateNow));

		// 미국날짜는?
		TimeZone US = TimeZone.getTimeZone("America/New_York");
		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss", Locale.US);
		sdf.setTimeZone(US);
		System.out.println("@@. " + sdf.format(dateNow));

		// 문자열(String) -> Date 객체 변환
		// 유사) "12314" -> int 타입으로 변환
		// 예시) 2023/04/18, 2023/05/16 두 날짜 차이 계산
		String strTomorrow = "2023/04/19 12:01:10";

		// strTomorrow 문자열의 날짜 포맷에 대한 sdf 생성
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Date dateTomorrow = sdf.parse(strTomorrow);
		System.out.println(dateTomorrow);
		System.out.println(sdf.format(dateTomorrow));

		String strYesterDay = "23.04.17 09:12:11";
		sdf = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
		Date DateYesterDay = sdf.parse(strYesterDay);
		System.out.println(DateYesterDay);

		System.out.println("\n====================\n");

		// 특정 날짜(23/05/01)에 대한 객체 얻기
		// Date를 얻는다면 "23/05/01" -> sdf.parse 이용

		// Calendar로 얻기
		Calendar cal = Calendar.getInstance();

		// .set(년, 월, 일) 또는
		// .set(년, 월, 일, 시, 분, 초)
		// Month의 경우 1월이 숫자 0, 2월이 1...12월은 11
		cal.set(2023, 4, 1);

		// Calendar 객체를 Date 객체로 변환
		System.out.println(cal.getTime());

		// Date 객체를 Calendar 객체로 변환
		Date temp = new Date();
		Calendar calTemp = Calendar.getInstance();
		calTemp.setTime(temp);

		// Date 타입에서 long 날짜 얻기
		System.out.println(temp.getTime());

		System.out.println("\n=======================\n");

		// 날짜 꺼내기
		// Calendar 객체가 편하다.
		Calendar anyCal = Calendar.getInstance();

		// 년도
		System.out.println(anyCal.get(Calendar.YEAR));

		// 월
		System.out.println(anyCal.get(Calendar.MONTH));

		// 일
		System.out.println(anyCal.get(Calendar.DATE));

		// 시
		System.out.println(Calendar.HOUR);
		System.out.println(Calendar.HOUR_OF_DAY);

		// 분
		System.out.println(Calendar.MINUTE);

		// 초
		System.out.println(Calendar.SECOND);

		// 날짜 연산
		String oneDay = "2023.04.06 12:22:44";
		String twoday = "2023.06.22 14:31:13";

		// Date 타입으로 바꿔주기
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Date oneDate = sdf.parse(oneDay);
		Date twoDate = sdf.parse(twoday);

		System.out.println(oneDate.getTime());
		System.out.println(twoDate.getTime());

		// 밀리초 값이 더 클수록 최신/미래를 의미
		long diffMillSec = twoDate.getTime() - oneDate.getTime();
		System.out.println(diffMillSec + "밀리초 차이");

		// diffMillSec을 초 단위로 바꾸기
		long diffSec = diffMillSec / 1000;
		System.out.println(diffSec + "초 차이");

		long diffMin = diffSec / 60;
		System.out.println(diffMin + "분 차이");

		long diffHour = diffMin / 60;
		System.out.println(diffHour + "시 차이");

		long diffDay = diffHour / 24;
		System.out.println(diffDay + "일 차이");

		// 일 차이를 구하는 과정을 한줄로 정리
		long diff = diffMillSec / (1000 * 60 * 60 * 24);
		System.out.println(diff + "일 차이");
		sdf = new SimpleDateFormat("dd");

		System.out.println("\n======================\n");

		// 디데이 계산기를 만들어서
		String dday = "2023.05.01";

		// 실행 결과
		// 근로자의 날까지 d-day = -13
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date ddate = sdf.parse(dday);
		String today = sdf.format(dateToday);
		Date parseDate = sdf.parse(today);
		long diffDate = parseDate.getTime() - ddate.getTime();
		long comeDay = diffDate / (1000 * 60 * 60 * 24);
		System.out.println(comeDay);

		// 실행결과 ~ 교육 기간 = +29
		dday = "2023.03.23";
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		ddate = sdf.parse(dday);
		diffDate = parseDate.getTime() - ddate.getTime();
		comeDay = diffDate / (1000 * 60 * 60 * 24);
		System.out.println(comeDay);

		System.out.println("\n=================================\n");
		// 날짜연산
		// 한 날짜를 기준으로 날짜를 더하거나 빼기
		// Calendar 가 편함.

		Calendar toCal = Calendar.getInstance();
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		System.out.println(sdf.format(toCal.getTime()));

		// 3일 뒤
		toCal.add(Calendar.DATE, 3);
		System.out.println(sdf.format(toCal.getTime()));
		// 57일 뒤
		toCal.add(Calendar.DATE, 57);
		System.out.println(sdf.format(toCal.getTime()));
		// 7일 전
		toCal.add(Calendar.DATE, -7);
		System.out.println(sdf.format(toCal.getTime()));

		// 11달 뒤
		toCal.add(Calendar.MONTH, 11);
		System.out.println(sdf.format(toCal.getTime()));

		// 달력만들기
		int year = 2023;
		int month = 5;

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1); // month는 배열과같이 0부터 인식하여 6월을 얻으려면 값 5번째를 얻어와야함
		System.out.println(sdf.format(calendar.getTime()));

		// 해당 달의 마지막 일자 얻기
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastDay);

		// 해당 달의 시작 요일
		// 1: 일요일, 2: 월요일 ... 7: 토요일을 의미
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(startDay);

		System.out.println(year + "년" + month + "월 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int current = 1;
		for (int i = 0; i < 42; i++) {
			if (i < startDay - 1) {
				System.out.print("\t");
			} else {
				System.out.printf("%02d\t",current);
				current++;
				if (lastDay < current) {
					break;
				}
			}
			// i가 6,13,20,27,34 일 때 출력 후 줄바꿈
			if (i % 7 == 6) {
				System.out.println();
			}

		}
	}

}
