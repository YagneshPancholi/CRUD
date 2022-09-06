package Application;

import java.sql.SQLException;
import java.util.Scanner;

public class menu extends Validation
{
	static Scanner sc = new Scanner(System.in);

	public static void printAdminMenu()
	{
		System.out.println("Enter Work Choice : ");
		System.out.println("\t\t1 : Student");
		System.out.println("\t\t2 : Teacher");
		System.out.println("\t\t3 : Exit");
	}

	public static void printHomePageMenu()
	{
		System.out.println("\t\tLogin As : ");
		System.out.println("\t\t1 : Student");
		System.out.println("\t\t2 : Teacher");
		System.out.println("\t\t3 : Admin");
		System.out.println("\t\t4 : Exit");
	}

	public static void printMenu()
	{
		System.out.println("\t\tChoose Option");
		System.out.println("\t\t1 : Add Student ");
		System.out.println("\t\t2 : Display Student");
		System.out.println("\t\t3 : Update Student");
		System.out.println("\t\t4 : Delete Student");
		System.out.println("\t\t5 :  Exit");
	}

	public static Student methodAdd()
	{
		System.out.println("Enter Name :  ");
		String name = sc.nextLine();
		while(!validateName(name))
		{
			name = sc.nextLine();
		}
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		while(!validatePassword(password))
		{
			password = sc.nextLine();
		}
		System.out.println("Enter Email :  ");
		String email = sc.nextLine();
		while(!validateEmail(email))
		{
			email = sc.nextLine();
		}
		System.out.println("Avaliable Department Ids : From 1 to 10 ");
		String temp = null;
		int deptid = 0;
		System.out.println("Enter Department Id");
		temp = sc.nextLine();

		while(!validateDeptId(temp))
		{
			temp = sc.nextLine();
		}
		deptid = Integer.parseInt(temp.trim());
		Student st = new Student(name, password, email, deptid);
		//sc.close();
		return st;
	}

	public static Student methodUpdateDeptId() throws SQLException
	{
		System.out.println("Enter Student ID To which You want to  Update\n");
		String temp = sc.nextLine();
		while(!validateStudentId(temp))
		{
			temp = sc.nextLine();
		}
		int id = Integer.parseInt(temp.trim());
		//System.out.println("Enter Password : ");
		//		String password = sc.nextLine();
		//		while(!validatePassword(password))
		//		{
		//			password = sc.nextLine();
		//		}
		//		System.out.println("Enter New Email :  ");
		//		String email = sc.nextLine();
		//		while(!validateEmail(email))
		//		{
		//			email = sc.nextLine();
		//		}
		System.out.println("Avaliable Department Ids : From 1 to 10 ");
		String temp1 = null;
		int deptid = 0;
		System.out.println("Enter Department Id");
		temp1 = sc.nextLine();
		while(!validateDeptId(temp1))
		{
			temp1 = sc.nextLine();
		}
		deptid = Integer.parseInt(temp1.trim());
		return new Student(id, deptid);

	}
}
