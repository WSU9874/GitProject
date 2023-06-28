package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page10 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\THTSKS010H00.dat");	//�ֽ����� �����ϴ� ��ü
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));	//���� �д� ��ü

		File k20_f1 = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");	//������ csv���� ��ü
		BufferedWriter k20_bw1 = new BufferedWriter(new FileWriter(k20_f1));	//���� ���� ��ü

		String k20_readtxt;	//���� ����
		int k20_cnt = 0;
		int k20_wcnt = 0;

		while ((k20_readtxt = k20_br.readLine()) != null) {	//��ĭ���� �ݺ�
			StringBuffer k20_s = new StringBuffer();	//��ü ����
			String[] k20_field = k20_readtxt.split("%_%");	//�� ��ȣ�� �������� �߶� �迭�� ����
			if (k20_field.length > 2 && k20_field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
				k20_s.append(k20_field[0].replace("^", "").trim());	//���Ͽ� 0��° �׸��� �����ϰ� �߶� �̾����
				for (int k20_j = 1; k20_j < k20_field.length; k20_j++) {	
					k20_s.append("," + k20_field[k20_j].replace("^", "").trim());	
					//���Ͽ� j��° �׸��� �����ϰ� �߶� �̾����
				}
				k20_bw1.write(k20_s.toString());	//���� ����
				k20_bw1.newLine();	//�ٹٲ�
				k20_wcnt++;
				// System.out.printf("write [%d][%d][%s]\n", cnt,wcnt,s.toString());
			}
			k20_cnt++;
		}
		k20_br.close();	//���� �ݱ�
		k20_bw1.close();
		System.out.printf("Program End[%d][%d]records\n", k20_cnt, k20_wcnt);	//��� ���
	}
}
