package minki.submit12;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class DateBoardMain {

	public static void main(String[] args) throws ParseException {
		// dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
		int size = 0;
		Date[] mydate;
		ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		for (int i = 0; i < 100; i++) {
			int randDay = (int) (Math.random() * 365) + 1; // 1~365
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, randDay * -1);

			String strDate = sdf.format(cal.getTime());
			dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
		}
		size = dbList.size();
		mydate = new Date[size];

		int i = 0;
		// TODO 코드작성 시작 ~!!
		for (DateBoard db : dbList) {
			mydate[i] = sdf.parse(dbList.get(i).getDate());
			i++;
		}
		i=0;
		for (DateBoard db : dbList) {
			System.out.println(mydate[i].getTime());
			if(mydate[i].getTime() - mydate[i+1].getTime()>0)
			{
				Collections.swap(dbList, i, i+1);
				System.out.println(dbList.get(i));
			}
			if(i+1<50) {
				i++;
			}
		}
		i=0;
		for (DateBoard db : dbList) {
			System.out.println(dbList.get(i));
			i++;
		}
		
		

	}

}