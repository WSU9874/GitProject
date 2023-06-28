package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Page9 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\THTSKS010H00.dat"); // 파일 실행 객체 생성
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f)); // 파일 읽는 객체 생성

		String k20_readtxt; // 변수 정의 후 초기화
		int k20_LineCnt = 0;
		int k20_n = -1;
		StringBuffer k20_s = new StringBuffer(); // 버퍼 객체 생성
		while (true) { // 무한반복
			char[] k20_ch = new char[1000]; // 1000개 칸의 char배열 생성
			k20_n = k20_br.read(k20_ch); // 실행한 파일을 읽음
			if (k20_n == -1)
				break; // n이 -1이면 중단
			for (char k20_c : k20_ch) { // ch를 c에 넣음
				if (k20_c == '\n') { // c에서 줄바꿈이 있으면
					System.out.printf("[%s***\n]", k20_s.toString()); // 줄력
					k20_s.delete(0, k20_s.length()); // 문자열을 일부 삭제
				} else {
					k20_s.append(k20_c); // 문자열 마지막에 추가
				}
			}
			k20_LineCnt++;
		}
		System.out.printf("[%s]***\n", k20_s.toString()); // 출력
		k20_br.close(); // 버퍼 닫기
	}
}
