package Application;

import java.sql.SQLException;
import java.util.Scanner;

public class TeacherMethods
{
	static Scanner sc = new Scanner(System.in);

	public static void start() throws SQLException
	{
		String teacherInput = null;
		int input = 0;
		System.out.println("Enter TeacherId : ");
		String TeacherId = sc.nextLine();
		System.out.println("Enter Password : ");
		String TeacherPassword = sc.nextLine();
		int noOfAttemtps = 1;
		boolean validateTeacher = Validation.validTeacher(TeacherId, TeacherPassword);
		
		while(!validateTeacher && noOfAttemtps < 3)
		{
			System.out.println("Enter TeacherId Again : ");
			TeacherId = sc.nextLine();
			System.out.println("Enter Password Again : ");
			TeacherPassword = sc.nextLine();
			noOfAttemtps++;
			validateTeacher = Validation.validTeacher(TeacherId, TeacherPassword);
			
		}
		if(!validateTeacher) {
			System.out.println("You have tried 3 Times, Plz Try To Remember!!!");
			return ;
		}
		while(true)
		{

			menu.printTeacherMenu();
			teacherInput = sc.nextLine();
			if(teacherInput.trim().matches("[0-9]+") && Integer.parseInt(teacherInput.trim()) > 0 && Integer.parseInt(teacherInput.trim()) < 4)
			{
				input = Integer.parseInt(teacherInput.trim());
				if(input == 1)
				{
					CONST.showTeacherFullInfo(Integer.parseInt(TeacherId.trim()));
				}
				else if(input == 2)
				{

					CONST.updateTeacherSelf(UpdateTeacherSelf(Integer.parseInt(TeacherId.trim())));
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

	public static Teacher UpdateTeacherSelf(int id)
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
		return new Teacher(id, name, password, email);
	}
}
