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
			throws FileNotFoundException, IOException, ParseException {	//예외처리

		JSONParser k20_parser = new JSONParser();	//객체생성

		Object k20_obj = k20_parser.parse(new FileReader("C:\\Users\\w\\Desktop\\test.json"));
		//파일 읽음
		// JSONObject jsonObject = (JSONObject) obj;
		JSONArray k20_array = (JSONArray) k20_obj;

		System.out.println("***************************************");
		for (int k20_i = 0; k20_i < k20_array.size(); k20_i++) { //어레이 만큼 반복
			JSONObject k20_result = (JSONObject) k20_array.get(k20_i);	//Array에서 하나를 뱨온다
			System.out.println("이름 : " + k20_result.get("name"));	//이름가져온다
			System.out.println("학번 : " + k20_result.get("studentid"));	//학번가져옴

			JSONArray k20_score = (JSONArray) k20_result.get("score");	//성적가져옴 배열형태
			long k20_kor = (long) k20_score.get(0);	//배열중 첫번쨰는 국어
			long k20_eng = (long) k20_score.get(1);	//배열중 두번째는 영어
			long k20_mat = (long) k20_score.get(2);	//배열중 세번째는 수학 / json의 배열이 3개가 아니면 에러
			System.out.println("국어 : " + k20_kor);	//출력
			System.out.println("영어 : " + k20_eng);
			System.out.println("수학 : " + k20_mat);
			System.out.println("총점 : " + (k20_kor + k20_eng + k20_mat));
			System.out.println("평균 : " + ((k20_kor + k20_eng + k20_mat) / 3.0));
			System.out.println("***********************************");
		}
	}
}
