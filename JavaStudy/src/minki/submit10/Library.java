package minki.submit10;

import java.util.ArrayList;

public class Library {
	ArrayList<Book> bookList = new ArrayList<>();

	private Library() {
	}

	private static Library instance = new Library();

	public static Library getInstance() {
		return instance;
	}

	public void addBooks(Book book) {
		bookList.add(book);
	}

	public void selectBooks(int no) {
		if (no < bookList.size()) {
			for (Book bk : bookList) {
				if (bookList.get(no).isBorrow() == true) {
					System.out.println("대여중인 책입니다.");
					break;
				} else if (bookList.get(no).getNo() == bk.getNo()) {
					bookList.get(no).setBorrow(true);
					System.out.println(bookList.get(no).getTitle() + "을(를) 대여하셨습니다.");
					break;
				}
			}
		} else {
			System.out.println("존재하지 않는 번호입니다.");
		}
	}

	public void showBooks() {
		for (Book bk : bookList) {
			if (bk.isBorrow() == true) {
				System.out.println("책 번호 : " + bk.getNo() + ", 책 제목 : " + bk.getTitle() + ", 대여 상태 : 대여중");
			} else {
				System.out.println("책 번호 : " + bk.getNo() + ", 책 제목 : " + bk.getTitle() + ", 대여 상태 : 입고중");
			}
		}
	}

	public void searchBooks(String name) {
		for (Book bk : bookList) {
			if (bk.getTitle().contains(name) == true) {
				if (bk.isBorrow() == true) {
					System.out.println("책 번호 : " + bk.getNo() + ", 책 제목 : " + bk.getTitle() + ", 대여 상태 : 대여중");
				} else {
					System.out.println("책 번호 : " + bk.getNo() + ", 책 제목 : " + bk.getTitle() + ", 대여 상태 : 입고중");
				}
			}
		}
	}
}
