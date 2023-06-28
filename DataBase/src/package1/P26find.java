package package1;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P26find {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.

		String k20_QueryTxt; //문자열 선언

		k20_QueryTxt = "select *from stockdailyprice  where shrn_iscd = 'A005930'";
		//shrn_iscd가 경상남도 A005930인 것만 select
//		k20_QueryTxt = "select *from stockdailyprice  where bsop_date = '20120125'";
//		//bsop_date가 경상남도 20120125인 것만 select

		ResultSet k20_rset = k20_stmt.executeQuery(k20_QueryTxt);
		// resultset은 executequery를 통해 쿼리를 실행하면 resultset타입으로 반환해주어 결과값 저장
		int k20_iCnt = 0;
		while (k20_rset.next()) { //끝날 때 까지 한 줄씩 읽으며 반복
			System.out.printf("*(%d)****************************************\n", k20_iCnt++);
			System.out.printf("단축코드			: %12s\n", k20_rset.getString(1));
			System.out.printf("영업 일자			: %12s\n", k20_rset.getString(2));
			System.out.printf("주식 최고가			: %12d\n", k20_rset.getInt(3));
			System.out.printf("주식 최저자			: %12d\n", k20_rset.getInt(4));
			System.out.printf("주식 종가			: %12d\n", k20_rset.getInt(5));
			System.out.printf("주식 거래량			: %12d\n", k20_rset.getInt(6));
			System.out.printf("누적 거래량			: %12d\n", k20_rset.getLong(7));
			System.out.printf("누적 거래 대금			: %12d\n", k20_rset.getLong(8));
			System.out.printf("***********************************************\n");
			//테이블에서 데이터 형태에 따라 출력
		}
		k20_rset.close(); //rset 종료
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //conn 종료
	}
}