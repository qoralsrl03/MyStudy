package minki.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.vo.StudentVO;
import minki.submit13.vo.BoardVO;
import minki.submit13.vo.BoardVO;
import minki.submit13.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// 글쓰기 메소드
	public int writeDAO(Connection conn, BoardVO vo) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("Insert into board(		");
		query.append("	no					  	");
		query.append("	,title				  	");
		query.append("	,text				  	");
		query.append("	,name				  	");
		query.append("	,date_for )			");
		query.append("values(					");
		query.append("	 ?						");
		query.append("	 ,?						");
		query.append("	 ,?						");
		query.append("	 ,?						");
		query.append("	 ,?	)					");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		// 위 에서부터 ?를 채워나가며
		// 위에서부터 ? 인덱스는 1부터 증가한다.
		int idx = 1;
		ps.setInt(idx++, vo.getNo());
		ps.setString(idx++, vo.getTitle());
		ps.setString(idx++, vo.getText());
		ps.setString(idx++, vo.getUser());
		ps.setString(idx++, vo.getDates());

		int cnt = ps.executeUpdate();
		ps.close();

		return cnt;
	}

	// 현재 게시판의 작성된 게시글 수 리턴 메소드
	public ArrayList<BoardVO> getCustList(Connection conn) throws SQLException {
		// 3. 쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("	count(*)			");
		query.append("FROM					");
		query.append("	  board			"); // 세미콜론이 없음에 주의
		// 4. 쿼리문을 보유하고 실행 할 수 있는 객체 생성
		PreparedStatement ps = conn.prepareStatement(query.toString());
		// 5. 쿼리문 실행
		// select문의 경우 executeQuery()
		// 실행결과를 resultset에 담는다
		ResultSet rs = ps.executeQuery();

		// 6. ResultSet에 담긴 데이터에 대해
		// 객체를 만들어서 리스트에 담아 리턴
		ArrayList<BoardVO> result = new ArrayList<>();

		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			int no = rs.getInt("count(*)");
			BoardVO vo = new BoardVO(no);
			result.add(vo);
		}

		ps.close();
		rs.close();

		return result;
	}

	// 게시글 특정 번호 내용 반환 쿼리
	public BoardVO getBoardList(Connection conn, int i) throws SQLException {
		// 3. 쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("	title				");
		query.append("	,name				");
		query.append("	,date_for			");
		query.append("	,text				");
		query.append("FROM					");
		query.append("	  board			");
		query.append("Where	1=1				");
		query.append("And 	no=?			");
		// 4. 쿼리문을 보유하고 실행 할 수 있는 객체 생성
		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps.setInt(idx++, i);
		// 5. 쿼리문 실행
		// select문의 경우 executeQuery()
		// 실행결과를 resultset에 담는다
		ResultSet rs = ps.executeQuery();

		// 6. ResultSet에 담긴 데이터에 대해
		// 객체를 만들어서 리스트에 담아 리턴
		BoardVO result = new BoardVO();

		while (rs.next()) {
			result.setTitle(rs.getString("TITLE"));
			result.setUser(rs.getString("name"));
			result.setDates(rs.getString("date_for"));
			result.setText(rs.getString("text"));
		}

		ps.close();
		rs.close();

		return result;
	}

	// 게시글 전체 내용 반환 쿼리
	public ArrayList<BoardVO> getAllList(Connection conn) throws SQLException {
		
		StringBuffer query = new StringBuffer();
		query.append("SELECT				");
		query.append("	no					");
		query.append("	,title				");
		query.append("	,name				");
		query.append("	,date_for			");
		query.append("FROM					");
		query.append("	  board			");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		// 5. 쿼리문 실행
		// select문의 경우 executeQuery()
		// 실행결과를 resultset에 담는다
		ResultSet rs = ps.executeQuery();

		// rs에 데이터가 1개 담겨있으면 while문 한번만 실행된다.
		ArrayList<BoardVO> result = new ArrayList<>();
		while (rs.next()) {
			int no = Integer.parseInt(rs.getString("no"));
			String title = rs.getString("TITLE");
			String user = rs.getString("name");
			String dates = rs.getString("date_for");
			BoardVO vo = new BoardVO(no, title, user, dates,"");
			result.add(vo);
		}
		rs.close();
		ps.close();
		return result;
	}
}
