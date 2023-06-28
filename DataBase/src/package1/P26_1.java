package package1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class P26_1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		Statement k20_stmt = k20_conn.createStatement();
		// statement는 connection으로 연결한 객체에게 쿼리작업을 실행하기 위한 객체이다.

		k20_stmt.execute(  "create table stockdailyprice(" + 
				"shrn_iscd    varchar(20), " + 
				"bsop_date    varchar(20), " + 
				"stck_oprc    int, " + 
				"stck_hgpr    int, " +
				"stck_lwpr    int, " +	
				"stck_prpr    int, " + 
				"acml_vol     bigint, " + 
				"acml_tr_pbmn   bigint," + 
				"primary key(shrn_iscd, bsop_date));" 
				 );			
		//resultset이 없으므로 execute 함수 사용
		//execute: 모든 유형의 SQL문장을 사용할수 있으며 수행결과로 Boolean 타입의 값을 반환
		//create는 테이블을 만듬
		
		k20_stmt.close(); //stmt 종료
		k20_conn.close(); //conn 종료
	}
}
