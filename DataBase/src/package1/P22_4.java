package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P22_4 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20",
	    												"root" , "kopo1234");
		Statement stmt = conn.createStatement();
		
		stmt.execute(  "create table freewifi(" + 
				"inst_place        varchar(50), " + 
				"inst_place_detail varchar(200), " + 
				"inst_city         varchar(50), " + 
				"inst_country         varchar(50),  " + 
				"inst_place_flag        varchar(50), " +
				"service_provider  varchar(50), " + 
				"wifi_ssid    varchar(100), " + 
				"inst_date    varchar(50), " + 
				"place_addr_road    varchar(200), " + 
				"place_addr_land    varchar(200), " + 
				"manage_office    varchar(50), " + 
				"manage_office_phone    varchar(50), " + 
				"latitude    double, " + 
				"longitude    double, " + 
				"write_date    date, " + 
				"number    int not null primary key); " );
		stmt.close();
		conn.close();
	}
}
