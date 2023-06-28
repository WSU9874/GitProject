package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P22 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.
		
		k20_stmt.execute(  "create table freewifi(" + //freewifi 테이블 생성
				"inst_place        varchar(50), " +  //설치장소명
				"inst_place_detail varchar(200), " +  //설치장소상세
				"inst_city         varchar(50), " +  //설치시도명
				"inst_country         varchar(50),  " +  //설치시군명
				"inst_place_flag        varchar(50), " + //설치시설구분
				"service_provider  varchar(50), " +  //서비스제공사명
				"wifi_ssid    varchar(100), " +  //와이파이SSID
				"inst_date    varchar(50), " +  //설치년월
				"place_addr_road    varchar(200), " +  //소재지도로명주소
				"place_addr_land    varchar(200), " +  //소재지지번주소
				"manage_office    varchar(50), " +  //관리기관명
				"manage_office_phone    varchar(50), " +  //관리기관전화번호
				"latitude    double, " +  //위도
				"longitude    double, " +  //경도
				"write_date    date, " +  //데이터기준일자
				"number    int not null primary key) " + //개수세기 중복 없게한다
				"DEFAULT CHARSET = utf8;");
		//resultset이 없으므로 execute 함수 사용
		//execute: 모든 유형의 SQL문장을 사용할수 있으며 수행결과로 Boolean 타입의 값을 반환
		//create는 테이블을 만듬
		
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //conn 종료
	}
}
