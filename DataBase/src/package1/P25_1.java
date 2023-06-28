package package1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P25_1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.
		
		k20_stmt.execute(  "create table cctv(" + 
				"number    int not null primary key, " + 
				"manage_office    varchar(50), " + 
				"place_addr_road    varchar(200), " + 
				"place_addr_land    varchar(200), " + 
				"purpose    varchar(50), " +
				"camera_number    int,  " +
				"camera_pixel    int, " +
				"camera_info    varchar(100), " +
				"period    int, " +
				"inst_date    varchar(50), " + 
				"manage_office_phone    varchar(50), " + 
				"latitude    double, " + 
				"longitude    double, " + 
				"write_date    date);" 
				 );
		//resultset이 없으므로 execute 함수 사용
		//execute: 모든 유형의 SQL문장을 사용할수 있으며 수행결과로 Boolean 타입의 값을 반환
		//create는 테이블을 만듬

		File k20_f = new File("C:\\Users\\w\\Desktop\\전국cctv표준데이터Refine.csv"); //파일 실행 객체 생성
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f)); //파일처리를 위한 버퍼 생성
		
		String k20_readtxt;
		if((k20_readtxt = k20_br.readLine()) == null){ //빈줄이면 출력
			System.out.println("빈 파일입니다\n");
			return;
		}
		String[] k20_field_name = k20_readtxt.split(","); //필드명을 콤마기준으로 나눠 배열에 저장
		
		int k20_LineCnt = 0; //변수 선언
		while((k20_readtxt = k20_br.readLine()) != null) {//빈라인이 생길때 까지 라인을 하나씩읽으며 반복
			String[] k20_field = k20_readtxt.split(","); //라인을 콤마로 나눠 배열에 저장
			String k20_QueryTxt; //변수 선언
			k20_QueryTxt = String.format("insert into cctv ("
					+ "number, manage_office, place_addr_road, place_addr_land, purpose,"
					+ "camera_number, camera_pixel, camera_info, period, inst_date,"
					+ "manage_office_phone, latitude, longitude, write_date)"
					+ "values("
					+ "'%s', '%s', '%s', '%s', '%s' ,"
					+ "'%s', '%s', '%s', '%s', '%s' ,"
					+ "'%s', '%s', '%s', '%s');", 
					k20_field[0], k20_field[1], k20_field[2], k20_field[3], k20_field[4], 
					k20_field[5], k20_field[6], k20_field[7], k20_field[8], k20_field[9], 
					k20_field[10], k20_field[11], k20_field[12], k20_field[13]);
			//쿼리문을 작성/필드에 값을 넣어줌
			k20_stmt.execute(k20_QueryTxt); //쿼리문을 실행시킴
			System.out.printf("%d번째 항목 Insert OK [%s]\n", k20_LineCnt, k20_QueryTxt);
			//줄과 쿼리문을 출력
			k20_LineCnt++;
		}
		k20_br.close(); //버퍼 종료
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //conn 종료
	}
}
