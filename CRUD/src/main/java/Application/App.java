package Application;

import java.util.Scanner;

public class App extends menu
{

	public static void main(String[] args)
	{
		System.out.println("--------------------------------------------");
		System.out.println("\twelcome To Student Management");
		Scanner sc = new Scanner(System.in);
		String tempInput = null;
		int input = 0;
		while(true)
		{
			printMenu();
			tempInput = sc.nextLine();
			if(tempInput.matches("[0-9]*") && Integer.parseInt(tempInput) < 6 && Integer.parseInt(tempInput) > 0)
			{
				input = Integer.parseInt(tempInput);
				if(input == 1)
				{
					Student st = method1();
					boolean ans = DAO.insertToDb(st);
					if(ans)
					{
						System.out.println("Successfully added");
					}
					else
					{
						System.out.println("Something went wrong");
					}
				}
				else if(input == 2)
				{

					Student st = method2();
					boolean ans1 = DAO.updateStudent(st);
					if(ans1)
					{
						System.out.println("Successfully Updated");
					}
					else
					{
						System.out.println("Something went wrong");
					}
				}
				else if(input == 3)
				{
					DAO.showStudentDetails();
				}
				else if(input == 4)
				{
					System.out.println("Enter student id to delete : ");
					int id = sc.nextInt();
					boolean ans = DAO.deleteStudent(id);
					if(ans)
					{
						System.out.println("Successfully Deleted");
					}
					else
					{
						System.out.println("Something went wrong");
					}

				}
				else if(input == 5)
				{
					break;
				}
				else
				{
					System.out.println("Wrong Options\n Choose Correct");
				}

			}
			else
			{
				System.out.println("Please Enter Correct Options");
			}

		}
		sc.close();
		System.out.println("\t\tThank You ");
		System.out.println("--------------------------------------------");

	}

}
