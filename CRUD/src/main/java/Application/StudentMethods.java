package Application;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentMethods
{
	static Scanner sc = new Scanner(System.in);

	public static void start() throws SQLException
	{
		System.out.println("Enter StudentId : ");
		String StudentId = sc.nextLine();
		System.out.println("Enter Password : ");
		String StudentPassword = sc.nextLine();
		while(!Validation.validStudent(StudentId, StudentPassword))
		{
			System.out.println("Enter StudentId Again : ");
			StudentId = sc.nextLine();
			System.out.println("Enter Password Again : ");
			StudentPassword = sc.nextLine();

		}

	}
}