package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Page7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File k20_f = new File("C:\\Users\\w\\Desktop\\전국무료와이파이정보.csv");	//파일 객체 생성
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));	
		//버퍼를 이용한 파일읽기 객체 생성
		
		String k20_readtxt;	//변수 정의
		
		if((k20_readtxt = k20_br.readLine()) == null) {		//빈줄이 나오면
			System.out.printf("빈 파일입니다\n");	//출력
			return;
		}
		String[] k20_field_name = k20_readtxt.split(",");	//1줄을 콤마를 기준으로 잘라서 배열에 넣음
		
		int k20_LineCnt = 0;	//변수정의
		while((k20_readtxt = k20_br.readLine()) != null) {	//빈칸이 나올 때까지 반복
			
			String[] k20_field = k20_readtxt.split(",");	//콤마를 기준으로 텍스트나눔
			System.out.printf("**[%d번째 항목]****************",k20_LineCnt);	//출력
			for (int k20_j=0;k20_j<k20_field_name.length;k20_j++) {	//배열의 길이만큼 반복
				System.out.printf(" %s : %s\n", k20_field_name[k20_j], k20_field[k20_j]);	//출력
			}
			System.out.printf("************************\n");	//출력
			if(k20_LineCnt==100)break;	//100번반복시 중단
			k20_LineCnt++;
		}
		k20_br.close(); //버퍼 닫음

	}

}
