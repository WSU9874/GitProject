package kr.ac.kopo.ctc.kopo20.service;

import kr.ac.kopo.ctc.kopo20.domain.WifiItem;

public class WifiItemService {
	public Double getDistance(WifiItem wifiItem1,WifiItem wifiItem2) {
		
		double distance=Math.sqrt( Math.pow(Double.parseDouble(wifiItem1.getLatitude())-Double.parseDouble(wifiItem2.getLatitude()), 2)
				+ Math.pow(Double.parseDouble(wifiItem1.getLongitude())-Double.parseDouble(wifiItem2.getLongitude()), 2));
		
		return distance;
	}

}
