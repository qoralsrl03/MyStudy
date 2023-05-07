package minki.submitlast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import minki.submitlast.vo.LoginVO;

public class LoginDao {

	private static LoginDao instance = new LoginDao();

	public static LoginDao getInstance() {
		return instance;
	}

	// 회원가입 메소드
	public int RegisterLogin(Connection conn, LoginVO vo) {
		StringBuffer query = new StringBuffer();
		query.append("	Insert Into CustDB(	  ");
		query.append("	 ID							  ");
		query.append("	,PW							  ");
		query.append("	,Name						  ");
		query.append("	)VALUES(					  ");
		query.append("	?							  ");
		query.append("	,?							  ");
		query.append("	,?)							  ");

		try {
			PreparedStatement ps = conn.prepareStatement(query.toString());

			int idx = 1;

			ps.setString(idx++, vo.getCustId());
			ps.setString(idx++, vo.getCustPw());
			ps.setString(idx++, vo.getCustName());
			int count = ps.executeUpdate();
			System.out.println(count + "줄이 삽입되었습니다.");
			ps.close();
			return count;

		} catch (SQLException e) {
			System.err.println("Error message: " + e.getMessage());
			System.err.println("SQL state: " + e.getSQLState());
		}

		return 0;

	}
	
	// 아이디 중복 조회 메소드
	public int scanId(Connection conn, String id) throws SQLException {
		StringBuffer query = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		query.append("SELECT						");
		query.append("		id						");
		query.append("FROM							");
		query.append("	  CustDB				");
		query.append("Where 1=1						");
		query.append("	  And id = ?				");

		try {
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				if (id.equalsIgnoreCase(rs.getString("id"))) {
					return -1;
				}
			}
			return 1;

		} catch (SQLException e) {
			System.err.println("Error message: " + e.getMessage());
			System.err.println("SQL state: " + e.getSQLState());
		} finally {
			rs.close();
			ps.close();
		}

		return -1;
	}
	
	// 로그인 정확한지 DB에서 조회하는 메소드
	public LoginVO selectLogin(Connection conn, LoginVO vo) throws SQLException {
		StringBuffer query = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		query.append("SELECT						");
		query.append("		id						");
		query.append("	   ,pw						");
		query.append("	   ,name					");
		query.append("FROM							");
		query.append("	  CustDB				");
		query.append("Where 1=1						");
		query.append("	  And id = ?				");
		query.append("	  And pw = ?				");

		try {
			ps = conn.prepareStatement(query.toString());
			int idx = 1;
			ps.setString(idx++, vo.getCustId());
			ps.setString(idx++, vo.getCustPw());

			rs = ps.executeQuery();
			LoginVO login = new LoginVO();
			while (rs.next()) {
				login.setCustId(rs.getString("id"));
				login.setCustPw(rs.getString("pw"));
				login.setCustName(rs.getString("name"));
			}

			return login;

		} catch (SQLException e) {
			System.err.println("Error message: " + e.getMessage());
			System.err.println("SQL state: " + e.getSQLState());
		} finally {
			rs.close();
			ps.close();
		}

		return null;
	}
	
	

}
