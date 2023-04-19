package ch09_class.hompage;

import java.util.ArrayList;

public class BoardDB {
	private ArrayList<Board> boardList = new ArrayList<>();

	// 싱글톤 적용
	// 프로젝트 내에서 이 클래스로부터 객체를 딱 하나만
	// 생성할 목적으로 사용
	private BoardDB() {
		boardList.add(new Board(1, "공지사항 필독!", "욕설 금지", "admin"));
	};

	// 인스턴스로만 객체 입력을 받고,
	// 다른 클래스에서 이름 그대로 사용하기 위해 static으로 선언하며
	// 당연히 얘도 외부에서 값 변조를 막기 위해 private으로 선언한다.
	private static BoardDB instance = new BoardDB();

	public static BoardDB getInstance() {
		return instance;
	}

	// 게시글 목록 출력
	public void showBoardList() {
		for (Board al : boardList) {
			System.out.println(al);
		}
	}

	public void addBoard(Board board) {
		// board 객체 내부 no가 0이 들어있음
		// board 객체 내부 no를 boardList.size() + 1 로 변경
		board.setNo(boardList.size() + 1);
		boardList.add(board);
	}

	public void selectBoard(int no) {
		// boardList에 존재하는 board 객체 중에
		// 파라미터로 들어온 no와 같은 no를 가지는 board객체 찾기
		
		for (int i = 0; i < boardList.size(); i++) {
			Board bo = boardList.get(i);
			if (bo.getNo() == no) {
				System.out.println("제목: " + bo.getTitle());
				System.out.println("작성자: " + bo.getAuthor());
				System.out.println("============================================");
				System.out.println(bo.getContent());
				return ;
			}
		}
		System.out.println("존재하지 않는 글번호 입니다.");
	}
}