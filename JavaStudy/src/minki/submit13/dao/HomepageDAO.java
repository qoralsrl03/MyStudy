package minki.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import minki.submit13.vo.HomepageVO;

public class HomepageDAO {
	private HomepageDAO() {
	}

	private static HomepageDAO instance = new HomepageDAO();

	public static HomepageDAO getInstance() {
		return instance;
	}

	// 회원 가입 메소드
	public int registCustomer(Connection conn, HomepageVO homepage) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("Insert into customer(		");
		query.append("	cust_id				  	");
		query.append("	,cust_pw )					");
		query.append("values(						");
		query.append("	 ?							");
		query.append("	,?	)						");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		// 위 에서부터 ?를 채워나가며
		// 위에서부터 ? 인덱스는 1부터 증가한다.
		int idx = 1;
		ps.setString(idx++, homepage.getCustId());
		ps.setString(idx++, homepage.getCustPw());

		int cnt = ps.executeUpdate();
		ps.close();

		return cnt;
	}
	
	// 학생 조회(SELECT)메소드
		public ArrayList<HomepageVO> getCustList(Connection conn) throws SQLException {
			// 3. 쿼리문 작성
			StringBuffer query = new StringBuffer();
			query.append("SELECT				");
			query.append("	cust_id			");
			query.append("	, cust_pw			");
			query.append("FROM					");
			query.append("	  customer		"); // 세미콜론이 없음에 주의
			// 4. 쿼리문을 보유하고 실행 할 수 있는 객체 생성
			PreparedStatement ps = conn.prepareStatement(query.toString());
			// 5. 쿼리문 실행
			// select문의 경우 executeQuery()
			// 실행결과를 resultset에 담는다
			ResultSet rs = ps.executeQuery();

			// 6. ResultSet에 담긴 데이터에 대해
			// 객체를 만들어서 리스트에 담아 리턴
			ArrayList<HomepageVO> result = new ArrayList<>();

			while (rs.next()) {
				// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
				String stuId = rs.getString("cust_id");
				String stuPw = rs.getString("cust_pw");

				HomepageVO vo = new HomepageVO(stuId, stuPw);
				result.add(vo);
			}

			ps.close();
			rs.close();

			return result;
		}
	
	
	
	// 회원 로그인 메소드
	public HomepageVO login(Connection conn, HomepageVO vo) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("	cust_id					");
		query.append("	, cust_pw					");
		query.append("FROM							");
		query.append("	  customer				");
		query.append("Where 1=1						");
		query.append("	  And cust_id = ?		");
		query.append("	  And cust_password = ?	");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, vo.getCustId());
		ps.setString(idx++, vo.getCustPw());
		// 5. 쿼리문 실행
		// select문의 경우 executeQuery()
		// 실행결과를 resultset에 담는다
		ResultSet rs = ps.executeQuery();

		// rs에 데이터가 1개 담겨있으면 while문 한번만 실행된다.
		HomepageVO result = new HomepageVO();
		while (rs.next()) {
			result.setCustId(rs.getString("cust_id"));
			result.setCustPw(rs.getString("cust_pw"));
		}
		rs.close();
		ps.close();
		return result;
	}
}
