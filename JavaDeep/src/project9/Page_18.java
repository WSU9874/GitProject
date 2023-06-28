package project9;

import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Page_18 {

	@SuppressWarnings("unchecked")
	public static JSONObject k20_oneRec(String k20_name, int k20_studentid, int k20_kor, int k20_eng, int k20_mat) {
		// 메서드 생성
		JSONObject k20_dataObject = new JSONObject(); // jason객체 생성
		k20_dataObject.put("name", k20_name); // name항목과 값을 넣는다
		k20_dataObject.put("studentid", k20_studentid); // id항목과 값을 넣는다

		JSONArray k20_score = new JSONArray(); // jason어레이 객체를 만듬
		k20_score.add(k20_kor); // kor값을 추가
		k20_score.add(k20_eng); // eng값을 추가
		k20_score.add(k20_mat); // mat값을 추가
		k20_dataObject.put("score", k20_score); // score값을 추가

		return k20_dataObject; // 값을 반환
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JSONObject k20_jsonObject = new JSONObject(); // jsson객체 어레이 생성

		JSONArray k20_datasArray = new JSONArray();

		JSONObject k20_dataObject = new JSONObject();
		k20_dataObject.put("name", "나연"); // 이름과 id를 넣음
		k20_dataObject.put("studentid", 209901);

		JSONArray k20_score = new JSONArray(); // 객체 생성
		k20_score.add(90); // 나연에 점수 3가지 추가
		k20_score.add(100);
		k20_score.add(95);
		k20_dataObject.put("score", k20_score); // score글자 추가
		k20_datasArray.add(k20_dataObject); // 위의 객체를 어레이로 계속 추가

		k20_datasArray.add(k20_oneRec("정연", 209902, 100, 85, 75)); // 각 이름과 점수 id를 어레이로 추가
		k20_datasArray.add(k20_oneRec("모모", 209903, 90, 65, 74));
		k20_datasArray.add(k20_oneRec("사나", 209904, 90, 12, 23));
		k20_datasArray.add(k20_oneRec("지효", 209905, 80, 98, 92));
		k20_datasArray.add(k20_oneRec("미나", 209906, 70, 56, 45));
		k20_datasArray.add(k20_oneRec("다현", 209907, 40, 81, 12));
		k20_datasArray.add(k20_oneRec("채영", 209908, 50, 56, 67));
		k20_datasArray.add(k20_oneRec("쯔위", 209909, 70, 84, 65));
		try {
			FileWriter k20_file = new FileWriter("C:\\Users\\w\\Desktop\\test.json"); // jason파일을 쓰기
			k20_file.write(k20_datasArray.toJSONString()); // 항목 기록
			k20_file.flush();
			k20_file.close();
		} catch (IOException e) { // 예외 있으면 알려줌
			e.printStackTrace();
		}
		System.out.println("JSON 만든거 : " + k20_datasArray); // 만든파일 출력
	}
}
