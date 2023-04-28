package minki.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import ch14_jdbc_jsp.context.ConnectionPool;
import minki.submit13.dao.BoardDAO;
import minki.submit13.vo.BoardVO;

public class BoardService {
	private BoardService() {
	}

	private static BoardService instance = new BoardService();

	public static BoardService getInstance() {
		return instance;
	}

	private BoardDAO dao = BoardDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	// 게시글 작성 메소드
	public void writeBoard(BoardVO vo) {
		Connection conn = cp.getConnection();

		try {
			dao.writeDAO(conn, vo);
			System.out.println("글이 작성되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}

	// 게시글 수 반환 메소드
	public ArrayList<BoardVO> getNo() {
		Connection conn = cp.getConnection();
		ArrayList<BoardVO> result = new ArrayList<>();

		try {
			result = dao.getCustList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}

		return result;
	}

	// 게시글 조회 메소드
	public BoardVO getBoardList() {
		Connection conn = cp.getConnection();
		BoardVO result = new BoardVO();
		System.out.println("글 번호를 입력해 주세요:");
		Scanner scan = new Scanner(System.in);
		try {
			result = dao.getBoardList(conn, Integer.parseInt(scan.nextLine()));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("존재하지 않는 게시글 번호입니다.");
		}finally {

			cp.releaseConnection(conn);
		}

		return result;
	}

	// 게시글 전체 조회 메소드
	public ArrayList<BoardVO> getAllBoardList() {
		Connection conn = cp.getConnection();
		ArrayList<BoardVO> result = new ArrayList<>();
		try {
			result = dao.getAllList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}

		return result;
	}
}
