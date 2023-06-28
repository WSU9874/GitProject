package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page11_1 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");
		//파일 실행 객체 생성
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//파일 읽기 객체 생성

		File k20_f1 = new File("C:\\Users\\w\\Desktop\\day_data\\Samsung1.csv");
		//파일 실행 객체 생성
		BufferedWriter k20_bw1 = new BufferedWriter(new FileWriter(k20_f1));
		//파일 쓰기 객체 생성

		String k20_readtxt;	//변수 정의

		while ((k20_readtxt = k20_br.readLine()) != null) {	//빈줄까지 반복실행
			StringBuffer k20_s = new StringBuffer();	//버퍼 객체 생성
			String[] k20_field = k20_readtxt.split(",");	//콤마을 기준으로 나눠서 배열에 넣음

			if (k20_field.length > 2) {	//항목의 길이가 2보다 높을 경우
				k20_s.append(k20_field[0].trim());	//0번째 항목을 잘라서 이어붙음
				for (int k20_j = 1; k20_j < k20_field.length; k20_j++) {	//fiedld의 항목개수만큼 반복
					k20_s.append("," + k20_field[k20_j].trim());	//콤마와 j번째 항목을 붙암
				}
				if (k20_field[2].equals("A005930")) {	//3번째 요소가 이것이라면
					}
					k20_bw1.write(k20_s.toString());	//그 항목의 배열을 기록한다
					k20_bw1.newLine();
				}
		}
		k20_br.close();	//버퍼 닫음
		k20_bw1.close();
	}
}
