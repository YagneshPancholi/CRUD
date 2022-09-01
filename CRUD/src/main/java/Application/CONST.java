package Application;

public class CONST
{
	public static String	INSERTQUERY	= "insert into student(name,password,email,departmentid) values(?,?,?,?)";
	public static String	DELETEQUERY	= "delete from student where id =?";
	public static String	SELECTQUERY	= "select id,name,email,departmentid from student;";
	public static String	UPDATEQUERY	= "update student set password=?,email=?,departmentid=? where id=?";

}
