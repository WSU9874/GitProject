package kr.ac.kopo.ctc.kopo20.domain;

public class WifiItem {
	private String id;
	private String installationLocationName;	//번호
	private String installationLocationDetails;	//설치장소명
	private String installationCityName;		//설치시도명
	private String installationDistrictName;	//설치시군구명
	private String installationFacilityType;	//설치시설구분
	private String serviceProviderName;			//서비스제공사명
	private String wifiSSID;						//와이파이SSID
	private String dateOfInstallation;			//설치연월
	private String roadNameAddress;				//소재지도로명주소
	private String lotNymberAddress;			//소재지지번주소
	private String managementAgencyName;		//관리기관명
	private String managementAgencyPhoneNumber;	//관리기관전화번호
	private String latitude;						//위도
	private String longitude;						//경도
	private String created;						//데이터기준일자
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInstallationLocationName() {
		return installationLocationName;
	}
	public void setInstallationLocationName(String installationLocationName) {
		this.installationLocationName = installationLocationName;
	}
	public String getInstallationLocationDetails() {
		return installationLocationDetails;
	}
	public void setInstallationLocationDetails(String installationLocationDetails) {
		this.installationLocationDetails = installationLocationDetails;
	}
	public String getInstallationCityName() {
		return installationCityName;
	}
	public void setInstallationCityName(String installationCityName) {
		this.installationCityName = installationCityName;
	}
	public String getInstallationDistrictName() {
		return installationDistrictName;
	}
	public void setInstallationDistrictName(String installationDistrictName) {
		this.installationDistrictName = installationDistrictName;
	}
	public String getInstallationFacilityType() {
		return installationFacilityType;
	}
	public void setInstallationFacilityType(String installationFacilityType) {
		this.installationFacilityType = installationFacilityType;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public String getWifiSSID() {
		return wifiSSID;
	}
	public void setWifiSSID(String wifiSSID) {
		this.wifiSSID = wifiSSID;
	}
	public String getDateOfInstallation() {
		return dateOfInstallation;
	}
	public void setDateOfInstallation(String dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	}
	public String getRoadNameAddress() {
		return roadNameAddress;
	}
	public void setRoadNameAddress(String roadNameAddress) {
		this.roadNameAddress = roadNameAddress;
	}
	public String getLotNymberAddress() {
		return lotNymberAddress;
	}
	public void setLotNymberAddress(String lotNymberAddress) {
		this.lotNymberAddress = lotNymberAddress;
	}
	public String getManagementAgencyName() {
		return managementAgencyName;
	}
	public void setManagementAgencyName(String managementAgencyName) {
		this.managementAgencyName = managementAgencyName;
	}
	public String getManagementAgencyPhoneNumber() {
		return managementAgencyPhoneNumber;
	}
	public void setManagementAgencyPhoneNumber(String managementAgencyPhoneNumber) {
		this.managementAgencyPhoneNumber = managementAgencyPhoneNumber;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	

	}
	

//Dao
//domain에 대한 access를 하게해줌
