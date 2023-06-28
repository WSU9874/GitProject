package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Page8_3 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException { // main함수 예외처리
		// TODO Auto-generated method stub

		File k20_f = new File("C:\\Users\\w\\Desktop\\경상남도_통영시_주차장정보.txt");
		//파일 실행하는 객체 생성
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//파일 읽는 객체 생성
		
		String k20_readtxt;	//문자열 생성

		if ((k20_readtxt = k20_br.readLine()) == null) {	//읽어온 텍스트가 빈칸이라면
			System.out.println("빈 파일 입니다\n");	//출력
			return;
		}

		String[] field_name = k20_readtxt.split("\t");	//읽어온 문자열을 탭으로 나눠서 배열에 넣음

		double k20_lat = 37.3860521;	//더블형 선언후 초기화
		double k20_lng = 127.1214038;	//더블형 선언후 초기화

		int k20_LineCnt = 1;	//정수 선언후 초기화
		double k20_min = Double.MAX_VALUE;	//더블 min은 더블 최대값
		int k20_min_index = 0;	//최소 인덱스값 0으로 초기화
		String k20_min_parking = "";	//빈문자열 선언

		double k20_max = Double.MIN_VALUE;	//더블형 max는 더블 최소값
		int k20_max_index = 0;	//최대 인덱스 0
		String k20_max_parking = "";	//빈문자열 선언

		while ((k20_readtxt =k20_br.readLine()) != null) {
			//읽어온 텍스트가 빈칸이 아니라면
			
			String[] k20_field = k20_readtxt.split("\t");	//읽은 값을 탭으로 나눠 배열에 넣음
			System.out.printf("**[%d번째 항목]********************************************\n", k20_LineCnt);
			System.out.printf(" %s : %s\n", field_name[5], k20_field[5]);
			System.out.printf(" %s : %s\n", field_name[28], k20_field[28]);
			System.out.printf(" %s : %s\n", field_name[29], k20_field[29]);
			//출력
			double k20_dist = Math.sqrt(Math.pow(Double.parseDouble(k20_field[28]) - k20_lat, 2)
					+ Math.pow(Double.parseDouble(k20_field[29]) - k20_lng, 2));
			//거리를 위도로 피타고라스정리를 해서 구한다

			k20_min = Math.min(k20_min, k20_dist);	//최소값을 구한다
			if (k20_min == k20_dist) {
				k20_min_index = k20_LineCnt;
				k20_min_parking = k20_field[1];
			}
			k20_max = Math.max(k20_max, k20_dist);	//최대값을 구한다
			if (k20_max == k20_dist) {
				k20_max_index = k20_LineCnt;
				k20_max_parking = k20_field[1];
			}

			System.out.printf(" 현재지점과 거리 : %f\n", k20_dist);	//출력
			System.out.printf("************************************************************\n");
			k20_LineCnt++;	//루프끝날때 1더함
		}
		System.out.println();	//출력
		System.out.printf("최소거리 : %f  %d번 %s\n", k20_min, k20_min_index, k20_min_parking);
		System.out.printf("최대거리 : %f  %d번 %s\n", k20_max, k20_max_index, k20_max_parking);
		k20_br.close();	//파일 닫음

	}

}
