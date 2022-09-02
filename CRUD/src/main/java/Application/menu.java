package Application;

import java.sql.SQLException;
import java.util.Scanner;

public class menu extends Validation
{

	public static void printMenu()
	{

		System.out.println("\t\tChoose Option");
		System.out.println("\t\t1 : Add Student ");
		System.out.println("\t\t2 : Update Student");
		System.out.println("\t\t3 : Display Student");
		System.out.println("\t\t4 : Delete Student");
		System.out.println("\t\t5 :  Exit");
	}

	public static Student method1()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name :  ");
		String name = sc.next();
		while(!validateName(name))
		{
			name = sc.nextLine();
		}

		System.out.println("Enter Password : ");
		String password = sc.next();
		while(!validatePassword(password))
		{
			password = sc.next();
		}
		System.out.println("Enter Email :  ");
		String email = sc.next();
		while(!validateEmail(email))
		{
			email = sc.next();
		}

		System.out.println("Avaliable Department Ids : From 1 to 10 ");
		String temp = null;
		int deptid = 0;
		System.out.println("Enter Department Id");
		temp = sc.next();

		while(!validateDeptId(temp))
		{
			temp = sc.next();
		}
		deptid = Integer.parseInt(temp);

		Student st = new Student(name, password, email, deptid);
		//sc.close();
		return st;
	}

	public static Student method2() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID To which You want to  Update\n");
		String temp = sc.next();
		while(!validateStudentId(temp))
		{
			temp = sc.next();
		}
		int id = Integer.parseInt(temp);

		System.out.println("Enter Password : ");
		String password = sc.next();
		while(!validatePassword(password))
		{
			password = sc.next();
		}
		System.out.println("Enter New Email :  ");
		String email = sc.next();
		while(!validateEmail(email))
		{
			email = sc.next();
		}

		System.out.println("Avaliable Department Ids : From 1 to 10 ");
		String temp1 = null;
		int deptid = 0;
		System.out.println("Enter Department Id");
		temp1 = sc.next();

		while(!validateDeptId(temp1))
		{
			temp1 = sc.next();
		}
		deptid = Integer.parseInt(temp1);

		Student st = new Student(id, password, email, deptid);

		return st;
	}

}
