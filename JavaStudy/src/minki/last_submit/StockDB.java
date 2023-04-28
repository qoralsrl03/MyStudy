package minki.last_submit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Connection 객체를 만들어주는 클래스
// 프로젝트 내에서 1개만 존재하면 됨, 싱글톤 적용하자
// conn = DriverManager.getConnection(url, id, pw); 을 메소드화 하는것
public class StockDB {

	private String driver;
	private String url;
	private String id;
	private String pw;
	int maxConn;

	private static StockDB instance = new StockDB();

	private StockDB() {
		// .properties 파일 불러와서 내부 데이터 읽은다음 변수에 저장
		InputStream reader = getClass().getClassLoader().getResourceAsStream("config/db.properties");

		Properties prop = new Properties();
		try {
			prop.load(reader);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			id = prop.getProperty("id");
			pw = prop.getProperty("pw");
			maxConn = Integer.parseInt(prop.getProperty("maxConn")); // String에서 int로 형변환 할 수 없어서 오류가 나기때문에 parse 과정이 필요

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 1. 드라이버 로딩
		// (프로젝트 내에서 단 한번만 실행이 되면 됨)
		try {
			Class.forName(driver);
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 등록 실패");
			System.exit(0); // 현재 프로그램 종료
		}
	}

	public static StockDB getInstance() {
		return instance;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ConnectionFactory에서 Connection 객체를 생성하는데 에러가 발생했습니다.");
			System.out.println("getConnection() 메소드에 작성하신 URL, ID, PW가 올바른지 확인해주세요.");
		}
		return conn;
	}

	public int getMaxConn() {
		return maxConn;
	}
}