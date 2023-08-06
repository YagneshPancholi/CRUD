package Application;

public class Teacher
{
	private int		id;
	private String	name;
	private String	password;
	private String	email;
	private int		deptid;

	public Teacher(int tid, String name, String password, String email)
	{
		super();
		this.id = tid;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public Teacher(int tid, int deptid, int salary)
	{
		this.setid(tid);
		this.deptid = deptid;
		this.salary = salary;
	}

	public Teacher(String name, String password, String email, int deptid, int salary)
	{
		this.name = name;
		this.password = password;
		this.email = email;
		this.deptid = deptid;
		this.salary = salary;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @return the deptid
	 */
	public int getDeptid()
	{
		return deptid;
	}

	/**
	 * @param deptid the deptid to set
	 */
	public void setDeptid(int deptid)
	{
		this.deptid = deptid;
	}

	/**
	 * @return the salary
	 */
	public int getSalary()
	{
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	public int getid()
	{
		return id;
	}

	public void setid(int id)
	{
		this.id = id;
	}

	private int salary;

}
