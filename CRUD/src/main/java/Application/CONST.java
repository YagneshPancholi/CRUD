package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CONST
{
	public static String			INSERTQUERY	= "insert into student(name,password,email,departmentid) values(?,?,?,?)";
	public static String			DELETEQUERY	= "delete from student where id =?";
	public static String			SELECTQUERY	= "select id,name,email,departmentid from student;";
	public static String			UPDATEQUERY	= "update student set password=?,email=?,departmentid=? where id=?";

	public static PreparedStatement	insertPstmt	= null;
	public static PreparedStatement	deletePstmt	= null;
	public static PreparedStatement	selectPstmt	= null;
	public static PreparedStatement	updatePstmt	= null;

	public CONST(Connection con) throws SQLException
	{

		insertPstmt = con.prepareStatement(INSERTQUERY);
		deletePstmt = con.prepareStatement(DELETEQUERY);
		selectPstmt = con.prepareStatement(SELECTQUERY);
		updatePstmt = con.prepareStatement(UPDATEQUERY);
	}

	public static void insertMethod(Student st) throws SQLException
	{
		insertPstmt.setString(1, st.getName());
		insertPstmt.setString(2, st.getPassword());
		insertPstmt.setString(3, st.getEmail());
		insertPstmt.setInt(4, st.getDeptid());

		int row = insertPstmt.executeUpdate();
		if(row > 0)
		{
			System.out.println("-----Successfully Added----- ");
		}
		else
		{
			System.out.println("-----Fail to ADD-----");
		}

	}

	public static void deleteMethod(int id) throws SQLException
	{
		deletePstmt.setInt(1, id);
		int row = deletePstmt.executeUpdate();
		if(row > 0)
		{
			System.out.println("-----Successfully Deleted-----");
		}
		else
		{
			System.out.println("-----Fail to Delete-----");

		}
	}

	public static void selectMethod() throws SQLException
	{
		ResultSet rs = selectPstmt.executeQuery();
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

	public static void updateMethod(Student st)
	{

	}

}
