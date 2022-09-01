package Application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App extends menu
{
	static Connection conn = ConnectionMaker.createConnection();

	public static void main(String[] args) throws SQLException
	{
		new CONST(conn);
		System.out.println("--------------------------------------------");
		System.out.println("\twelcome To Student Management");
		Scanner sc = new Scanner(System.in);
		String tempInput = null;
		int input = 0;
		while(true)
		{
			printMenu();
			tempInput = sc.next();

			if(tempInput.matches("[0-9]+") && Integer.parseInt(tempInput) < 6 && Integer.parseInt(tempInput) > 0)
			{
				input = Integer.parseInt(tempInput);
				if(input == 1)
				{
					Student st = method1();
					//DAO.insertToDb(st);
					CONST.insertMethod(st);

				}
				else if(input == 2)
				{

					Student st = method2();
					//					 DAO.updateStudent(st);
					CONST.updateMethod(st);

				}
				else if(input == 3)
				{
					//DAO.showStudentDetails();
					CONST.selectMethod();
				}
				else if(input == 4)
				{
					System.out.println("Enter student id to delete : ");
					String temp = sc.next();
					while(!validateStudentId(temp))
					{
						temp = sc.next();
					}
					int id = Integer.parseInt(temp);
					CONST.deleteMethod(id);

				}
				else if(input == 5)
				{
					break;
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
