package project8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Page11_2 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\StockDailyPrice.csv");
		//���� ���� ��ü ����
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		//���� �б� ��ü ����
		File k20_f1 = new File("C:\\Users\\w\\Desktop\\day_data\\Samsung2.csv");
		//���� ���� ��ü
		BufferedWriter k20_bw1 = new BufferedWriter(new FileWriter(k20_f1));
		//���� ���� ��ü ����

		String k20_readtxt;	//���� ����
		
		while ((k20_readtxt = k20_br.readLine()) != null) {	//���ٱ��� �ݺ�
			StringBuffer k20_s = new StringBuffer();	//���� ��ü ����
			String[] k20_field = k20_readtxt.split(",");	//�޸��� ������ �迭�� ����

			if (k20_field.length > 2) {	//field���̰� 2���� ũ�ٸ�
				k20_s.append(k20_field[0].trim());	//0��° �׸��� �̾����
				for (int k20_j = 1; k20_j < k20_field.length; k20_j++) {	//field�迭�� ���̸�ŭ �ݺ�
					k20_s.append("," + k20_field[k20_j].trim());	//�޸��� field�� j�׸��� �̾����
				}
				if (k20_field[1].equals("20150112")) {	//2��° �׸��� �̰��̸�
					k20_bw1.write(k20_s.toString());	//����Ѵ�
					k20_bw1.newLine();
				}
			}
		}
		k20_br.close();	//���� ����
		k20_bw1.close();
	}
}
