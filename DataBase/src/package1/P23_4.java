package package1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P23_4 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc ������ ���� driver ���� �ٸ���
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// ���� ����� �����ּ�, ��Ʈ�������� �ּ�, db�����, ��й�ȣ �Է� �� ����
		Statement k20_stmt = k20_conn.createStatement();
		// statement�� connection���� ������ ��ü���� �����۾��� �����ϱ� ���� ��ü�̴�.
		
		//���� �Է��� ���� File ��ü�� �����ϰ� ���� ��θ� �Է��Ѵ�.
		File k20_f = new File("C:\\Users\\w\\Desktop\\���������������ǥ�ص�����Refine.csv");
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f));
		
		String k20_readtxt; //������ ���پ� �б� ���� ���� ����
		
		if((k20_readtxt = k20_br.readLine()) == null){ //ù���� ��� ���
			System.out.println("�� �����Դϴ�\n");
			return;
		}
		String[] k20_field_name = k20_readtxt.split(",");
		//���� ������ �Ǹ� �������� �ʵ���� ������ �迭�� ����
		
		int k20_LineCnt = 0; //���� ���� ���� �����ϴ� ���� ����
		while((k20_readtxt = k20_br.readLine()) != null) { //������ null�� �ƴϸ� �ݺ�
			String[] k20_field = k20_readtxt.split(","); //���� �������� �ʵ尪�� ������ ����
			String k20_QueryTxt;
			
			k20_QueryTxt = String.format("insert into freewifi ("
					+ "inst_place, inst_place_detail, inst_city, inst_country, inst_place_flag,"
					+ "service_provider, wifi_ssid, inst_date, place_addr_road, place_addr_land,"
					+ "manage_office, manage_office_phone, latitude, longitude, write_date, number)"
					+ "values("
					+ "'%s', '%s', '%s', '%s', '%s' ,"
					+ "'%s', '%s', '%s', '%s', '%s' ,"
					+ "'%s', '%s', '%s', '%s', '%s' , '%s');", 
					k20_field[0], k20_field[1], k20_field[2], k20_field[3], k20_field[4], 
					k20_field[5], k20_field[6], k20_field[7], k20_field[8], k20_field[9], 
					k20_field[10], k20_field[11], k20_field[12], k20_field[13], k20_field[14], k20_field[15]);
			//�������� �ۼ�/�ʵ忡 ���� �־���
			k20_stmt.execute(k20_QueryTxt); //������ ����
			System.out.printf("%d��° �׸� Insert OK [%s]\n", k20_LineCnt, k20_QueryTxt);
			//�ٰ� �������� ���
			k20_LineCnt++;
		}
		k20_br.close(); //���� ����
		k20_stmt.close(); //stmt ����
		k20_conn.close(); //conn ����
	}
}

