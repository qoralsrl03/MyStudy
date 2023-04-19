package minki.submit10;

public class Book {
	private int no;
	private String title;
	private boolean borrow;

	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", borrow=" + borrow + "]";
	}

	public Book() {
	}
	
	public Book(int no, String title) {
		super();
		this.no = no;
		this.title = title;
		this.borrow = false;
	}

	public Book(int no, String title, boolean borrow) {
		super();
		this.no = no;
		this.title = title;
		this.borrow = borrow;
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

	public boolean isBorrow() {
		return borrow;
	}

	public void setBorrow(boolean borrow) {
		this.borrow = borrow;
	}

}
