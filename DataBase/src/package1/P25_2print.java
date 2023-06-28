package package1;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P25_2print {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.
		String k20_QueryTxt; //쿼리문 선언
		String k20_QueryNum;
		String k20_QueryTotal;
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		int k20_i = 0;
		while (k20_i < 34) { //1000명을 30명씩 한페이지로 나누면 34페이지 / 34번 반복
			k20_QueryTxt = String.format("select studentid, name, kor, eng, mat from score limit %d,30", 0 + (k20_i * 30)); 
			//30명씩 학번, 이름 국,영,수, 총점, 평균을 select
			ResultSet k20_rset = k20_stmt.executeQuery(k20_QueryTxt);
			// resultset은 executequery를 통해 쿼리를 실행하면 resultset타입으로 반환해주어 결과값 저장
			System.out.println("학번     이름    국어  영어  수학  합계    평균\n"); //출력
			while (k20_rset.next()) { //끝날 때 까지 한 줄씩 읽으며 반복
				System.out.printf("%4d %6s %6d %5d %5d %5d %8.2f\n", k20_rset.getInt(1), k20_rset.getString(2), k20_rset.getInt(3), k20_rset.getInt(4), k20_rset.getInt(5), 
																(k20_rset.getInt(3)+k20_rset.getInt(4)+k20_rset.getInt(5)), 
																(k20_rset.getDouble(3)+k20_rset.getDouble(4)+k20_rset.getDouble(5)/3));
			//테이블에서 데이터 형태에 따라 출력
			}
			k20_rset.close(); //rset 종료
			k20_QueryNum = String.format(
					"select sum(kor), sum(eng), sum(mat), sum(kor+eng+mat), sum(kor+eng+mat)/30 from (select *from score limit %d,30) as a",
					0 + (k20_i * 30));
			//30명씩 select하고 각각 국영수 각각 합계, 총합계, 평균을 select
			ResultSet k20_sumset = k20_stmt.executeQuery(k20_QueryNum);
			// resultset은 executequery를 통해 쿼리를 실행하면 resultset타입으로 반환해주어 결과값 저장
			while (k20_sumset.next()) {
				System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.printf("현재 페이지");
				System.out.printf("%9d %5d %5d %6d %7.2f\n", k20_sumset.getInt(1), k20_sumset.getInt(2), k20_sumset.getInt(3), k20_sumset.getInt(4), k20_sumset.getDouble(5));
				//테이블에서 데이터 형태에 따라 출력
				k20_i++;
			}
			k20_QueryTotal = String.format(
					"select sum(kor), sum(eng), sum(mat), sum(kor+eng+mat), sum(kor+eng+mat)/30 from (select *from score limit 0, %d) as a", (k20_i * 30));
			//30명씩 select하고 각각 국영수 각각 합계, 총합계, 평균을 누적하여 select
			ResultSet k20_totalset = k20_stmt.executeQuery(k20_QueryTotal);
			// resultset은 executequery를 통해 쿼리를 실행하면 resultset타입으로 반환해주어 결과값 저장
			while (k20_totalset.next()) {
				System.out.printf("누적 페이지");
				System.out.printf("%9d %5d %5d %6d %7.2f\n", k20_totalset.getInt(1), k20_totalset.getInt(2), k20_totalset.getInt(3), 
																k20_totalset.getInt(4), k20_totalset.getDouble(5));
				System.out.printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				//테이블에서 데이터 형태에 따라 출력
		}
			k20_totalset.close(); //종료
		}
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //conn 종료
	}
}