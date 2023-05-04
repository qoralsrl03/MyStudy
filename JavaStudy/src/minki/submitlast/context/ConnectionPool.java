package minki.submitlast.context;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

// ConnectionFactory로부터 maxConn 개수만큼
// Connection 객체를 생성해서 보관하고,
// 쿼리문 실행시 보관중인 Connection 객체를 
// 빌려주고, 끝나면 반납받는 클래스

public class ConnectionPool {
	// @autowired
	// ConncetionFactory cf 라고 하면 더 편하지만 일단 불편함을 감수하며 배우자..

	ConnectionFactory cf = ConnectionFactory.getInstance();
//	ArrayList<Connection> pool = new ArrayList<>();
	// 현재 4개의 커넥션 객체가 생성되어있음
	// 4개가 모두 연결중일 때는 다른 연결을 대기시켜야 하기 때문에 동기화가 필요함
	// 그래서 ArrayList와 사용법은 똑같은데 StringBuffer와 같이 동기화를 제공하는것이 > Vector <
	// ArrayList는 StringBuilder하고 비슷함
	// Vector는 동기화가 적용된 ArrayList<>()와 같다
	private Vector<Connection> pool = new Vector<>();

	private ConnectionPool() {
		// maxConn 만큼 Connection 객체를 pool에 담기(현재 maxConn= 4)
		for (int i = 0; i < cf.getMaxConn(); i++) {
			Connection conn = cf.getConnection(); // 커넥션 객체를 리턴
			pool.add(conn);
		}
		System.out.println("pool의 사이즈: " + pool.size());
		System.out.println("Connection 객체를 잘 보관하였습니다.");
		System.out.println("\n================================\n");
	}

	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		return instance;
	}

	// pool에 있는 Connection 객체 빌려주기
	// 동기화해서 pool의 상황을 알려줌
	public synchronized Connection getConnection() {
		if (pool.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Connection conn = pool.get(0);
		pool.remove(0);
		return conn;
	}

	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notify();
	}
}
