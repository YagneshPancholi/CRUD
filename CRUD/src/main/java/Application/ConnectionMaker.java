package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMaker
{

	public static void main(String[] args)
	{
		String jdbcURL = "jdbc:mysql://localhost:3306/SampleDB";
		String userName = "root";
		String password = "P@ssw0rd@123";
		try
		{
			Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
			if(conn != null)
			{
				System.out.println("success");
			}
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
