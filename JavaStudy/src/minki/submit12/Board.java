package minki.submit12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private int no=0;
	private String title, context;
	private Date uploadDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String update = sdf.format(uploadDate);
	
	public Board() {}
	
	public Board(int no, String title, String context) {
		this.no = no;
		this.title = title;
		setUpdate(update);
		this.context = context;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", update=" + update + ", context=" + context + "]";
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

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	
	
	
}
