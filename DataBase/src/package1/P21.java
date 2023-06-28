package package1;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P21 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.
		ResultSet k20_rset = k20_stmt.executeQuery("select *from examtable;");
		// resultset은 executequery를 통해 쿼리를 실행하면 resultset타입으로 반환해주어 결과값 저장
		
		System.out.printf("  이름  학번   국어 영어 수학\n"); //출력
		while(k20_rset.next()) { //행1줄 씩 다음으로 넘어가며 반복
			System.out.printf("%4s %6s  %3s  %3s  %3s \n",
					k20_rset.getString(1),k20_rset.getString(2),k20_rset.getString(3),
					k20_rset.getString(4),k20_rset.getString(5));
		}	//테이블에서 데이터 형태에 따라 출력
		k20_rset.close(); //rset 종료
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //conn 종료
	}
}
