package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import genericUtility.DatabaseUtility;

public class ConnectToDB {

	@Test
	public void connectToDB() throws SQLException
	{
		DatabaseUtility db = new DatabaseUtility();
		db.getDBConnection();
		ResultSet result = db.executeSelectQuery("select * from project");
		
		while(result.next())
		{
			System.out.println(result.getString(1));
		}
	}
}
