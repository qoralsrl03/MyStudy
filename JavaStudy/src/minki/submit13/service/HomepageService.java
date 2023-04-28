package minki.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import minki.submit13.dao.HomepageDAO;
import minki.submit13.vo.HomepageVO;

public class HomepageService {
	private HomepageService() {
	}

	private static HomepageService instance = new HomepageService();

	public static HomepageService getInstance() {
		return instance;
	}
	
	private HomepageDAO dao = HomepageDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	
	// 고객 회원 가입 메소드
	public void registCustomer(HomepageVO vo) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registCustomer(conn, vo);
			System.out.println("회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	
	// 회원목록 조회(SELECT) 메소드
		public ArrayList<HomepageVO> getCustList() {
			Connection conn = cp.getConnection();
			ArrayList<HomepageVO> result = new ArrayList<>();

			try {
				result = dao.getCustList(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				cp.releaseConnection(conn);
			}

			return result;
		}
}
