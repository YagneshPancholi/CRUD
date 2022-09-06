package Application;

import java.sql.Connection;
import java.sql.ResultSet;
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
		String tempInput, choiceInput, adminInput = null;
		int input, input1, input2 = 0;
		while(true)
		{
			printHomePageMenu();
			choiceInput = sc.nextLine();

			if(choiceInput.trim().matches("[0-9]+") && Integer.parseInt(choiceInput.trim()) < 5 && Integer.parseInt(choiceInput.trim()) > 0)
			{
				input1 = Integer.parseInt(choiceInput.trim());
				if(input1 == 1)
				{

				}
				else if(input1 == 2)
				{

				}
				else if(input1 == 3)
				{

					System.out.println("Enter AdminId : ");
					String AdminId = sc.nextLine();
					System.out.println("Enter Password : ");
					String AdminPassword = sc.nextLine();
					while(!validAdmin(AdminId, AdminPassword))
					{
						System.out.println("Enter AdminId Again : ");
						AdminId = sc.nextLine();
						System.out.println("Enter Password Again : ");
						AdminPassword = sc.nextLine();
					}

					if(validAdmin(AdminId, AdminPassword))
					{
						while(true)
						{
							printAdminMenu();
							adminInput = sc.nextLine();
							if(adminInput.trim().matches("[0-9]+") && Integer.parseInt(adminInput.trim()) > 0 && Integer.parseInt(adminInput.trim()) < 4)
							{
								input2 = Integer.parseInt(adminInput.trim());
								if(input2 == 1)
								{
									while(true)
									{
										printMenu();
										tempInput = sc.nextLine();
										if(tempInput.trim().matches("[0-9]+") && Integer.parseInt(tempInput.trim()) < 6 && Integer.parseInt(tempInput.trim()) > 0)
										{
											input = Integer.parseInt(tempInput.trim());
											if(input == 1)
											{
												Student st = methodAdd();
												CONST.insertMethod(st);

											}
											else if(input == 2)
											{
												ResultSet rs = CONST.selectPstmt.executeQuery();

												if(rs.next())
												{
													CONST.selectMethod();
												}
												else
												{
													System.out.println("Databse is Empty");

												}

											}
											else if(input == 3)
											{
												ResultSet rs = CONST.selectPstmt.executeQuery();

												if(rs.next())
												{
													Student st = methodUpdateDeptId();
													CONST.updateMethod(st);
												}
												else
												{
													System.out.println("Databse is Empty");

												}
											}
											else if(input == 4)
											{
												ResultSet rs = CONST.selectPstmt.executeQuery();
												if(rs.next())
												{
													System.out.println("Enter student id to delete : ");
													String temp = sc.next();
													while(!validateStudentId(temp))
													{
														temp = sc.next();
													}
													int id = Integer.parseInt(temp.trim());
													CONST.deleteMethod(id);
												}
												else
												{
													System.out.println("Databse is Empty");
												}

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
								}
								else if(input2 == 2)
								{

								}
								else if(input2 == 3)
								{
									break;
								}
								else
								{
									System.out.println("Enter Correct Option : ");
								}
							}

						}

					}
					else
					{
						System.out.println("Wrong Admin Credentials");
					}

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
