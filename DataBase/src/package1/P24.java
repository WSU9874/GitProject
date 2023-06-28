package package1;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P24 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.
		
		double k20_lat = 37.3860521; double lng = 127.1214038;
		//현위치 위도, 경도
		
		String k20_QueryTxt; //문자열 선언
//		k20_QueryTxt = String.format("select * from freewifi where " + 
//		"SQRT( POWER( latitude - %f,2) + POWER ( longitude - %f,2)) = " +
//		"(select MIN( SQRT( POWER( latitude - %f, 2) + POWER(longitude - %f,2))) from freewifi);",
//		k20_lat,lng,k20_lat,lng);
//		//가까운 위치 찾기 / 현위치와 테이블에서 위도 경로를 select한 값을 뺀후 가장 적은 것을 구한다.
		
//		k20_QueryTxt = "select *from freewifi"; 
//		//전체 select
//		k20_QueryTxt = "select *from freewifi where service_provider = 'SKT'";
//		//service_provider가 SKT인 것만 select
		k20_QueryTxt = "select *from freewifi where inst_country = '수원시'";
		//inst_country가 수원시인 것만 select
		
		ResultSet k20_rset = k20_stmt.executeQuery(k20_QueryTxt);
		// resultset은 executequery를 통해 쿼리를 실행하면 resultset타입으로 반환해주어 결과값 저장
		int k20_iCnt = 0;
		while(k20_rset.next()) { //끝날 때 까지 한 줄씩 읽으며 반복
			System.out.printf("*(%d)***********************************\n", k20_iCnt++);
			System.out.printf("설치장소명			: %s\n", k20_rset.getString(1));
			System.out.printf("설치장소상세			: %s\n", k20_rset.getString(2));
			System.out.printf("설치시도명			: %s\n", k20_rset.getString(3));
			System.out.printf("설치시군구명			: %s\n", k20_rset.getString(4));
			System.out.printf("설치시설구분			: %s\n", k20_rset.getString(5));
			System.out.printf("서비스제공사명			: %s\n", k20_rset.getString(6));
			System.out.printf("와이파이SSID			: %s\n", k20_rset.getString(7));
			System.out.printf("설치년월			: %s\n", k20_rset.getString(8));
			System.out.printf("소재지도로명주소		: %s\n", k20_rset.getString(9));
			System.out.printf("소재지지번주소			: %s\n", k20_rset.getString(10));
			System.out.printf("관리기관명			: %s\n", k20_rset.getString(11));
			System.out.printf("관리기관전화번호		: %s\n", k20_rset.getString(12));
			System.out.printf("위도				: %f\n", k20_rset.getFloat(13));
			System.out.printf("경도				: %f\n", k20_rset.getFloat(14));
			System.out.printf("데이터기준일자			: %s\n", k20_rset.getDate(15));
			System.out.printf("******************************************\n");	
			//테이블에서 데이터 형태에 따라 출력
		}
		k20_rset.close(); //rset 종료
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //conn 종료
	}
}
