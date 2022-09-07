package Application;

import java.sql.SQLException;
import java.util.Scanner;

public class TeacherMethods
{
	static Scanner sc = new Scanner(System.in);

	public static void start() throws SQLException
	{
		System.out.println("Enter TeacherId : ");
		String TeacherId = sc.nextLine();
		System.out.println("Enter Password : ");
		String TeacherPassword = sc.nextLine();
		while(!Validation.validTeacher(TeacherId, TeacherPassword))
		{
			System.out.println("Enter TeacherId Again : ");
			TeacherId = sc.nextLine();
			System.out.println("Enter Password Again : ");
			TeacherPassword = sc.nextLine();
		}
	}
}
