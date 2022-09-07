package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CONST
{
	public static String			INSERTSTUDENTTQUERY			= "insert into Student(name,password,email,departmentid) values(?,?,?,?)";
	public static String			DELETESTUDENTQUERY			= "delete from Student where id =?";
	public static String			SHOWSTUDENTQUERY			= "select id,name,email,departmentid from Student;";
	public static String			UPDATESTUDENTFROMADMINQUERY	= "update Student set departmentid=? where id=?";
	public static String			INSERTTEACHERQUERY			= "insert into Teacher(name,password,email,deptid,salary) values(?,?,?,?,?)";
	public static String			DELETETEACHERQUERY			= "delete from Teacher where tid=?";
	public static String			SHOWTEACHERQUERY			= "select tid,name,email,deptid,salary from Teacher";
	public static String			UPDATETEACHERFROMADMINQUERY	= "update Teacher set deptid=?,salary=?  where tid=?";

	public static String			SELECTADMINQUERY			= "select Adminid,Password from Admin;";
	public static String			SELECTSTUDENTQUERY			= "select id,Password from Student;";
	public static String			SELECTTEACHERQUERY			= "select TId,Password from Teacher;";

	public static PreparedStatement	insertStudentPstmt			= null;
	public static PreparedStatement	deleteStudentPstmt			= null;
	public static PreparedStatement	showStudentPstmt			= null;
	public static PreparedStatement	updateStudentPstmt			= null;
	public static PreparedStatement	insertTeacherPstmt			= null;
	public static PreparedStatement	deleteTeacherPstmt			= null;
	public static PreparedStatement	showTeacherPstmt			= null;
	public static PreparedStatement	updateTeacherPstmt			= null;

	public static PreparedStatement	selectAdminPstmt			= null;
	public static PreparedStatement	selectTeacherPstmt			= null;
	public static PreparedStatement	selectStudentPstmt			= null;

	public CONST(Connection con) throws SQLException
	{

		insertStudentPstmt = con.prepareStatement(INSERTSTUDENTTQUERY);
		deleteStudentPstmt = con.prepareStatement(DELETESTUDENTQUERY);
		showStudentPstmt = con.prepareStatement(SHOWSTUDENTQUERY);
		updateStudentPstmt = con.prepareStatement(UPDATESTUDENTFROMADMINQUERY);

		insertTeacherPstmt = con.prepareStatement(INSERTTEACHERQUERY);
		deleteTeacherPstmt = con.prepareStatement(DELETETEACHERQUERY);
		showTeacherPstmt = con.prepareStatement(SHOWTEACHERQUERY);
		updateTeacherPstmt = con.prepareStatement(UPDATETEACHERFROMADMINQUERY);

		selectAdminPstmt = con.prepareStatement(SELECTADMINQUERY);
		selectTeacherPstmt = con.prepareStatement(SELECTTEACHERQUERY);
		selectStudentPstmt = con.prepareStatement(SELECTSTUDENTQUERY);

	}

	//CRUD Student Start
	public static void insertStudent(Student st) throws SQLException
	{
		insertStudentPstmt.setString(1, st.getName());
		insertStudentPstmt.setString(2, st.getPassword());
		insertStudentPstmt.setString(3, st.getEmail());
		insertStudentPstmt.setInt(4, st.getDeptid());

		int row = insertStudentPstmt.executeUpdate();
		if(row > 0)
		{
			System.out.println("-----Successfully Added----- ");
		}
		else
		{
			System.out.println("-----Fail to ADD-----");
		}

	}

	public static void showStudent() throws SQLException
	{
		ResultSet rs = showStudentPstmt.executeQuery();
		System.out.print("ID\t");
		System.out.print("Name\t\t    ");
		System.out.print("Email\t\t     ");
		System.out.print("DepartmentID\n");

		while(rs.next())
		{
			System.out.printf("%-8s", rs.getString("id"));
			System.out.printf("%-20s", rs.getString("name"));
			System.out.printf("%-25s", rs.getString("email"));
			System.out.printf("%s", rs.getString("departmentid"));
			System.out.println();
		}
	}

	public static void updateStudent(Student st)
	{
		try
		{
			updateStudentPstmt.setInt(1, st.getDeptid());
			updateStudentPstmt.setInt(2, st.getId());
			int row = updateStudentPstmt.executeUpdate();
			if(row > 0)
			{
				System.out.println("-----Successfully Updated----- ");
			}
			else
			{
				System.out.println("-----Fail to Update-----");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void deleteStudent(int id) throws SQLException
	{
		deleteStudentPstmt.setInt(1, id);
		int row = deleteStudentPstmt.executeUpdate();
		if(row > 0)
		{
			System.out.println("-----Successfully Deleted-----");
		}
		else
		{
			System.out.println("-----Fail to Delete-----");

		}
	}
	//CRUD Student end

	//ID Password check
	public static ResultSet selectAdminMethod() throws SQLException
	{
		return selectAdminPstmt.executeQuery();
	}

	public static ResultSet selectStudentMethod() throws SQLException
	{
		return selectStudentPstmt.executeQuery();
	}

	public static ResultSet selectTeacherMethod() throws SQLException
	{
		return selectTeacherPstmt.executeQuery();
	}
	//ID Password check ends

	//CRUD Teacher start

	public static void insertTeacher(Teacher t) throws SQLException
	{
		insertTeacherPstmt.setString(1, t.getName());
		insertTeacherPstmt.setString(2, t.getPassword());
		insertTeacherPstmt.setString(3, t.getEmail());
		insertTeacherPstmt.setInt(4, t.getDeptid());
		insertTeacherPstmt.setInt(5, t.getSalary());

		int row = insertTeacherPstmt.executeUpdate();
		if(row > 0)
		{
			System.out.println("-----Successfully Added----- ");
		}
		else
		{
			System.out.println("-----Fail to ADD-----");
		}

	}

	public static void showTeacher() throws SQLException
	{
		ResultSet rs = showTeacherPstmt.executeQuery();
		System.out.print("Id\t");
		System.out.print("Name\t\t    ");
		System.out.print("Email\t\t     ");
		System.out.print("DepartmentID\t");
		System.out.print("Salary\n");

		while(rs.next())
		{
			System.out.printf("%-8s", rs.getString("tid"));
			System.out.printf("%-20s", rs.getString("name"));
			System.out.printf("%-25s", rs.getString("email"));
			System.out.printf("%-5s", rs.getString("deptid"));
			System.out.printf("%s", rs.getString("Salary"));
			System.out.println();
		}
	}

	public static void updateTeacher(Teacher t)
	{
		try
		{
			updateTeacherPstmt.setInt(1, t.getDeptid());
			updateTeacherPstmt.setInt(2, t.getSalary());
			updateTeacherPstmt.setInt(3, t.getTid());

			int row = updateTeacherPstmt.executeUpdate();
			if(row > 0)
			{
				System.out.println("-----Successfully Updated----- ");
			}
			else
			{
				System.out.println("-----Fail to Update-----");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void deleteTeacher(int id) throws SQLException
	{
		deleteTeacherPstmt.setInt(1, id);
		int row = deleteTeacherPstmt.executeUpdate();
		if(row > 0)
		{
			System.out.println("-----Successfully Deleted-----");
		}
		else
		{
			System.out.println("-----Fail to Delete-----");

		}
	}
	//CRUD Teacher ends
}
