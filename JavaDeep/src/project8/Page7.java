package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Page7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File k20_f = new File("C:\\Users\\w\\Desktop\\�������������������.csv");	//���� ��ü ����
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));	
		//���۸� �̿��� �����б� ��ü ����
		
		String k20_readtxt;	//���� ����
		
		if((k20_readtxt = k20_br.readLine()) == null) {		//������ ������
			System.out.printf("�� �����Դϴ�\n");	//���
			return;
		}
		String[] k20_field_name = k20_readtxt.split(",");	//1���� �޸��� �������� �߶� �迭�� ����
		
		int k20_LineCnt = 0;	//��������
		while((k20_readtxt = k20_br.readLine()) != null) {	//��ĭ�� ���� ������ �ݺ�
			
			String[] k20_field = k20_readtxt.split(",");	//�޸��� �������� �ؽ�Ʈ����
			System.out.printf("**[%d��° �׸�]****************",k20_LineCnt);	//���
			for (int k20_j=0;k20_j<k20_field_name.length;k20_j++) {	//�迭�� ���̸�ŭ �ݺ�
				System.out.printf(" %s : %s\n", k20_field_name[k20_j], k20_field[k20_j]);	//���
			}
			System.out.printf("************************\n");	//���
			if(k20_LineCnt==100)break;	//100���ݺ��� �ߴ�
			k20_LineCnt++;
		}
		k20_br.close(); //���� ����

	}

}
