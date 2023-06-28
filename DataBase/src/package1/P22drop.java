package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P22drop {

	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection k20_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.69:33060/kopo20",
	    												"root" , "kopo1234");
		Statement k20_stmt = k20_conn.createStatement();
		
		k20_stmt.execute("drop table freewifi");
		
		k20_stmt.close();
		k20_conn.close();
	}
}


