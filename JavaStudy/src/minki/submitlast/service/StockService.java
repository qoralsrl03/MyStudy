package minki.submitlast.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import minki.submitlast.context.ConnectionPool;
import minki.submitlast.dao.StockDao;
import minki.submitlast.vo.CurrentStockVO;

public class StockService {
	Scanner scan = new Scanner(System.in);

	private static StockService instance = new StockService();

	public static StockService getInstance() {
		return instance;
	}

	private ConnectionPool cp = ConnectionPool.getInstance();
	private StockDao dao = new StockDao();

	// 1회용, API로부터 받아온 주식값을 디비에 넘기는 용도
	public void insertStock(String name, double clpr, double hipr, double lopr) throws SQLException {
		Connection conn = cp.getConnection();
		dao.insertStock(conn, new CurrentStockVO(name, clpr, hipr, lopr));
	}

	// 주식 DB값을 통째로 불러오는 메소드
	public ArrayList<CurrentStockVO> stockBoard() {
		Connection conn = cp.getConnection();
		ArrayList<CurrentStockVO> result = new ArrayList<>();
		try {
			result = dao.selectStock(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				cp.releaseConnection(conn);
			}
		}
		return result;
	}

}
