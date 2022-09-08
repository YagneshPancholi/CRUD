package Application;

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

	public static void printStudentMenu()
	{
		System.out.println("Enter Choice : ");
		System.out.println("\t\t1 : View Your Information ");
		System.out.println("\t\t2 : Update Your Information");
		System.out.println("\t\t3 : Exit");
	}

	public static void printTeacherMenu()
	{
		System.out.println("Enter Choice : ");
		System.out.println("\t\t1 : View Your Information");
		System.out.println("\t\t2 : Update Your Information");
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

	public static void printMenuForStudent()
	{
		System.out.println("\t\tChoose Option");
		System.out.println("\t\t1 : Add Student ");
		System.out.println("\t\t2 : Display Student");
		System.out.println("\t\t3 : Update Student");
		System.out.println("\t\t4 : Delete Student");
		System.out.println("\t\t5 :  Exit");
	}

	public static void printMenuForTeacher()
	{
		System.out.println("\t\tChoose Option");
		System.out.println("\t\t1 : Add Teacher ");
		System.out.println("\t\t2 : Display Teacher");
		System.out.println("\t\t3 : Update Teacher");
		System.out.println("\t\t4 : Delete Teacher");
		System.out.println("\t\t5 :  Exit");
	}

}
