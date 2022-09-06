package Application;

public class Teacher
{
	private int		Tid;
	private String	UserName;
	private String	Password;
	private String	FullName;
	private String	Branch;
	private int		Salary;

	public Teacher(int tid, String userName, String password, String fullName, String branch, int salary)
	{
		super();
		Tid = tid;
		UserName = userName;
		Password = password;
		FullName = fullName;
		Branch = branch;
		Salary = salary;
	}

	/**
	 * @return the tid
	 */
	public int getTid()
	{
		return Tid;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid)
	{
		Tid = tid;
	}

	/**
	 * @return the userName
	 */
	public String getUserName()
	{
		return UserName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName)
	{
		UserName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		Password = password;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName()
	{
		return FullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName)
	{
		FullName = fullName;
	}

	/**
	 * @return the branch
	 */
	public String getBranch()
	{
		return Branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch)
	{
		Branch = branch;
	}

	/**
	 * @return the salary
	 */
	public int getSalary()
	{
		return Salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary)
	{
		Salary = salary;
	}

}
