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
		System.out.println("\tWelcome To Student Management");
		Scanner sc = new Scanner(System.in);
		String choiceInput = null;
		int input1 = 0;
		while(true)
		{
			printHomePageMenu();
			choiceInput = sc.nextLine();

			if(choiceInput.trim().matches("[0-9]+") && Integer.parseInt(choiceInput.trim()) < 5 && Integer.parseInt(choiceInput.trim()) > 0)
			{
				input1 = Integer.parseInt(choiceInput.trim());
				if(input1 == 1)
				{
					StudentMethods.start();
				}
				else if(input1 == 2)
				{
					TeacherMethods.start();
				}
				else if(input1 == 3)
				{
					AdminMethods.start();
				}
				else if(input1 == 4)
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
