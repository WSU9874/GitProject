package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Page8_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File K20_f = new File("C:\\Users\\w\\Desktop\\전국무료와이파이정보.txt"); //파일 객체 생성
		BufferedReader K20_br = new BufferedReader(new FileReader(K20_f));
		//버퍼를 이용한 파일읽기 객체 생성
		
		String K20_readtxt;	//변수 정의

		if ((K20_readtxt = K20_br.readLine()) == null) {	//만약 빈줄이면
			System.out.println("빈 파일 입니다\n");	//출력
			return;
		}

		String[] K20_field_name = K20_readtxt.split("\t");	//탭을 기준으로 문장 사이 잘라서 배열에 넣음

		double K20_lat = 37.3860521;	//현재 위치
		double K20_lng = 127.1214038;

		int K20_LineCnt = 0;	//변수 정의
		while ((K20_readtxt = K20_br.readLine()) != null) {	//빈줄까지 반복

			String[] K20_field = K20_readtxt.split("\t");	//탭을 기준으로 문장 사이 잘라서 배열에 넣음
			System.out.printf("**[%d번째 항목]********************************************\n", K20_LineCnt);
			System.out.printf(" %s : %s\n", K20_field_name[9], K20_field[9]);	//항목별 줄력
			System.out.printf(" %s : %s\n", K20_field_name[13], K20_field[13]);
			System.out.printf(" %s : %s\n", K20_field_name[14], K20_field[14]);
			double K20_dist=Math.sqrt( Math.pow(Double.parseDouble(K20_field[13])-K20_lat, 2)
					+ Math.pow(Double.parseDouble(K20_field[14])-K20_lng, 2));
			//피타고라스 정리로 내위치와 항목별 위치의 거리 계산
			System.out.printf(" 현재지점과 거리 : %f\n",K20_dist);	//거리 출력
			System.out.printf("************************************************************\n");
			if(K20_LineCnt == 100) break;	//100개만 출력
			K20_LineCnt++;
		}
		K20_br.close();	//버퍼 닫음
	}

}
