package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Page8_3 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException { // main�Լ� ����ó��
		// TODO Auto-generated method stub

		File k20_f = new File("C:\\Users\\w\\Desktop\\��󳲵�_�뿵��_����������.txt");
		//���� �����ϴ� ��ü ����
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//���� �д� ��ü ����
		
		String k20_readtxt;	//���ڿ� ����

		if ((k20_readtxt = k20_br.readLine()) == null) {	//�о�� �ؽ�Ʈ�� ��ĭ�̶��
			System.out.println("�� ���� �Դϴ�\n");	//���
			return;
		}

		String[] field_name = k20_readtxt.split("\t");	//�о�� ���ڿ��� ������ ������ �迭�� ����

		double k20_lat = 37.3860521;	//������ ������ �ʱ�ȭ
		double k20_lng = 127.1214038;	//������ ������ �ʱ�ȭ

		int k20_LineCnt = 1;	//���� ������ �ʱ�ȭ
		double k20_min = Double.MAX_VALUE;	//���� min�� ���� �ִ밪
		int k20_min_index = 0;	//�ּ� �ε����� 0���� �ʱ�ȭ
		String k20_min_parking = "";	//���ڿ� ����

		double k20_max = Double.MIN_VALUE;	//������ max�� ���� �ּҰ�
		int k20_max_index = 0;	//�ִ� �ε��� 0
		String k20_max_parking = "";	//���ڿ� ����

		while ((k20_readtxt =k20_br.readLine()) != null) {
			//�о�� �ؽ�Ʈ�� ��ĭ�� �ƴ϶��
			
			String[] k20_field = k20_readtxt.split("\t");	//���� ���� ������ ���� �迭�� ����
			System.out.printf("**[%d��° �׸�]********************************************\n", k20_LineCnt);
			System.out.printf(" %s : %s\n", field_name[5], k20_field[5]);
			System.out.printf(" %s : %s\n", field_name[28], k20_field[28]);
			System.out.printf(" %s : %s\n", field_name[29], k20_field[29]);
			//���
			double k20_dist = Math.sqrt(Math.pow(Double.parseDouble(k20_field[28]) - k20_lat, 2)
					+ Math.pow(Double.parseDouble(k20_field[29]) - k20_lng, 2));
			//�Ÿ��� ������ ��Ÿ��������� �ؼ� ���Ѵ�

			k20_min = Math.min(k20_min, k20_dist);	//�ּҰ��� ���Ѵ�
			if (k20_min == k20_dist) {
				k20_min_index = k20_LineCnt;
				k20_min_parking = k20_field[1];
			}
			k20_max = Math.max(k20_max, k20_dist);	//�ִ밪�� ���Ѵ�
			if (k20_max == k20_dist) {
				k20_max_index = k20_LineCnt;
				k20_max_parking = k20_field[1];
			}

			System.out.printf(" ���������� �Ÿ� : %f\n", k20_dist);	//���
			System.out.printf("************************************************************\n");
			k20_LineCnt++;	//���������� 1����
		}
		System.out.println();	//���
		System.out.printf("�ּҰŸ� : %f  %d�� %s\n", k20_min, k20_min_index, k20_min_parking);
		System.out.printf("�ִ�Ÿ� : %f  %d�� %s\n", k20_max, k20_max_index, k20_max_parking);
		k20_br.close();	//���� ����

	}

}
