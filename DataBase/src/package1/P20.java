package package1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P20 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.		
		k20_stmt.execute("insert into examtable "
				+ "(name, studentid, kor, eng, mat) values ('효민',209901, 95, 100, 95);");
		k20_stmt.execute("insert into examtable "
				+ "(name, studentid, kor, eng, mat) values ('보람',209902, 95, 95, 95);");
		k20_stmt.execute("insert into examtable "
				+ "(name, studentid, kor, eng, mat) values ('은정',209903, 100, 100, 100);");
		k20_stmt.execute("insert into examtable "
				+ "(name, studentid, kor, eng, mat) values ('지연',209904, 100, 95, 90);");
		k20_stmt.execute("insert into examtable "
				+ "(name, studentid, kor, eng, mat) values ('소연',209905, 80, 100, 70);");
		k20_stmt.execute("insert into examtable "
				+ "(name, studentid, kor, eng, mat) values ('큐리',209906, 100, 100, 70);");
		k20_stmt.execute("insert into examtable "
				+ "(name, studentid, kor, eng, mat) values ('화영',209907, 70, 70, 70);");
		//resultset이 없으므로 execute 함수 사용
		//execute: 모든 유형의 SQL문장을 사용할수 있으며 수행결과로 Boolean 타입의 값을 반환
		//insert는 테이블에 값을 넣음
		
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //cinn 종료
	}
}
