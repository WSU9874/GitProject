package package1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P25_1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc ������ ���� driver ���� �ٸ���
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20", "root",
				"kopo1234");
		// ���� ����� �����ּ�, ��Ʈ�������� �ּ�, db�����, ��й�ȣ �Է� �� ����
		Statement k20_stmt = k20_conn.createStatement();
		// statement�� connection���� ������ ��ü���� �����۾��� �����ϱ� ���� ��ü�̴�.
		
		k20_stmt.execute(  "create table cctv(" + 
				"number    int not null primary key, " + 
				"manage_office    varchar(50), " + 
				"place_addr_road    varchar(200), " + 
				"place_addr_land    varchar(200), " + 
				"purpose    varchar(50), " +
				"camera_number    int,  " +
				"camera_pixel    int, " +
				"camera_info    varchar(100), " +
				"period    int, " +
				"inst_date    varchar(50), " + 
				"manage_office_phone    varchar(50), " + 
				"latitude    double, " + 
				"longitude    double, " + 
				"write_date    date);" 
				 );
		//resultset�� �����Ƿ� execute �Լ� ���
		//execute: ��� ������ SQL������ ����Ҽ� ������ �������� Boolean Ÿ���� ���� ��ȯ
		//create�� ���̺��� ����

		File k20_f = new File("C:\\Users\\w\\Desktop\\����cctvǥ�ص�����Refine.csv"); //���� ���� ��ü ����
		BufferedReader k20_br = new BufferedReader(new FileReader(k20_f)); //����ó���� ���� ���� ����
		
		String k20_readtxt;
		if((k20_readtxt = k20_br.readLine()) == null){ //�����̸� ���
			System.out.println("�� �����Դϴ�\n");
			return;
		}
		String[] k20_field_name = k20_readtxt.split(","); //�ʵ���� �޸��������� ���� �迭�� ����
		
		int k20_LineCnt = 0; //���� ����
		while((k20_readtxt = k20_br.readLine()) != null) {//������� ���涧 ���� ������ �ϳ��������� �ݺ�
			String[] k20_field = k20_readtxt.split(","); //������ �޸��� ���� �迭�� ����
			String k20_QueryTxt; //���� ����
			k20_QueryTxt = String.format("insert into cctv ("
					+ "number, manage_office, place_addr_road, place_addr_land, purpose,"
					+ "camera_number, camera_pixel, camera_info, period, inst_date,"
					+ "manage_office_phone, latitude, longitude, write_date)"
					+ "values("
					+ "'%s', '%s', '%s', '%s', '%s' ,"
					+ "'%s', '%s', '%s', '%s', '%s' ,"
					+ "'%s', '%s', '%s', '%s');", 
					k20_field[0], k20_field[1], k20_field[2], k20_field[3], k20_field[4], 
					k20_field[5], k20_field[6], k20_field[7], k20_field[8], k20_field[9], 
					k20_field[10], k20_field[11], k20_field[12], k20_field[13]);
			//�������� �ۼ�/�ʵ忡 ���� �־���
			k20_stmt.execute(k20_QueryTxt); //�������� �����Ŵ
			System.out.printf("%d��° �׸� Insert OK [%s]\n", k20_LineCnt, k20_QueryTxt);
			//�ٰ� �������� ���
			k20_LineCnt++;
		}
		k20_br.close(); //���� ����
		k20_stmt.close(); //stmt ����
		k20_conn.close(); //conn ����
	}
}
