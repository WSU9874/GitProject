package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Page8_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File k20_f = new File("C:\\Users\\w\\Desktop\\�������������������.txt");	//���� ��ü ����
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));	
		//���۸� �̿��� �����б� ��ü ����

		String k20_readtxt;	//���� ����

		if ((k20_readtxt = k20_br.readLine()) == null) { //��ĭ ������ ���
			System.out.println("�� ���� �Դϴ�\n");
		}

		String[] k20_field_name = k20_readtxt.split("\t");	//�Ǳ������� ������ �迭�� ����

		double k20_lat = 37.3860521;	//���� ����, �浵
		double k20_lng = 127.1214038;

		int k20_LineCnt = 1; // ���� ������ �ʱ�ȭ
		double k20_min = Double.MAX_VALUE; // ���� min�� ���� �ִ밪
		int k20_min_index = 0; // �ּ� �ε����� 0���� �ʱ�ȭ
		String k20_min_wifi = ""; // ���ڿ� ����

		double k20_max = Double.MIN_VALUE; // ������ max�� ���� �ּҰ�
		int k20_max_index = 0; // �ִ� �ε��� 0
		String k20_max_wifi = ""; // ���ڿ� ����

		while ((k20_readtxt = k20_br.readLine()) != null) {	//��ĭ���ö����� �ݺ�
			try {
				String[] k20_field = k20_readtxt.split("\t");	//������ ����
				System.out.printf("**[%d��° �׸�]********************************************\n", k20_LineCnt);
				System.out.printf(" %s : %s\n", k20_field_name[9], k20_field[9]); //�׸� ���
				System.out.printf(" %s : %s\n", k20_field_name[13], k20_field[13]);
				System.out.printf(" %s : %s\n", k20_field_name[14], k20_field[14]);
				double k20_dist = Math.sqrt(Math.pow(Double.parseDouble(k20_field[13]) - k20_lat, 2)
						+ Math.pow(Double.parseDouble(k20_field[14]) - k20_lng, 2));
				//��Ÿ��� ������ �׸��� ��ġ�� ����ġ ���� �浵�� �Ÿ� ���

				k20_min = Math.min(k20_min, k20_dist); // �ּҰ��� ���Ѵ�
				if (k20_min == k20_dist) {
					k20_min_index = k20_LineCnt;
					k20_min_wifi = k20_field[1];
				}
				k20_max = Math.max(k20_max, k20_dist); // �ִ밪�� ���Ѵ�
				if (k20_max == k20_dist) {
					k20_max_index = k20_LineCnt;
					k20_max_wifi = k20_field[1];
				}

				System.out.printf(" ���������� �Ÿ� : %f\n", k20_dist);	//���

				System.out.printf("************************************************************\n");

				k20_LineCnt++;
			} catch (Exception e) {	//�����߻��� �ٹٲ�
				System.out.println("");
			}
			System.out.println(); // ���

		}
		System.out.printf("�ּҰŸ� : %f  %d�� %s\n", k20_min, k20_min_index, k20_min_wifi);	//���
		System.out.printf("�ִ�Ÿ� : %f  %d�� %s\n", k20_max, k20_max_index, k20_max_wifi);
		k20_br.close();	//���� ����
	}

}
