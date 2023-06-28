package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P18 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.

		k20_stmt.execute("create table examtable(" + "name varchar(20)," + "studentid int not null primary key,"
				+ "kor		int," + "eng		int," + "mat		int)" + "DEFAULT CHARSET = utf8;");
		//resultset이 없으므로 execute 함수 사용
		//execute: 모든 유형의 SQL문장을 사용할수 있으며 수행결과로 Boolean 타입의 값을 반환
		k20_stmt.close(); //stmt종료
		k20_conn.close(); //conn 종료
	}
}
