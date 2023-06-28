package package1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class P26 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat k20_time = new SimpleDateFormat("HH:mm:ss");
		//시간의 표현을 바꾸는 객체 생성
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc 버전에 따라 driver 종류 다르다
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// 나의 우분투 접속주소, 포트포워딩한 주소, db사용자, 비밀번호 입력 후 연결

		String k20_QueryTxt = "insert into stockdailyprice (shrn_iscd, bsop_date, stck_oprc,"
				+ "stck_hgpr, stck_lwpr, stck_prpr, acml_vol, acml_tr_pbmn) values(?, ?, ?, ?, ?, ?, ?, ?)";
		//쿼리문 생성
		PreparedStatement k20_psmt = k20_conn.prepareStatement(k20_QueryTxt);
		//많은 양의 데이터를 처리 할때 preparedstatement 사용
		//캐시에서 처리하리 때문에 statement보다 처리속도가 빠르다.
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");
		//파일을 읽는 객체
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//대욜량 처리를 위해 버퍼 객체를 생성

		String k20_readtxt; //변수 선언

		if ((k20_readtxt = k20_br.readLine()) == null) { //빈줄이면 출력
			System.out.println("빈 파일입니다.\n");
			return;
		}
		String[] k20_field_name = k20_readtxt.split(","); //필드명을 콤마기준으로 나눠 배열에 저장

		int k20_LineCnt = 0; //변수 선언
		k20_conn.setAutoCommit(false); //insert속도 향상을 위해 자동커밋을 끈다
		long k20_startTime = System.currentTimeMillis(); //시작시간을 ms단위로 저장

		while ((k20_readtxt = k20_br.readLine()) != null) { //빈라인이 생길때 까지 라인을 하나씩읽으며 반복
			String[] k20_field = k20_readtxt.split(","); //라인을 콤마로 나눠 배열에 저장
			k20_psmt.setString(1, k20_field[2]); //varchar(단축코드)
			k20_psmt.setString(2, k20_field[1]); //bsop_date (영업 일자)
			k20_psmt.setString(3, k20_field[5]); //stck_oprc (주식 최고가)
			k20_psmt.setString(4, k20_field[6]); //stck_hgpr (주식 최저자) 
			k20_psmt.setString(5, k20_field[3]); //stck_lwpr (주식 종가)
			k20_psmt.setString(6, k20_field[4]); //stck_prpr (주식 거래량)
			k20_psmt.setString(7, k20_field[11]); //acml_vol (누적 거래량)
			k20_psmt.setString(8, k20_field[12]); //acml_tr_pbmn (누적 거래 대금)
			k20_psmt.addBatch(); //메소드를 호출해 캐시에 SQL문장을 담는다.
//			System.out.printf("%d번째 항목 addBatch OK\n", LineCnt);
			k20_psmt.clearParameters(); //psmt의 파라미터를 비운다.
			k20_LineCnt++;
			try {
				if (k20_LineCnt % 50000 == 0) { //50000줄을 셀 때 마다
					System.out.printf("%d번째 항목 addBatch OK\n", k20_LineCnt); //출력
					k20_psmt.executeBatch(); //캐시에 담긴 SQL문장을 실행
					k20_conn.commit(); //데이터 영구히 저장
				}
			} catch (Exception e) {
				e.printStackTrace(); //예외처리
			}
		}
		//루프가 끝난뒤 남은 문장을 실행해야한다
		try {
			k20_psmt.executeBatch(); //캐시에 담긴 나머지 SQL문장을 실행
		} catch (Exception e) {
			e.printStackTrace(); //예외처리
		}
		k20_conn.commit(); //모든 insert가 완료 되고 영구히 저장한다.
		k20_conn.setAutoCommit(true); //자동커밋을 킨다
		long k20_endTime = System.currentTimeMillis(); //종료시간을 밀리세컨드로 표현

		System.out.printf("Insert End\n"); //출력
		System.out.printf("total	: %d\n", k20_LineCnt); //전체 문장 수를 출력
		System.out.println("start    :" + k20_time.format(k20_startTime)); //시작시간을 정한 형식으로 출력
		System.out.println("end    :" + k20_time.format(k20_endTime)); //종료시간을 정한 형식으로 출력
		System.out.println("time		:  " + (k20_endTime - k20_startTime) / 1000 + "초"); //걸린시간을 ms로 표현
		k20_br.close(); //버퍼 종료
		k20_psmt.close(); //psmt 종료
		k20_conn.close(); //conn 종료
	}
}
