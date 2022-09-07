package Application;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminMethods
{
	static Scanner sc = new Scanner(System.in);

	public static void start() throws SQLException
	{
		String adminInput, teacherInput, studentInput = null;
		int input, input2, input3 = 0;
		System.out.println("Enter AdminId : ");
		String AdminId = sc.nextLine();
		System.out.println("Enter Password : ");
		String AdminPassword = sc.nextLine();
		while(!Validation.validAdmin(AdminId, AdminPassword))
		{
			System.out.println("Enter AdminId Again : ");
			AdminId = sc.nextLine();
			System.out.println("Enter Password Again : ");
			AdminPassword = sc.nextLine();
		}
		while(true)
		{
			menu.printAdminMenu();
			adminInput = sc.nextLine();
			if(adminInput.trim().matches("[0-9]+") && Integer.parseInt(adminInput.trim()) > 0 && Integer.parseInt(adminInput.trim()) < 4)
			{
				input2 = Integer.parseInt(adminInput.trim());
				//Student features for ADMIN
				if(input2 == 1)
				{
					while(true)
					{
						menu.printMenuForStudent();
						studentInput = sc.nextLine();
						if(studentInput.trim().matches("[0-9]+") && Integer.parseInt(studentInput.trim()) < 6 && Integer.parseInt(studentInput.trim()) > 0)
						{
							input = Integer.parseInt(studentInput.trim());
							if(input == 1)
							{
								CONST.insertStudent(AddStudent());

							}
							else if(input == 2)
							{
								if(CONST.showStudentPstmt.executeQuery().next())
								{
									CONST.showStudent();
								}
								else
								{
									System.out.println("Databse is Empty");
								}
							}
							else if(input == 3)
							{
								if(CONST.showStudentPstmt.executeQuery().next())
								{
									Student st = UpdateDeptId();
									CONST.updateStudent(st);
								}
								else
								{
									System.out.println("Databse is Empty");
								}
							}
							else if(input == 4)
							{
								if(CONST.showStudentPstmt.executeQuery().next())
								{
									System.out.println("Enter student id to delete : ");
									String temp = sc.nextLine();
									while(!Validation.validateStudentId(temp))
									{
										temp = sc.nextLine();
									}
									int id = Integer.parseInt(temp.trim());
									CONST.deleteStudent(id);
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
				// Teacher Feathures For Admin
				else if(input2 == 2)
				{
					while(true)
					{
						menu.printMenuForTeacher();
						teacherInput = sc.nextLine();
						if(teacherInput.trim().matches("[0-9]+") && Integer.parseInt(teacherInput.trim()) < 6 && Integer.parseInt(teacherInput.trim()) > 0)
						{
							input3 = Integer.parseInt(teacherInput.trim());
							if(input3 == 1)
							{
								CONST.insertTeacher(AddTeacher());

							}
							else if(input3 == 2)
							{
								if(CONST.showTeacherPstmt.executeQuery().next())
								{
									CONST.showTeacher();
								}
								else
								{
									System.out.println("Databse is Empty");
								}
							}
							else if(input3 == 3)
							{
								if(CONST.showStudentPstmt.executeQuery().next())
								{
									CONST.updateTeacher(updateTeacher());
								}
								else
								{
									System.out.println("Databse is Empty");
								}
							}
							else if(input3 == 4)
							{
								if(CONST.showTeacherPstmt.executeQuery().next())
								{
									System.out.println("Enter Teacher id to delete : ");
									String temp = sc.nextLine();
									while(!Validation.validateTeacherId(temp))
									{
										temp = sc.nextLine();
									}
									int id = Integer.parseInt(temp.trim());
									CONST.deleteTeacher(id);
								}
								else
								{
									System.out.println("Databse is Empty");
								}

							}
							else if(input3 == 5)
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

	public static Student AddStudent()
	{
		System.out.println("Enter Name :  ");
		String name = sc.nextLine();
		while(!Validation.validateName(name))
		{
			name = sc.nextLine();
		}
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		while(!Validation.validatePassword(password))
		{
			password = sc.nextLine();
		}
		System.out.println("Enter Email :  ");
		String email = sc.nextLine();
		while(!Validation.validateEmail(email))
		{
			email = sc.nextLine();
		}
		System.out.println("Avaliable Department Ids : From 1 to 10 ");
		String temp = null;
		int deptid = 0;
		System.out.println("Enter Department Id");
		temp = sc.nextLine();
		while(!Validation.validateDeptId(temp))
		{
			temp = sc.nextLine();
		}
		deptid = Integer.parseInt(temp.trim());
		Student st = new Student(name, password, email, deptid);
		//sc.close();
		return st;
	}

	public static Student UpdateDeptId() throws SQLException
	{
		System.out.println("Enter Student ID To which You want to  Update\n");
		String temp = sc.nextLine();
		while(!Validation.validateStudentId(temp))
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
		while(!Validation.validateDeptId(temp1))
		{
			temp1 = sc.nextLine();
		}
		deptid = Integer.parseInt(temp1.trim());
		return new Student(id, deptid);
	}

	public static Teacher AddTeacher()
	{
		System.out.println("Enter Name :  ");
		String name = sc.nextLine();
		while(!Validation.validateName(name))
		{
			name = sc.nextLine();
		}
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		while(!Validation.validatePassword(password))
		{
			password = sc.nextLine();
		}
		System.out.println("Enter Email :  ");
		String email = sc.nextLine();
		while(!Validation.validateEmail(email))
		{
			email = sc.nextLine();
		}
		System.out.println("Avaliable Department Ids : From 1 to 10 ");
		String temp = null;
		int deptid = 0;
		System.out.println("Enter Department Id");
		temp = sc.nextLine();

		while(!Validation.validateDeptId(temp))
		{
			temp = sc.nextLine();
		}
		deptid = Integer.parseInt(temp.trim());

		String temp1;
		int salary = 0;
		System.out.println("Enter Salary : ");
		temp1 = sc.nextLine();
		while(!Validation.validateSalary(temp1))
		{
			temp1 = sc.nextLine();
		}
		salary = Integer.parseInt(temp1.trim());
		Teacher t = new Teacher(name, password, email, deptid, salary);
		//sc.close();
		return t;
	}

	public static Teacher updateTeacher()
	{
		System.out.println("Enter Teacher ID To which You want to  Update\n");
		String temp = sc.nextLine();
		while(!Validation.validateTeacherId(temp))
		{
			temp = sc.nextLine();
		}
		int tid = Integer.parseInt(temp.trim());
		System.out.println("Avaliable Department Ids : From 1 to 10 ");
		String temp1 = null;
		int deptid = 0;
		System.out.println("Enter New Department Id");
		temp1 = sc.nextLine();
		while(!Validation.validateDeptId(temp1))
		{
			temp1 = sc.nextLine();
		}
		deptid = Integer.parseInt(temp1.trim());

		System.out.println("Enter New Salary");
		String tempsalary = sc.nextLine();
		while(!Validation.validateSalary(tempsalary))
		{
			tempsalary = sc.nextLine();
		}
		int salary = Integer.parseInt(tempsalary);
		Teacher teach = new Teacher(tid, deptid, salary);
		return teach;
	}

}
