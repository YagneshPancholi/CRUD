package Application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Validation
{
	static Scanner sc = new Scanner(System.in);

	public static boolean validateName(String name)
	{
		boolean ans = false;
		if(name.trim().matches("[A-Za-z ]+"))
		{
			ans = true;
		}
		else
		{
			System.out.println("Wrong Name Format");
			System.out.println("Enter Name Again : ");
		}
		return ans;
	}

	public static boolean validateEmail(String email)
	{
		boolean ans = false;
		if(email.trim().matches("[a-z0-9._]+@[a-z]+\\.[a-z]{2,3}(\\.[a-z]{2,3})?"))
		{
			ans = true;
		}
		else
		{
			System.out.println("Wrong Email Format");
			System.out.println("Enter Email Again :  ");

		}
		return ans;
	}

	public static boolean validateDeptId(String temp)

	{
		boolean ans = false;
		if(temp.trim().matches("[0-9]+"))
		{
			int id = Integer.parseInt(temp.trim());
			if(id >= 1 && id <= 10)
			{
				ans = true;
			}
			else
			{
				System.out.println("please Choose From Given Range");
				System.out.println("Enter DeptId Again : ");
			}
		}
		else
		{
			System.out.println("Wrong Department id");
			System.out.println("Enter DeptId Again : ");
		}
		return ans;
	}

	public static boolean validatePassword(String temp)
	{
		boolean ans = false;
		if(temp.trim() != null && temp.trim().length() > 4)
		{
			ans = true;
		}
		else
		{
			System.out.println("Password should be atleast 5 character long");
			System.out.println("Enter Password Again:");
		}
		return ans;
	}

	public static boolean validateSalary(String temp)
	{
		boolean ans = false;
		if(temp.trim().matches("[0-9]+"))
		{
			ans = true;
		}
		else
		{
			System.out.println("Enter Integer Only ");
		}
		return ans;
	}

	public static boolean validateTeacherId(String temp)
	{
		boolean ans = false;
		try
		{
			ResultSet rs = CONST.showTeacherPstmt.executeQuery();
			while(rs.next())
			{
				int avaid = Integer.parseInt(rs.getString("id"));
				if(temp.trim().matches("[0-9]+"))
				{
					int id = Integer.parseInt(temp.trim());
					if(avaid == id)
					{
						ans = true;
					}

				}
				else
				{
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
				System.out.println("Enter Correct Id : ");
			}
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	}

	public static boolean validateStudentId(String temp)
	{
		boolean ans = false;

		try
		{
			ResultSet rs = CONST.showStudentPstmt.executeQuery();
			while(rs.next())
			{
				int avaid = Integer.parseInt(rs.getString("id"));
				if(temp.trim().matches("[0-9]+"))
				{
					int id = Integer.parseInt(temp.trim());
					if(avaid == id)
					{
						ans = true;
					}

				}
				else
				{
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
				System.out.println("Enter Correct Id : ");
			}
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	}

	public static boolean validAdmin(String temp1, String temp2) throws SQLException
	{
		boolean ans = false;
		if(temp1.trim().matches("[0-9]+"))
		{
			ResultSet rs = CONST.selectAdminMethod();
			while(rs.next())
			{
				if(temp1.trim().equals(rs.getString("Adminid")) && temp2.trim().equals(rs.getString("Password")))
				{
					ans = true;
				}
			}
			//rs.next();

			if(!ans)
			{
				System.out.println("Wrong Admin Credentials");
			}

		}
		else
		{
			System.out.println("Wrong Admin Credentials");

		}
		return ans;
	}

	public static boolean validStudent(String temp1, String temp2) throws SQLException
	{
		boolean ans = false;
		if(temp1.trim().matches("[0-9]+"))
		{
			ResultSet rs = CONST.selectStudentMethod();
			while(rs.next())
			{
				if(temp1.trim().equals(rs.getString("id")) && temp2.trim().equals(rs.getString("Password")))
				{
					ans = true;
				}
			}
			//rs.next();

			if(!ans)
			{
				System.out.println("Wrong Student Credentials");
			}

		}
		else
		{
			System.out.println("Wrong Student Credentials");

		}
		return ans;
	}

	public static boolean validTeacher(String temp1, String temp2) throws SQLException
	{
		boolean ans = false;
		if(temp1.trim().matches("[0-9]+"))
		{
			ResultSet rs = CONST.selectTeacherMethod();
			while(rs.next())
			{
				if(temp1.trim().equals(rs.getString("id")) && temp2.trim().equals(rs.getString("password")))
				{
					ans = true;
				}
			}
			//rs.next();

			if(!ans)
			{
				System.out.println("Wrong Teacher Credentials");
			}

		}
		else
		{
			System.out.println("Wrong Teacher Credentials");

		}
		return ans;
	}
}