package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Page8_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File K20_f = new File("C:\\Users\\w\\Desktop\\�������������������.txt"); //���� ��ü ����
		BufferedReader K20_br = new BufferedReader(new FileReader(K20_f));
		//���۸� �̿��� �����б� ��ü ����
		
		String K20_readtxt;	//���� ����

		if ((K20_readtxt = K20_br.readLine()) == null) {	//���� �����̸�
			System.out.println("�� ���� �Դϴ�\n");	//���
			return;
		}

		String[] K20_field_name = K20_readtxt.split("\t");	//���� �������� ���� ���� �߶� �迭�� ����

		double K20_lat = 37.3860521;	//���� ��ġ
		double K20_lng = 127.1214038;

		int K20_LineCnt = 0;	//���� ����
		while ((K20_readtxt = K20_br.readLine()) != null) {	//���ٱ��� �ݺ�

			String[] K20_field = K20_readtxt.split("\t");	//���� �������� ���� ���� �߶� �迭�� ����
			System.out.printf("**[%d��° �׸�]********************************************\n", K20_LineCnt);
			System.out.printf(" %s : %s\n", K20_field_name[9], K20_field[9]);	//�׸� �ٷ�
			System.out.printf(" %s : %s\n", K20_field_name[13], K20_field[13]);
			System.out.printf(" %s : %s\n", K20_field_name[14], K20_field[14]);
			double K20_dist=Math.sqrt( Math.pow(Double.parseDouble(K20_field[13])-K20_lat, 2)
					+ Math.pow(Double.parseDouble(K20_field[14])-K20_lng, 2));
			//��Ÿ��� ������ ����ġ�� �׸� ��ġ�� �Ÿ� ���
			System.out.printf(" ���������� �Ÿ� : %f\n",K20_dist);	//�Ÿ� ���
			System.out.printf("************************************************************\n");
			if(K20_LineCnt == 100) break;	//100���� ���
			K20_LineCnt++;
		}
		K20_br.close();	//���� ����
	}

}
