package project9;

import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Page_18 {

	@SuppressWarnings("unchecked")
	public static JSONObject k20_oneRec(String k20_name, int k20_studentid, int k20_kor, int k20_eng, int k20_mat) {
		// �޼��� ����
		JSONObject k20_dataObject = new JSONObject(); // jason��ü ����
		k20_dataObject.put("name", k20_name); // name�׸�� ���� �ִ´�
		k20_dataObject.put("studentid", k20_studentid); // id�׸�� ���� �ִ´�

		JSONArray k20_score = new JSONArray(); // jason��� ��ü�� ����
		k20_score.add(k20_kor); // kor���� �߰�
		k20_score.add(k20_eng); // eng���� �߰�
		k20_score.add(k20_mat); // mat���� �߰�
		k20_dataObject.put("score", k20_score); // score���� �߰�

		return k20_dataObject; // ���� ��ȯ
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JSONObject k20_jsonObject = new JSONObject(); // jsson��ü ��� ����

		JSONArray k20_datasArray = new JSONArray();

		JSONObject k20_dataObject = new JSONObject();
		k20_dataObject.put("name", "����"); // �̸��� id�� ����
		k20_dataObject.put("studentid", 209901);

		JSONArray k20_score = new JSONArray(); // ��ü ����
		k20_score.add(90); // ������ ���� 3���� �߰�
		k20_score.add(100);
		k20_score.add(95);
		k20_dataObject.put("score", k20_score); // score���� �߰�
		k20_datasArray.add(k20_dataObject); // ���� ��ü�� ��̷� ��� �߰�

		k20_datasArray.add(k20_oneRec("����", 209902, 100, 85, 75)); // �� �̸��� ���� id�� ��̷� �߰�
		k20_datasArray.add(k20_oneRec("���", 209903, 90, 65, 74));
		k20_datasArray.add(k20_oneRec("�糪", 209904, 90, 12, 23));
		k20_datasArray.add(k20_oneRec("��ȿ", 209905, 80, 98, 92));
		k20_datasArray.add(k20_oneRec("�̳�", 209906, 70, 56, 45));
		k20_datasArray.add(k20_oneRec("����", 209907, 40, 81, 12));
		k20_datasArray.add(k20_oneRec("ä��", 209908, 50, 56, 67));
		k20_datasArray.add(k20_oneRec("����", 209909, 70, 84, 65));
		try {
			FileWriter k20_file = new FileWriter("C:\\Users\\w\\Desktop\\test.json"); // jason������ ����
			k20_file.write(k20_datasArray.toJSONString()); // �׸� ���
			k20_file.flush();
			k20_file.close();
		} catch (IOException e) { // ���� ������ �˷���
			e.printStackTrace();
		}
		System.out.println("JSON ����� : " + k20_datasArray); // �������� ���
	}
}
