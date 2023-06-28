package package1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P23 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.
		
		//파일 입력을 위해 File 객체를 생성하고 파일 경로를 입력한다.
		File k20_f = new File("C:\\Users\\w\\Desktop\\전국무료와이파이표준데이터.txt");
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		
		String k20_readtxt; //파일을 한줄씩 읽기 위해 변수 선언
		
		if((k20_readtxt = k20_br.readLine()) == null){ //첫줄이 비면 출력
			System.out.println("빈 파일입니다\n");
			return;
		}
		String[] k20_field_name = k20_readtxt.split("\t");
		//읽은 내용을 탭를 기준으로 필드명을 나눠서 배열에 저장
		
		int k20_LineCnt = 0; //읽은 라인 수를 저장하는 변수 선언
		while((k20_readtxt = k20_br.readLine()) != null) { //라인이 null이 아니면 반복
			String[] k20_field = k20_readtxt.split("\t"); //탭을 기준으로 필드값을 나눠서 저장
			String k20_QueryTxt;
			
			k20_QueryTxt = String.format("insert into freewifi ("
					+ "inst_place, inst_place_detail, inst_city, inst_country, inst_place_flag,"
					+ "service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land,"
					+ "manage_office, manage_office_phone, latitude, longitude, write_date, number)"
					+ "values("
					+ "'%s', '%s', '%s', '%s', '%s' ,"
					+ "'%s', '%s', '%s', '%s', '%s' ,"
					+ "'%s', '%s', '%s', '%s', '%s' , '%s');", 
					k20_field[0], k20_field[1], k20_field[2], k20_field[3], k20_field[4], 
					k20_field[5], k20_field[6], k20_field[7], k20_field[8], k20_field[9], 
					k20_field[10], k20_field[11], k20_field[12], k20_field[13], k20_field[14], k20_field[15]);
			//쿼리문을 작성/필드에 값을 넣어줌
			k20_stmt.execute(k20_QueryTxt); //쿼리를 실행
			System.out.printf("%d번째 항목 Insert OK [%s]\n", k20_LineCnt, k20_QueryTxt);
			//줄과 쿼리문을 출력
			k20_LineCnt++;
		}
		k20_br.close(); //버퍼 종료
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //conn 종료
	}
}
