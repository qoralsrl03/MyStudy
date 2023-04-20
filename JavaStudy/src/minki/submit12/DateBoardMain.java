package minki.submit12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class DateBoardMain {

	public static void main(String[] args) throws ParseException {
		// dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입

		ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		for (int i = 0; i < 100; i++) {
			int randDay = (int) (Math.random() * 365) + 1; // 1~365
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, randDay * -1);

			String strDate = sdf.format(cal.getTime());
			dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
		}
		System.out.println("\n================03================\n");

		// Q.3 날짜 오름차순 정렬
		Collections.sort(dbList, new Comparator<DateBoard>() {
			@Override
			public int compare(DateBoard o1, DateBoard o2) {
				Date d1 = null;
				Date d2 = null;
				try {
					d1 = sdf.parse(o1.getDate());
					d2 = sdf.parse(o2.getDate());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return d1.compareTo(d2);
			}
		});

		for (DateBoard db : dbList) {
			System.out.println(db.getTitle() + "," + db.getDate());

		}

		System.out.println("\n================04================\n");
		// Q.4 한달 내 게시글만 출력하기
		Calendar toCal = Calendar.getInstance();
		System.out.println(sdf.format(toCal.getTime()));
		toCal.add(Calendar.DATE, -30);
		String tC = sdf.format(toCal.getTime());
		Date d1 = sdf.parse(tC);
		for (DateBoard db : dbList) {
			Date d2 = sdf.parse(db.getDate());
			if (d2.getTime() - d1.getTime() > 0) {
				System.out.println(db.getTitle() + "," + db.getDate());
			}
		}

		System.out.println("\n================05=================\n");
		// Q.5 dbList에서 이번달에 작성된 게시글만 출력해주세요.
		SimpleDateFormat sd = new SimpleDateFormat("MM");
		SimpleDateFormat sy = new SimpleDateFormat("YY");
		toCal.add(Calendar.DATE, 30);
		int year = (toCal.get(Calendar.YEAR));
		int month = (toCal.get(Calendar.MONTH) + 1);
		for (DateBoard db : dbList) {
			Date dday = sdf.parse(db.getDate());
			if (Integer.parseInt(20+sy.format(dday)) == year) {
				if (Integer.parseInt(sd.format(dday)) == month) {
					System.out.println(db.getTitle() + " , " + db.getDate());
				}
			}
		}

		System.out.println("\n==============06===================\n");
		// Q.6 dbList에서 2월에 작성된 게시글만 출력해주세요.
		month = 2;
		int dbmonth = 0;
		for(DateBoard db : dbList) {
			dbmonth = Integer.parseInt(sd.format(sdf.parse(db.getDate())));
			if(dbmonth == month) {
				System.out.println(db.getTitle() + ", " + db.getDate());
			}
		}
		
		// Q.7 2023년 2월 14일부터 2023년 3월 21일까지 작성된 게시글만 출력해주세요
		String startday = "2023.02.14 00:00:00";
		String lastday = "2023.03.21 11:59:59";
		for(DateBoard db : dbList) {
			long l = sdf.parse(db.getDate()).getTime();
			long ls = sdf.parse(startday).getTime();
			long ll = sdf.parse(lastday).getTime();
			if(l<ll && l>ls) {
				System.out.println(db.getTitle() + ", "+db.getDate());
			}
			
		}
		
	}

}
