package Application;

public class Student
{
	private int		id;
	private String	name;
	private String	password;
	private String	email;
	private int		deptid;

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
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
	//
	//	/* (non-Javadoc)
	//	 * @see java.lang.Object#toString()
	//	 */
	//	@Override
	//	public String toString()
	//	{
	//		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", deptid=" + deptid + "]";
	//	}

	public Student(String name, String password, String email, int deptid)
	{
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.deptid = deptid;
	}

	public Student(int id, int deptid)
	{
		super();
		this.id = id;
		this.deptid = deptid;
	}

}
