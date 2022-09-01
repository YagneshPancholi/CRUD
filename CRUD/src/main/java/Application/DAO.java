package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO extends CONST
{

	public static boolean insertToDb(Student st)
	{
		boolean f = false;
		//jdbc code
		try
		{
			Connection con = ConnectionMaker.createConnection();
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(INSERTQUERY);
			pstmt.setString(1, st.getName());
			pstmt.setString(2, st.getPassword());
			pstmt.setString(3, st.getEmail());
			pstmt.setInt(4, st.getDeptid());
			pstmt.executeUpdate();
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int id)
	{
		boolean f = false;
		try
		{
			Connection con = ConnectionMaker.createConnection();

			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(DELETEQUERY);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			f = true;
		}
		catch(

		Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

	public static void showStudentDetails()

	{
		try
		{
			Connection con = ConnectionMaker.createConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTQUERY);

			System.out.print("ID\t");
			System.out.print("Name\t");
			System.out.print("Email\t\t");
			System.out.print("DepartmentID\n");

			while(rs.next())
			{
				System.out.printf("%-8s", rs.getString("id"));
				System.out.printf("%-8s", rs.getString("name"));
				System.out.printf("%-17s", rs.getString("email"));
				System.out.printf("%s", rs.getString("departmentid"));
				System.out.println();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static boolean updateStudent(Student st)
	{
		boolean f = false;
		try
		{
			Connection con = ConnectionMaker.createConnection();
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(UPDATEQUERY);
			pstmt.setString(1, st.getPassword());
			pstmt.setString(2, st.getEmail());
			pstmt.setInt(3, st.getDeptid());
			pstmt.setInt(4, st.getId());
			pstmt.executeUpdate();
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;

	}

}
