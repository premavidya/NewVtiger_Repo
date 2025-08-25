package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	Connection con;
	public void getDBConnection() {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%","root");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
		
			result = stat.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		Statement stat;
		try {
			stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
				
	}
	
	public void closeDB()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
