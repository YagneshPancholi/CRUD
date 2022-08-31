package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO
{
	public static boolean insertToDb(Student st)
	{
		boolean f = false;
		//jdbc code
		try
		{
			Connection con = ConnectionMaker.createConnection();
			String q1 = "insert into student(name,password,email,departmentid) values(?,?,?,?)";
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(q1);
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
			String q1 = "delete from student where id =?";
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(q1);
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
		boolean f = false;
		try
		{
			Connection con = ConnectionMaker.createConnection();
			String q1 = "select id,name,email,departmentid from student;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q1);

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
			String q1 = "update student set password=?,email=?,departmentid=? where id=?";
			//prepared stmt
			PreparedStatement pstmt = con.prepareStatement(q1);
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
