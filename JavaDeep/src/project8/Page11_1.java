package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page11_1 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");
		//���� ���� ��ü ����
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//���� �б� ��ü ����

		File k20_f1 = new File("C:\\Users\\w\\Desktop\\day_data\\Samsung1.csv");
		//���� ���� ��ü ����
		BufferedWriter k20_bw1 = new BufferedWriter(new FileWriter(k20_f1));
		//���� ���� ��ü ����

		String k20_readtxt;	//���� ����

		while ((k20_readtxt = k20_br.readLine()) != null) {	//���ٱ��� �ݺ�����
			StringBuffer k20_s = new StringBuffer();	//���� ��ü ����
			String[] k20_field = k20_readtxt.split(",");	//�޸��� �������� ������ �迭�� ����

			if (k20_field.length > 2) {	//�׸��� ���̰� 2���� ���� ���
				k20_s.append(k20_field[0].trim());	//0��° �׸��� �߶� �̾����
				for (int k20_j = 1; k20_j < k20_field.length; k20_j++) {	//fiedld�� �׸񰳼���ŭ �ݺ�
					k20_s.append("," + k20_field[k20_j].trim());	//�޸��� j��° �׸��� �پ�
				}
				if (k20_field[2].equals("A005930")) {	//3��° ��Ұ� �̰��̶��
					}
					k20_bw1.write(k20_s.toString());	//�� �׸��� �迭�� ����Ѵ�
					k20_bw1.newLine();
				}
		}
		k20_br.close();	//���� ����
		k20_bw1.close();
	}
}
