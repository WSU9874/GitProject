package project8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Page5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { // ������ ������ ������ ����
			File kopo20_f = new File("C:\\Users\\w\\Mytest.txt");
			// ���� ��ü ����
			FileWriter kopo20_fw = new FileWriter(kopo20_f);
			// ������ ���� �뵵�� ��ü fw ����

			kopo20_fw.write("�ȳ� ����\n"); // fw�� �����Է�
			kopo20_fw.write("hello ���\n"); // fw�� �����Է�

			kopo20_fw.close(); // io�� �پ��� ����

			FileReader kopo20_fr = new FileReader(kopo20_f);
			// ������ �д� �뵵�� ��ü fr����

			int kopo20_n = -1; // ���� n�� -1�� �ʱ�ȭ
			char[] kopo20_ch; // ch�迭 ����

			while (true) { // ���ѹݺ�
				kopo20_ch = new char[100];  //ĳ���͸� 100������ �����ϴ� ��ü ����
				// heap�� ���� �����ؼ� ���� �ۿ����� ��밡��
				kopo20_n = kopo20_fr.read(kopo20_ch); // ch�� �д� ��ü fr�� ����n���� ����

				if (kopo20_n == -1)
					break; // ���� n�� -1�̸� �ݺ��� ����

				for (int kopo20_i = 0; kopo20_i < kopo20_n; kopo20_i++) {
					// ���� 1ȸ���� i�� 1������ n�� �ɶ����� �ݺ�

					// for(char c : ch) {
					System.out.printf("%c", kopo20_ch[kopo20_i]);
					// i��° ch�� ���
				}
			}

			kopo20_fr.close(); // fr�� io�� ����

			System.out.printf("\n FILE READ END"); // ���
		} catch (Exception e) { // ����������� ����
			System.out.printf("�� ����[%s]\n", e); // ���
		}
	}
}
