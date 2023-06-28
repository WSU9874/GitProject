package kr.ac.kopo.ctc.kopo20.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo20.domain.WifiItem;

public class WifiItemDao {
	
	
	public WifiItem create(WifiItem wifiItem) {
		return null;
	}
	
	
	public WifiItem selectOne() {
		return null;
	}
	public List<WifiItem> selectAll() throws IOException{
		File f = new File("C:\\Users\\w\\Desktop\\PublicWifi8.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		
		List<WifiItem> wifi = new ArrayList<WifiItem>();

		String readtxt;

		readtxt = br.readLine();
		
		while ((readtxt = br.readLine()) != null) {
			WifiItem item = new WifiItem();
			String[] field = readtxt.split("\t");
			
			item.setId(field[0]);
			item.setInstallationLocationName(field[1]);
			item.setInstallationLocationDetails(field[2]);
			item.setInstallationCityName(field[3]);
			item.setInstallationDistrictName(field[4]);
			item.setInstallationFacilityType(field[5]);
			item.setServiceProviderName(field[6]);
			item.setWifiSSID(field[7]);
			item.setDateOfInstallation(field[8]);
			item.setRoadNameAddress(field[9]);
			item.setLotNymberAddress(field[10]);
			item.setManagementAgencyName(field[11]);
			item.setManagementAgencyPhoneNumber(field[12]);
			item.setLatitude(field[13]);
			item.setLongitude(field[14]);
			item.setCreated(field[15]);

			wifi.add(item);
			
			

		}
		
		return wifi;
	}
	
	public WifiItem update(int id, WifiItem wifiItem) {
		return null;
	}
	
	public WifiItem delete(int id) {
		return null;
	}

}
