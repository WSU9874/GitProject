package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page11_3 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");
		//���� ���� ��ü ����
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//���� �б� ��ü ����
		File k20_f1 = new File("C:\\Users\\w\\Desktop\\day_data\\Samsung3.csv");
		//���� ����
		BufferedWriter k20_bw1 = new BufferedWriter(new FileWriter(k20_f1));
		//���� ���� ��ü ����

		String k20_readtxt;	//���� ����
		int k20_cnt = 0;
		int k20_wcnt = 0;
		int k20_min = Integer.MAX_VALUE;
		int k20_max = Integer.MIN_VALUE;

		while ((k20_readtxt = k20_br.readLine()) != null) {	//��ĭ���� �ݺ�
			StringBuffer k20_s = new StringBuffer();	//���� ��ü ����
			String[] k20_field = k20_readtxt.split(","); //�޸��� ���� �迭�� ����
			if (k20_field[2].equals("A005930") && k20_field[1].substring(0, 4).equals("2015")) {	
				//�迭�� �׸��� �̰��̶��
				if (Double.parseDouble(k20_field[3]) > k20_max) {	//�ִ밪�� �����Ѵ�
					k20_max = Integer.parseInt(k20_field[3]);
				}
				if (Double.parseDouble(k20_field[3]) < k20_min) {	//�ּҰ��� �����Ѵ�
					k20_min = Integer.parseInt(k20_field[3]);
				}
				k20_bw1.write(k20_s.toString());	//���� ���ǿ� ������ ���Ͽ� ���
				k20_bw1.newLine();
				k20_wcnt++;
			}
			k20_cnt++;
		}
		k20_br.close();	//���� �ݱ�
		k20_bw1.close();
		System.out.printf("Program End[%d][%d]records\n", k20_cnt, k20_wcnt);	//�ִ��ּҰ� ���
		System.out.println("2015�� �Ｚ���� �ֽ� �ְ� : " + k20_max + "��");
		System.out.println("2015�� �Ｚ���� �ֽ� ������ : " + k20_min + "��");
	}
}


