package minki.submit12;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardDB extends Board {
	ArrayList<Board> boarddb = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	String[] block = new String[2];

	private BoardDB() {
	}

	private static BoardDB instance = new BoardDB();

	public static BoardDB getInstance() {
		return instance;
	}

	public void showBoard() {
		for (int i = 0; i < boarddb.size(); i++) {
			System.out.println(
					boarddb.get(i).getNo() + " | " + boarddb.get(i).getTitle() + " | " + boarddb.get(i).getUpdate());
		}
	}

	public void writeBoard() {
		System.out.println("글 제목을 입력해 주세요:");
		block[0] = scan.nextLine();
		System.out.println("글 내용을 입력해 주세요:");
		block[1] = scan.nextLine();

		boarddb.add(new Board(boarddb.size() + 1, block[0], block[1]));

	}
}
