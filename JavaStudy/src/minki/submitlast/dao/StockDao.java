package minki.submitlast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import minki.submitlast.vo.CurrentStockVO;

public class StockDao {
	
	// DB테이블에 주식값 삽입 메소드
	public int insertStock(Connection conn, CurrentStockVO vo) {
		StringBuffer query = new StringBuffer();
		query.append("	Insert Into StockDB(	  ");
		query.append("	 name						  ");
		query.append("	,clpr						  ");
		query.append("	,hipr						  ");
		query.append("	,lopr						  ");
		query.append("	)VALUES(					  ");
		query.append("	?							  ");
		query.append("	,?							  ");
		query.append("	,?							  ");
		query.append("	,?)							  ");

		try {
			PreparedStatement ps = conn.prepareStatement(query.toString());

			int idx = 1;

			ps.setString(idx++, vo.getStockname());
			ps.setDouble(idx++, vo.getClpr());
			ps.setDouble(idx++, vo.getHipr());
			ps.setDouble(idx++, vo.getLopr());
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

	// 주식 DB 조회 메소드
	public ArrayList<CurrentStockVO> selectStock(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		PreparedStatement ps = null;
		ArrayList<CurrentStockVO> result = new ArrayList<>();
		ResultSet rs = null;
		query.append("SELECT						");
		query.append("		name,					");
		query.append("		clpr,					");
		query.append("		hipr,					");
		query.append("		lopr					");
		query.append("FROM							");
		query.append("	  StockDB					");

		try {
			ps = conn.prepareStatement(query.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				double clpr = rs.getDouble("clpr");
				double hipr = rs.getDouble("hipr");
				double lopr = rs.getDouble("lopr");
				CurrentStockVO vo = new CurrentStockVO(name, clpr, hipr, lopr);
				result.add(vo);
			}
			return result;
		} catch (SQLException e) {
			System.err.println("Error message: " + e.getMessage());
			System.err.println("SQL state: " + e.getSQLState());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return null;
	}
}
