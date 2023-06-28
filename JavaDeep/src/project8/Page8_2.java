package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Page8_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File k20_f = new File("C:\\Users\\w\\Desktop\\전국무료와이파이정보.txt");	//파일 객체 생성
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));	
		//버퍼를 이용한 파일읽기 객체 생성

		String k20_readtxt;	//변수 정의

		if ((k20_readtxt = k20_br.readLine()) == null) { //빈칸 나오면 출력
			System.out.println("빈 파일 입니다\n");
		}

		String[] k20_field_name = k20_readtxt.split("\t");	//탭기준으로 나누고 배열에 넣음

		double k20_lat = 37.3860521;	//현재 위도, 경도
		double k20_lng = 127.1214038;

		int k20_LineCnt = 1; // 정수 선언후 초기화
		double k20_min = Double.MAX_VALUE; // 더블 min은 더블 최대값
		int k20_min_index = 0; // 최소 인덱스값 0으로 초기화
		String k20_min_wifi = ""; // 빈문자열 선언

		double k20_max = Double.MIN_VALUE; // 더블형 max는 더블 최소값
		int k20_max_index = 0; // 최대 인덱스 0
		String k20_max_wifi = ""; // 빈문자열 선언

		while ((k20_readtxt = k20_br.readLine()) != null) {	//빈칸나올때까지 반복
			try {
				String[] k20_field = k20_readtxt.split("\t");	//탭으로 나눔
				System.out.printf("**[%d번째 항목]********************************************\n", k20_LineCnt);
				System.out.printf(" %s : %s\n", k20_field_name[9], k20_field[9]); //항목별 출력
				System.out.printf(" %s : %s\n", k20_field_name[13], k20_field[13]);
				System.out.printf(" %s : %s\n", k20_field_name[14], k20_field[14]);
				double k20_dist = Math.sqrt(Math.pow(Double.parseDouble(k20_field[13]) - k20_lat, 2)
						+ Math.pow(Double.parseDouble(k20_field[14]) - k20_lng, 2));
				//피타고라스 정리로 항목의 위치와 내위치 위도 경도로 거리 계산

				k20_min = Math.min(k20_min, k20_dist); // 최소값을 구한다
				if (k20_min == k20_dist) {
					k20_min_index = k20_LineCnt;
					k20_min_wifi = k20_field[1];
				}
				k20_max = Math.max(k20_max, k20_dist); // 최대값을 구한다
				if (k20_max == k20_dist) {
					k20_max_index = k20_LineCnt;
					k20_max_wifi = k20_field[1];
				}

				System.out.printf(" 현재지점과 거리 : %f\n", k20_dist);	//출력

				System.out.printf("************************************************************\n");

				k20_LineCnt++;
			} catch (Exception e) {	//에러발생시 줄바꿈
				System.out.println("");
			}
			System.out.println(); // 출력

		}
		System.out.printf("최소거리 : %f  %d번 %s\n", k20_min, k20_min_index, k20_min_wifi);	//출력
		System.out.printf("최대거리 : %f  %d번 %s\n", k20_max, k20_max_index, k20_max_wifi);
		k20_br.close();	//버퍼 닫음
	}

}
