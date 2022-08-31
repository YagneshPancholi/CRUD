package Application;

import java.util.Scanner;

public class menu
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
		String name = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		System.out.println("Enter Email :  ");
		String email = sc.nextLine();
		System.out.println("Enter Department Id");
		int deptid = sc.nextInt();
		Student st = new Student(name, password, email, deptid);
		return st;
	}

	public static Student method2()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID To which You want to  Update\n");
		int id = sc.nextInt();
		System.out.println("Enter New Password : ");
		String password = sc.next();
		System.out.println("Enter New Email :  ");
		String email = sc.next();
		System.out.println("Enter New Department Id");
		int deptid = sc.nextInt();
		Student st = new Student(id, password, email, deptid);
		return st;
	}

}
