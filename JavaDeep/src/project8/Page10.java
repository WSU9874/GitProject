package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page10 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\THTSKS010H00.dat");	//주식파일 실행하는 객체
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));	//파일 읽는 객체

		File k20_f1 = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");	//생성할 csv파일 객체
		BufferedWriter k20_bw1 = new BufferedWriter(new FileWriter(k20_f1));	//파일 읽을 객체

		String k20_readtxt;	//변수 정의
		int k20_cnt = 0;
		int k20_wcnt = 0;

		while ((k20_readtxt = k20_br.readLine()) != null) {	//빈칸까지 반복
			StringBuffer k20_s = new StringBuffer();	//객체 생성
			String[] k20_field = k20_readtxt.split("%_%");	//저 기호를 기준으로 잘라서 배열에 넣음
			if (k20_field.length > 2 && k20_field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
				k20_s.append(k20_field[0].replace("^", "").trim());	//파일에 0번째 항목을 수정하고 잘라서 이어붙임
				for (int k20_j = 1; k20_j < k20_field.length; k20_j++) {	
					k20_s.append("," + k20_field[k20_j].replace("^", "").trim());	
					//파일에 j번째 항목을 수정하고 잘라서 이어붙임
				}
				k20_bw1.write(k20_s.toString());	//쓰기 실행
				k20_bw1.newLine();	//줄바꿈
				k20_wcnt++;
				// System.out.printf("write [%d][%d][%s]\n", cnt,wcnt,s.toString());
			}
			k20_cnt++;
		}
		k20_br.close();	//버퍼 닫기
		k20_bw1.close();
		System.out.printf("Program End[%d][%d]records\n", k20_cnt, k20_wcnt);	//결과 출력
	}
}
