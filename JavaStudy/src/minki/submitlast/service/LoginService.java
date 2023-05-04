package minki.submitlast.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import minki.submitlast.context.ConnectionPool;
import minki.submitlast.dao.LoginDao;
import minki.submitlast.vo.LoginVO;

public class LoginService {
	Scanner scan = new Scanner(System.in);

	private static LoginService instance = new LoginService();

	public static LoginService getInstance() {
		return instance;
	}

	private LoginDao dao = LoginDao.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	public void insertal() throws SQLException {
		Connection conn = cp.getConnection();

		System.out.print("ID : ");
		String id = scan.nextLine();
		if (dao.scanId(conn, id) == -1) {
			System.out.println("\n=======================\n");
			System.out.println("중복된 아이디입니다.");
			System.out.println("\n=======================\n");

			insertal();
			return;
		} else {
			System.out.println("사용 가능한 아이디입니다.");
			System.out.print("PW : ");
			String pw = scan.nextLine();
			System.out.print("이름 : ");
			String name = scan.nextLine();
			LoginVO vo = new LoginVO(id, pw, name);
			dao.RegisterLogin(conn, vo);
			cp.releaseConnection(conn);
		}
	}

	public LoginVO selectal() throws SQLException {
		Connection conn = cp.getConnection();
		LoginVO vo = null;
		outer : while (true) {
			System.out.print("Login ID : ");
			String id = scan.nextLine();
			System.out.print("Login PW : ");
			String pw = scan.nextLine();
			vo = new LoginVO(id, pw);
			vo = dao.selectLogin(conn, vo);
			cp.releaseConnection(conn);
			if (vo.getCustId() == null) {
				System.out.println("잘못된 아이디 또는 비밀번호 입니다.");
				System.out.println("다시 입력해 주세요");
				continue outer;
			}else {
				break;
			}
		}
		return vo;
	}
}
