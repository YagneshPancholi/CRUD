package Application;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO
{

	static Connection conn = ConnectionMaker.createConnection();

	//	public static void insertToDb(Student st) throws SQLException
	//	{
	//		CONST const1 = new CONST(conn);
	//		const1.insertMethod(st);
	//
	//	}

	public static void deleteStudent(int id) throws SQLException
	{
		//CONST const1 = new CONST(conn);
		CONST.deleteMethod(id);
		//			Connection con = ConnectionMaker.createConnection();
		//
		//			//prepared stmt
		//			PreparedStatement pstmt = con.prepareStatement(DELETEQUERY);
		//			pstmt.setInt(1, id);
		//			pstmt.executeUpdate();
		//			f = true;

	}

	public static void showStudentDetails()

	{
		//		try
		//		{
		//			Connection con = ConnectionMaker.createConnection();
		//			Statement stmt = con.createStatement();
		//			ResultSet rs = stmt.executeQuery(SELECTQUERY);
		//
		//			System.out.print("ID\t");
		//			System.out.print("Name\t");
		//			System.out.print("Email\t\t");
		//			System.out.print("DepartmentID\n");
		//
		//			while(rs.next())
		//			{
		//				System.out.printf("%-8s", rs.getString("id"));
		//				System.out.printf("%-8s", rs.getString("name"));
		//				System.out.printf("%-17s", rs.getString("email"));
		//				System.out.printf("%s", rs.getString("departmentid"));
		//				System.out.println();
		//			}
		//
		//		}
		//		catch(Exception e)
		//		{
		//			e.printStackTrace();
		//		}
		//
	}

	public static boolean updateStudent(Student st)
	{
		boolean f = false;
		//		try
		//		{
		//			Connection con = ConnectionMaker.createConnection();
		//prepared stmt
		//			PreparedStatement pstmt = con.prepareStatement(UPDATEQUERY);
		//			pstmt.setString(1, st.getPassword());
		//			pstmt.setString(2, st.getEmail());
		//			pstmt.setInt(3, st.getDeptid());
		//			pstmt.setInt(4, st.getId());
		//			pstmt.executeUpdate();
		//			f = true;
		//}
		//		catch(Exception e)
		//		{
		//			e.printStackTrace();
		//		}
		return f;

	}

}
