package kr.ac.kopo.ctc.kopo20;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo20.dao.WifiItemDao;
import kr.ac.kopo.ctc.kopo20.domain.WifiItem;
import kr.ac.kopo.ctc.kopo20.service.WifiItemService;

public class WifiMain {

	public static void main(String[] args) throws IOException {
		
		WifiItemDao k20_wifiItemDao = new WifiItemDao();	//객체 생성
		WifiItemService k20_wifiItemService = new WifiItemService();
		List<WifiItem> k20_wifiItems = k20_wifiItemDao.selectAll();
		WifiItem k20_me = new WifiItem();

		k20_me.setLatitude("37.3860521");	//위도, 경도값 객체 me에 set
		k20_me.setLongitude("127.1214038");
		
		int k20_i = 1;	//정수 선언
		
		double k20_min = Double.MAX_VALUE;	//최대값, 구하기위해 변수정의	
		int k20_min_index = 0;	
		String k20_min_location = "";
		double k20_max = Double.MIN_VALUE;	
		int k20_max_index = 0;	
		String k20_max_location = "";
		
		List<Double> k20_distanceList = new ArrayList<Double>();	//Arraylist 객체 생성
		for (WifiItem k20_target: k20_wifiItems) {	//wifiItems의 요소를 target에 저장
			double k20_d = k20_wifiItemService.getDistance(k20_me, k20_target);	
			//wifiItemService클래스에서 getDistance함수를 호출
			k20_distanceList.add(k20_d);	//결과값 d를 distanceList에 추가

			//출력
			System.out.printf("**[%d번째 항목]******************************************\n",k20_i);
			System.out.printf(" 소재지주소 : %s\n", k20_target.getRoadNameAddress());
			System.out.printf(" 위도 : %s\n", k20_target.getLatitude() );
			System.out.printf(" 경도 : %s\n",k20_target.getLongitude() );
			
			System.out.printf(" 현재지점과 거리 : %f\n", k20_d);
			System.out.printf("************************************************************\n");
			k20_i++;	//i 1추가
			
			k20_min = Math.min(k20_min, k20_d);		//최대, 최소거리, 인덱스, 주소 구함
			if (k20_min == k20_d) {
				k20_min_index = k20_i;
				k20_min_location = k20_target.getRoadNameAddress();
			}
			k20_max = Math.max(k20_max, k20_d);	
			if (k20_max == k20_d) {
				k20_max_index = k20_i;
				k20_max_location = k20_target.getRoadNameAddress();
			}
		}	//출력
		System.out.printf("최소거리 : %f / %d번째 / 위치: %s\n", k20_min, k20_min_index, k20_min_location);
		System.out.printf("최대거리 : %f / %d번째 / 위치: %s\n", k20_max, k20_max_index, k20_max_location);
	}
}
			