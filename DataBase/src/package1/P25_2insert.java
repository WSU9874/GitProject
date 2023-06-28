package package1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.sql.PreparedStatement;

public class P25_2insert {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결
		String k20_QueryTxt; //쿼리문 선언
		k20_QueryTxt = "insert into score(studentid, name, kor, eng, mat) values (?,?,?,?,?)";
		//쿼리문 생성

		PreparedStatement k20_stmt = k20_conn.prepareStatement(k20_QueryTxt);
		//많은 양의 데이터를 처리 할때 preparedstatement 사용
		//캐시에서 처리하리 때문에 statement보다 처리속도가 빠르다.

		Random k20_random = new Random(); //랜덤 함수 객체 생성
		
		// 1000명의 데이터 입력
		for (int k20_i = 1; k20_i <= 1000; k20_i++) {
			k20_stmt.setInt(1, k20_i); //학번
			k20_stmt.setString(2, "학생" + k20_i); //학생 이름
			k20_stmt.setInt(3, k20_random.nextInt(101)); //국어점수를 랜덤으로
			k20_stmt.setInt(4, k20_random.nextInt(101)); //영어점수를 랜덤으로
			k20_stmt.setInt(5, k20_random.nextInt(101)); //수학점수를 랜덤으로
			k20_stmt.executeUpdate(); //업데이트를 실행
			}
		}
	}