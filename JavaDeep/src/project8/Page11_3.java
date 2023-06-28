package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page11_3 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");
		//파일 실행 객체 생성
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//파일 읽기 객체 생성
		File k20_f1 = new File("C:\\Users\\w\\Desktop\\day_data\\Samsung3.csv");
		//파일 생성
		BufferedWriter k20_bw1 = new BufferedWriter(new FileWriter(k20_f1));
		//파일 쓰기 객체 생성

		String k20_readtxt;	//변수 정의
		int k20_cnt = 0;
		int k20_wcnt = 0;
		int k20_min = Integer.MAX_VALUE;
		int k20_max = Integer.MIN_VALUE;

		while ((k20_readtxt = k20_br.readLine()) != null) {	//빈칸까지 반복
			StringBuffer k20_s = new StringBuffer();	//버퍼 객체 생성
			String[] k20_field = k20_readtxt.split(","); //콤마로 나눠 배열에 넣음
			if (k20_field[2].equals("A005930") && k20_field[1].substring(0, 4).equals("2015")) {	
				//배열의 항목이 이것이라면
				if (Double.parseDouble(k20_field[3]) > k20_max) {	//최대값을 갱신한다
					k20_max = Integer.parseInt(k20_field[3]);
				}
				if (Double.parseDouble(k20_field[3]) < k20_min) {	//최소값을 갱신한다
					k20_min = Integer.parseInt(k20_field[3]);
				}
				k20_bw1.write(k20_s.toString());	//위의 조건에 맞으면 파일에 기록
				k20_bw1.newLine();
				k20_wcnt++;
			}
			k20_cnt++;
		}
		k20_br.close();	//버퍼 닫기
		k20_bw1.close();
		System.out.printf("Program End[%d][%d]records\n", k20_cnt, k20_wcnt);	//최대최소가 출력
		System.out.println("2015년 삼성전자 주식 최고가 : " + k20_max + "원");
		System.out.println("2015년 삼성전자 주식 최저가 : " + k20_min + "원");
	}
}


