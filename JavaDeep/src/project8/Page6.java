package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page6 {
	public static void FileWrite() throws IOException{	//매서드 생성하고 오류발생시 예외처리
		File kopo20_f = new File("C:\\Users\\w\\Desktop\\Mytest.txt"); //파일객체생성
		BufferedWriter kopo20_bw = new BufferedWriter(new FileWriter(kopo20_f));
		//버퍼를 이용한 파일쓰기 객체 생성
		
		kopo20_bw.write("안녕 파일");	//파일 내용 입력, 줄바꿈
		kopo20_bw.newLine();	
		kopo20_bw.write("hello 헬로");	//파일 내용 입력, 줄바꿈
		kopo20_bw.newLine();
		
		kopo20_bw.close();	//파일 닫기
	}
	public static void FileRead() throws IOException{	//매서드 생성하고 오류발생시 예외처리
		File kopo20_f = new File("C:\\Users\\w\\Desktop\\Mytest.txt");	//파일객체생성
		BufferedReader kopo20_br = new BufferedReader(new FileReader(kopo20_f));
		//버퍼를 이용한 파일쓰기 객체 생성
		
		String kopo20_readtxt;	//문자열 선언
		
		while((kopo20_readtxt = kopo20_br.readLine()) != null) {	
			//읽어온 텍스트가 빈칸이아니라면
			System.out.printf("%s\n", kopo20_readtxt);	//텍스트를 출력
		}
		kopo20_br.close();	//파일 닫기
	}

	public static void main(String[] args) throws IOException{
		//메인실행 오류발생시 예외처리
		FileWrite();	//파일 쓰기	메서드 실행
		FileRead();		//파일 읽기	메서드 실행

	}

}
