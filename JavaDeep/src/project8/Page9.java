package project8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Page9 {

	public static void main(String[] args) throws IOException {
		File k20_f = new File("C:\\Users\\w\\Desktop\\day_data\\THTSKS010H00.dat"); // ���� ���� ��ü ����
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f)); // ���� �д� ��ü ����

		String k20_readtxt; // ���� ���� �� �ʱ�ȭ
		int k20_LineCnt = 0;
		int k20_n = -1;
		StringBuffer k20_s = new StringBuffer(); // ���� ��ü ����
		while (true) { // ���ѹݺ�
			char[] k20_ch = new char[1000]; // 1000�� ĭ�� char�迭 ����
			k20_n = k20_br.read(k20_ch); // ������ ������ ����
			if (k20_n == -1)
				break; // n�� -1�̸� �ߴ�
			for (char k20_c : k20_ch) { // ch�� c�� ����
				if (k20_c == '\n') { // c���� �ٹٲ��� ������
					System.out.printf("[%s***\n]", k20_s.toString()); // �ٷ�
					k20_s.delete(0, k20_s.length()); // ���ڿ��� �Ϻ� ����
				} else {
					k20_s.append(k20_c); // ���ڿ� �������� �߰�
				}
			}
			k20_LineCnt++;
		}
		System.out.printf("[%s]***\n", k20_s.toString()); // ���
		k20_br.close(); // ���� �ݱ�
	}
}
