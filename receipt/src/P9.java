import java.text.NumberFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class P9 {

	public static void main(String[] args) {
		NumberFormat k20_df = NumberFormat.getNumberInstance(); // 3�ڸ� ���� �޸���� Ŭ���� ����
		Calendar k20_calt = Calendar.getInstance();
		// Ķ���� Ŭ������ �ҷ��´�
		SimpleDateFormat k20_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm"); // Ķ���� ���� ����
		SimpleDateFormat k20_sdt2 = new SimpleDateFormat("YYYYMMdd"); // Ķ���� ���� ����
		SimpleDateFormat k20_sdt3 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // Ķ���� ���� ����
		// simpledateformatŬ������ ��¥ ������ ���Ѵ�

		String[] k20_itemname = { "���� Ȩ SAFE365 �ڵ����", "����� ������� ����", "���μ���", "�����Ǫ ƾ���̽�", "MJ������ũ", "���ڸ�", "��������ƼĿ",
				"������", "���̽�Ʈ����20��", "������", "�ް�", "��������ȭ������", "������Ź��", "����", "���÷�30cm", "A4����", "�丶��", "���̾��Ƽ����",
				"������", "�����ǽ� ��Ų", "����", "��Ǫ�ν�Ʈ ������", "����ī��������25p", "���Դ� ����Ĩ", "���簻", "������", "�����尩", "�Ҹ���",
				"����� ����ŷ ������", "��īĨ" };
		// ���ڿ� �迭 ������ ���� ����

		int[] k20_price = { 2000, 2500, 3300, 2500, 100, 50, 600, 800, 1000, 900, 400, 500, 1000, 2000, 5000, 2000,
				3000, 4000, 5000, 6000, 7000, 8000, 7000, 8000, 6000, 2000, 1000, 3000, 4000, 6000 };
		// ���� �迭 ������ ���ڳ���
		int[] k20_num = { 2, 4, 1, 1, 10, 5, 6, 4, 2, 6, 1, 2, 6, 4, 5, 4, 1, 2, 3, 4, 3, 4, 5, 1, 8, 6, 4, 1, 2, 5 };
		// ���� �迭 ������ ���ڳ���
		int k20_sum = 0;
		// �������� ������ 0���� �ʱ�ȭ
		int k20_taxFreeSum = 0;
		// �������� ������ 0���� �ʱ�ȭ

		for (int k20_i = 0; k20_i < k20_num.length; k20_i++) { // i�� 0���� num�� ���̸�ŭ �ݺ� i�� 1������
			k20_sum = k20_sum + k20_num[k20_i]; // i��° num�迭 ����
		}

		boolean[] k20_taxfree = { false, false, false, false, false, false, true, false, true, true, true, true, false,
				false, false, false, false, false, false, true, false, false, false, false, true, false, false, false,
				false, true };
		// �Ҹ��� �迭 ������ �� �Է�

		int k20_iPrice = 0; // �������� ������ 0���� �ʱ�ȭ

		System.out.printf("emart         �̸�Ʈ ������(031)888-1234\n"); // �������
		System.out.printf("              206-86-50913 ����\n"); // �������
		System.out.printf("              ���� ������ ������� 552\n"); // �������
		System.out.println(); // �ٹٲ�
		System.out.printf("������ �������� ��ȯ/ȯ�� �Ұ�\n"); // �������
		System.out.printf("�����ǰ�� ����, 30�� �̳�(�ż� 7��)\n"); // �������
		System.out.printf("���Ϻ� �귣����� ����(���� ����������)\n"); // �������
		System.out.printf("��ȯ/ȯ�� ���������� ����(����ī�� ����)\n"); // �������
		System.out.printf("\n");// �ٹٲ�
		System.out.printf("[�� ��]%s     POS:0011-9861\n", k20_sdt.format(k20_calt.getTime()));
		// ��������� sdt�� ��¥ ���
		System.out.printf("-----------------------------------------\n"); // �����
		System.out.printf("  �� ǰ ��         ��  ��  ����    ��  ��\n"); // �������
		System.out.printf("-----------------------------------------\n"); // �����

		for (int k20_i = 0; k20_i < k20_itemname.length; k20_i++) { // i�� 0���� itemname�� ���̸�ŭ �ݺ� i�� 1������

			String k20_aa = k20_itemname[k20_i]; // ���ڿ� aa�� �迭itemname�� i��°
			k20_aa = k20_aa + "                         "; // aa�� �ڿ� �����߰�
			byte[] k20_bb = k20_aa.getBytes(); // ���ڿ� aa�� ����Ʈ�� ��ȯ
			k20_aa = new String(k20_bb, 0, 14); // ���� ����Ʈ�迭�� 14����Ʈ�� �ڸ�

			int k20_cnt = 0; // ���� cnt�� �ʱ�ȭ

			for (int k20_j = 0; k20_j < 14; k20_j++) { // j�� 0���� 13���� �ݺ� j�� �������� 1�� ����
				if (k20_bb[k20_j] < 0) { // ���� j��° ����Ʈ�迭�� 0���� ������
					k20_cnt++; // cnt�� 1������Ų�� -> �ѱ��� ����
				}
			}
			if (k20_cnt % 2 == 1) { // ���� cnt�� 2�� �������� �������� 1�̸�
				if (k20_bb[13] < 0) { // ���� 18��° ����Ʈ�迭�� 0����������
					k20_aa = new String(k20_bb, 0, 13) + " "; // 18��°�� �����߰�
				} else { // �װԾƴϸ� �׳� ���
					k20_aa = new String(k20_bb, 0, 13);

				}
			}

			if (k20_taxfree[k20_i] == true) { // i��° �Ҹ��Ȱ��� Ʈ���
				System.out.print("* "); // �����
			} else { // �ƴϸ� �������
				System.out.print("  ");
			}

			System.out.printf("%s%11s%3s%11s\n", k20_aa, k20_df.format(k20_price[k20_i]), k20_df.format(k20_num[k20_i]),
					k20_df.format((k20_price[k20_i] * k20_num[k20_i]))); // �������
			k20_iPrice = k20_iPrice + (k20_price[k20_i] * k20_num[k20_i]);

			if (k20_taxfree[k20_i] == true) {
				k20_taxFreeSum = k20_taxFreeSum + (k20_price[k20_i] * k20_num[k20_i]); ////////// �鼼�ݾ״���
			}

			if (k20_i % 5 == 4) { // ���� �������� �������� 4�̸�
				System.out.printf("-----------------------------------------\n"); // �����
			}
		}
		// ������ �÷��޾ƾ���
		// ���� = ���ıݾ� - �����ݾ�(����)
		double k20_tax = 0.1;
		int k20_priceTotal = (int) ((k20_iPrice - k20_taxFreeSum) / (1 + k20_tax));// ������ǰ = (�Ѱ���-�鼼) / 1+0.1

		System.out.println();
		System.out.printf("               �� ǰ�� ����           %3d\n", k20_itemname.length); // �������
		System.out.printf("            (*)�� ��  �� ǰ   %11s\n", k20_df.format(k20_taxFreeSum)); // �������
		System.out.printf("               �� ��  �� ǰ   %11s\n", k20_df.format(k20_priceTotal)); // �������
		System.out.printf("               ��   ��   ��   %11s\n",
				k20_df.format(k20_iPrice - k20_priceTotal - k20_taxFreeSum));
		// �ΰ��� =���հ� -����-�鼼
		System.out.printf("               ��        ��   %11s\n", k20_df.format(k20_iPrice)); // �������
		System.out.printf("�� �� �� �� �� ��             %11s\n", k20_df.format(k20_iPrice)); // �������
		System.out.printf("-----------------------------------------\n"); // �����
		System.out.printf("0012 KEB �ϳ�       541707**0484/35860658\n"); // �������
		System.out.printf("ī�����(IC)          �Ͻú� / %10s \n", k20_df.format(k20_iPrice)); // �������
		System.out.printf("-----------------------------------------\n");// �����
		System.out.printf("           [�ż�������Ʈ ����]\n"); // �������
		System.out.printf("ȫ*�� ������ ����Ʈ ��Ȳ�Դϴ�.\n"); // �������
		int point = (int) (k20_iPrice * 0.001); // ������ ���������� point�� �ѱݾ��� 0.001�����
		System.out.printf("��ȸ�߻�����Ʈ      9350**9995    %7s\n", k20_df.format(point)); // �������
		System.out.printf("����(����)����Ʈ     %8s(%10s)\n", k20_df.format(5473 + point), k20_df.format(5473));
		// ���� ����Ʈ���� ���� ���� ����Ʈ�� �߰��� ���
		System.out.printf("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.\n"); // �������
		System.out.printf("-----------------------------------------\n");// �����
		System.out.printf("    ���űݾױ��� ���������ð� �ڵ��ο�\n"); // �������
		System.out.printf("������ȣ :                       34��****\n");// �����
		k20_calt.add(Calendar.HOUR_OF_DAY, -2);
		// ���� ��¥���� 2�ð������� ����
		System.out.printf("�����ð� :            %s\n", k20_sdt3.format(k20_calt.getTime()));
		// ����� ��¥ ���
		System.out.printf("-----------------------------------------\n"); // �����
		System.out.printf("ĳ��:084599 ��00                     1150\n"); // �������
		System.out.printf("       %s/00119861/00164980/31\n", k20_sdt2.format(k20_calt.getTime()));
		// ��������� sdt2��¥ ���

	}

}
