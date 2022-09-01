package Application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Validation
{

	public static boolean validateName(String name)
	{
		boolean ans = false;
		if(name.matches("[A-Za-z ]+"))
		{
			ans = true;
		}
		else
		{
			System.out.println("Wrong Name Format");

		}
		return ans;
	}

	public static boolean validateEmail(String email)
	{
		boolean ans = false;
		if(email.matches("[a-z0-9._]+@[a-z]+\\.[a-z]{2,3}(\\.[a-z]{2,3})?"))
		{
			ans = true;
		}
		else
		{
			System.out.println("Wrong Email Format");

		}
		return ans;
	}

	public static boolean validateDeptId(String temp)

	{
		boolean ans = false;
		if(temp.matches("[0-9]+"))
		{
			int id = Integer.parseInt(temp);
			if(id >= 1 && id <= 10)
			{
				ans = true;
			}
			else
			{
				System.out.println("please Choose From Given Range");
			}
		}

		else
		{
			System.out.println("Wrong Department id");
		}
		return ans;
	}

	public static boolean validatePassword(String temp)
	{
		boolean ans = false;
		if(temp != null && temp.length() > 4)
		{
			ans = true;
		}
		else
		{
			System.out.println("Password should be atleast 5 character long");
		}
		return ans;
	}

	public static boolean validateStudentId(String temp) throws SQLException
	{
		boolean ans = false;

		Scanner sc = new Scanner(System.in);
		try
		{
			ResultSet rs = CONST.selectPstmt.executeQuery();
			while(rs.next())
			{
				int avaid = Integer.parseInt(rs.getString("id"));
				if(temp.matches("[0-9]+"))
				{
					int id = Integer.parseInt(temp);
					if(avaid == id)
					{
						ans = true;
					}
					//					else
					//					{
					//						System.out.println("Enter Correct Id");
					//
					//					}

				}
				else
				{
					//System.out.println("Enter Correct Id");
					break;
				}
				if(ans)
				{
					break;
				}
			}
			if(!ans)
			{
				System.out.println("ID not avaliable");
				System.out.println("Enter Correct Id");
			}
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	}
}