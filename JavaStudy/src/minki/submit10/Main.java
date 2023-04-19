package minki.submit10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
		Library library = Library.getInstance();
		String[] arrBooks = new String[strBooks.length()];
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < arrBooks.length; i++) {
			arrBooks = strBooks.trim().split(",");
		}
		

		library.bookList.add(new Book(0,"테스트",false));
		
		for (int i = 0; i < arrBooks.length; i++) {
			Book book = new Book(library.bookList.size(), arrBooks[i]);
			System.out.println(library.bookList.get(i));
			System.out.println(library.bookList.size());
			library.addBooks(book);
		}
		
		first: while (true) {
			
			System.out.println("행동을 선택하세요");
			System.out.println("1.책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
			System.out.print(">>> ");
			int select = Integer.parseInt(scan.nextLine());
			
			if (select == 1) {
				// 책 입고
				while (true) {
					System.out.println("책 제목을 입력하세요: (이전화면은 -1)");
					System.out.print(">>> ");
					String booktitle = scan.nextLine();
					if (booktitle.equals("-1")) {
						break;
					}
					Book book = new Book(library.bookList.size() + 1, booktitle);
					library.addBooks(book);
					System.out.println("책이 입고되었습니다.");
				}
			} else if (select == 2) {
				// 책 대여
				System.out.println("대여할 도서 번호를 입력해 주세요(1~" + (library.bookList.size()-1)+")");
				System.out.print(">>> ");
				int borrow = Integer.parseInt(scan.nextLine());
				library.selectBooks(borrow);
			} else if (select == 3) {
				// 책 목록조회
				library.showBooks();
			} else if (select == 4) {
				// 책 검색
				System.out.println("책 이름을 입력해 주세요 : ");
				System.out.print(">>> ");
				String name = scan.nextLine();
				library.searchBooks(name);
				System.out.println("대여할 도서 번호를 입력해 주세요(1~" + (library.bookList.size()-1)+")");
				System.out.print(">>> ");
				int borrow = Integer.parseInt(scan.nextLine());
				library.selectBooks(borrow);
			} else {
				// 종료
				break;
			}
		}
	}
}
