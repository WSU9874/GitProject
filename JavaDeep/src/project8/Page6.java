package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page6 {
	public static void FileWrite() throws IOException{	//�ż��� �����ϰ� �����߻��� ����ó��
		File kopo20_f = new File("C:\\Users\\w\\Desktop\\Mytest.txt"); //���ϰ�ü����
		BufferedWriter kopo20_bw = new BufferedWriter(new FileWriter(kopo20_f));
		//���۸� �̿��� ���Ͼ��� ��ü ����
		
		kopo20_bw.write("�ȳ� ����");	//���� ���� �Է�, �ٹٲ�
		kopo20_bw.newLine();	
		kopo20_bw.write("hello ���");	//���� ���� �Է�, �ٹٲ�
		kopo20_bw.newLine();
		
		kopo20_bw.close();	//���� �ݱ�
	}
	public static void FileRead() throws IOException{	//�ż��� �����ϰ� �����߻��� ����ó��
		File kopo20_f = new File("C:\\Users\\w\\Desktop\\Mytest.txt");	//���ϰ�ü����
		BufferedReader kopo20_br = new BufferedReader(new FileReader(kopo20_f));
		//���۸� �̿��� ���Ͼ��� ��ü ����
		
		String kopo20_readtxt;	//���ڿ� ����
		
		while((kopo20_readtxt = kopo20_br.readLine()) != null) {	
			//�о�� �ؽ�Ʈ�� ��ĭ�̾ƴ϶��
			System.out.printf("%s\n", kopo20_readtxt);	//�ؽ�Ʈ�� ���
		}
		kopo20_br.close();	//���� �ݱ�
	}

	public static void main(String[] args) throws IOException{
		//���ν��� �����߻��� ����ó��
		FileWrite();	//���� ����	�޼��� ����
		FileRead();		//���� �б�	�޼��� ����

	}

}
