package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P17 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.
		ResultSet k20_rset = k20_stmt.executeQuery("show tables;");
		// resultset은 executequery를 통해 쿼리를 실행하면 resultset타입으로 반환해주어 결과값 저장
		while (k20_rset.next()) { // rset이 끝날때 까지 1줄씩 바꿈
			System.out.println("값 : " + k20_rset.getString(1));
			// 결과물 처리
		}
		k20_rset.close(); // rset종료
		k20_stmt.close(); // stmt종료
		k20_conn.close(); // conn종료
	}
}
