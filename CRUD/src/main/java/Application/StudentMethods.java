package Application;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentMethods
{
	static Scanner sc = new Scanner(System.in);

	public static void start() throws SQLException
	{
		String studentInput = null;
		int input = 0;
		System.out.println("Enter StudentId : ");
		String StudentId = sc.nextLine();
		System.out.println("Enter Password : ");
		String StudentPassword = sc.nextLine();
		int noOfAttemtps = 1;
		boolean validateStudent = Validation.validStudent(StudentId, StudentPassword);
		
		while(!validateStudent && noOfAttemtps < 3)
		{
			System.out.println("Enter StudentId Again : ");
			StudentId = sc.nextLine();
			System.out.println("Enter Password Again : ");
			StudentPassword = sc.nextLine();
			noOfAttemtps++;
			 validateStudent = Validation.validStudent(StudentId, StudentPassword);

		}
		if(!validateStudent) {
			System.out.println("You have tried 3 Times, Plz Try To Remember!!!");
			return ;
		}
		while(true)
		{
			menu.printStudentMenu();
			studentInput = sc.nextLine();
			if(studentInput.trim().matches("[0-9]+") && Integer.parseInt(studentInput.trim()) > 0 && Integer.parseInt(studentInput.trim()) < 4)
			{
				input = Integer.parseInt(studentInput.trim());
				if(input == 1)
				{
					CONST.showStudentFullInfo(Integer.parseInt(StudentId.trim()));
				}
				else if(input == 2)
				{

					CONST.updateStudentSelf(UpdateStudentSelf(Integer.parseInt(StudentId.trim())));
				}
				else if(input == 3)
				{
					break;
				}

			}
			else
			{
				System.out.println("Enter Proper Choice");
			}
		}

	}

	public static Student UpdateStudentSelf(int id) throws SQLException
	{
		System.out.println("Enter New Name : ");
		String name = sc.nextLine();
		while(!Validation.validateName(name))
		{
			name = sc.nextLine();
		}

		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		while(!Validation.validatePassword(password))
		{
			password = sc.nextLine();
		}
		System.out.println("Enter New Email :  ");
		String email = sc.nextLine();
		while(!Validation.validateEmail(email))
		{
			email = sc.nextLine();
		}
		return new Student(id, name, password, email);
	}
}