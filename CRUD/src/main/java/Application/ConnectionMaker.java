package Application;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMaker
{
	static Connection conn;

	public static Connection createConnection()
	{
		if(conn == null)
		{
			try
			{
				String jdbcURL = "jdbc:mysql://localhost:3306/SampleDB";
				String userName = "root";
				String password = "P@ssw0rd@123";
				conn = DriverManager.getConnection(jdbcURL, userName, password);

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return conn;

		}
		else
		{
			return conn;

		}

	}

}
