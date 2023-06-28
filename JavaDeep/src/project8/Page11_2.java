package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page11_2 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");
		//파일 실행 객체 생성
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//파일 읽기 객체 생성
		File k20_f1 = new File("C:\\Users\\w\\Desktop\\day_data\\Samsung2.csv");
		//파일 생성 객체
		BufferedWriter k20_bw1 = new BufferedWriter(new FileWriter(k20_f1));
		//파일 쓰기 객체 생성

		String k20_readtxt;	//변수 정의
		
		while ((k20_readtxt = k20_br.readLine()) != null) {	//빈줄까지 반복
			StringBuffer k20_s = new StringBuffer();	//버퍼 객체 생성
			String[] k20_field = k20_readtxt.split(",");	//콤마로 나눠서 배열에 넣음

			if (k20_field.length > 2) {	//field길이가 2보다 크다면
				k20_s.append(k20_field[0].trim());	//0번째 항목을 이어붙임
				for (int k20_j = 1; k20_j < k20_field.length; k20_j++) {	//field배열의 길이만큼 반복
					k20_s.append("," + k20_field[k20_j].trim());	//콤마와 field의 j항목을 이어붙임
				}
				if (k20_field[1].equals("20150112")) {	//2번째 항목이 이것이면
					k20_bw1.write(k20_s.toString());	//기록한다
					k20_bw1.newLine();
				}
			}
		}
		k20_br.close();	//버퍼 닫음
		k20_bw1.close();
	}
}
