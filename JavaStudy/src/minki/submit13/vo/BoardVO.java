package minki.submit13.vo;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class BoardVO {
	private int no;
	private String title;
	private String text;
	private String user;
	private Date date = new Date();
	private String dates;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm");

	public BoardVO() {
	}

	public BoardVO(int no) {
		this.no = no;
	}

	public BoardVO(int no, String title, String text, String user) {
		this.no = no;
		this.title = title;
		this.text = text;
		this.user = user;
		this.dates = sdf.format(date);
	}

	public BoardVO(int no, String title, String user, String date, String text) {
		this.no = no;
		this.title = title;
		this.user = user;
		this.dates = date;
	}

	@Override
	public String toString() {
		return no + ". | " + title + " | " + user + " | " + dates;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}
}
