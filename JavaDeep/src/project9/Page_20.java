package project9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Page_20 {

	public static void main(String[] args)
			throws FileNotFoundException, IOException, ParseException {	//����ó��

		JSONParser k20_parser = new JSONParser();	//��ü����

		Object k20_obj = k20_parser.parse(new FileReader("C:\\Users\\w\\Desktop\\test.json"));
		//���� ����
		// JSONObject jsonObject = (JSONObject) obj;
		JSONArray k20_array = (JSONArray) k20_obj;

		System.out.println("***************************************");
		for (int k20_i = 0; k20_i < k20_array.size(); k20_i++) { //��� ��ŭ �ݺ�
			JSONObject k20_result = (JSONObject) k20_array.get(k20_i);	//Array���� �ϳ��� ���´�
			System.out.println("�̸� : " + k20_result.get("name"));	//�̸������´�
			System.out.println("�й� : " + k20_result.get("studentid"));	//�й�������

			JSONArray k20_score = (JSONArray) k20_result.get("score");	//���������� �迭����
			long k20_kor = (long) k20_score.get(0);	//�迭�� ù������ ����
			long k20_eng = (long) k20_score.get(1);	//�迭�� �ι�°�� ����
			long k20_mat = (long) k20_score.get(2);	//�迭�� ����°�� ���� / json�� �迭�� 3���� �ƴϸ� ����
			System.out.println("���� : " + k20_kor);	//���
			System.out.println("���� : " + k20_eng);
			System.out.println("���� : " + k20_mat);
			System.out.println("���� : " + (k20_kor + k20_eng + k20_mat));
			System.out.println("��� : " + ((k20_kor + k20_eng + k20_mat) / 3.0));
			System.out.println("***********************************");
		}
	}
}
