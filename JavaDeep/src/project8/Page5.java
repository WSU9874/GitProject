package project8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Page5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { // 에러가 생기지 않으면 실행
			File kopo20_f = new File("C:\\Users\\w\\Mytest.txt");
			// 파일 객체 생성
			FileWriter kopo20_fw = new FileWriter(kopo20_f);
			// 파일을 쓰는 용도의 객체 fw 생성

			kopo20_fw.write("안녕 파일\n"); // fw에 내용입력
			kopo20_fw.write("hello 헬로\n"); // fw에 내용입력

			kopo20_fw.close(); // io는 다쓰면 닫음

			FileReader kopo20_fr = new FileReader(kopo20_f);
			// 파일을 읽는 용도의 객체 fr생성

			int kopo20_n = -1; // 정수 n을 -1로 초기화
			char[] kopo20_ch; // ch배열 선언

			while (true) { // 무한반복
				kopo20_ch = new char[100];  //캐릭터를 100개까지 저장하는 객체 생성
				// heap에 변수 생성해서 스콥 밖에서도 사용가능
				kopo20_n = kopo20_fr.read(kopo20_ch); // ch를 읽는 객체 fr을 정수n으로 정함

				if (kopo20_n == -1)
					break; // 만약 n이 -1이면 반복문 중지

				for (int kopo20_i = 0; kopo20_i < kopo20_n; kopo20_i++) {
					// 루프 1회마다 i에 1씩더해 n이 될때까지 반복

					// for(char c : ch) {
					System.out.printf("%c", kopo20_ch[kopo20_i]);
					// i번째 ch를 출력
				}
			}

			kopo20_fr.close(); // fr의 io를 닫음

			System.out.printf("\n FILE READ END"); // 출력
		} catch (Exception e) { // 에러가생기면 실행
			System.out.printf("나 에러[%s]\n", e); // 출력
		}
	}
}
