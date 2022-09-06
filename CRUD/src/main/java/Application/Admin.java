package Application;

public class Admin
{
	private int		AdminId;
	private String	AdminPassword;

	/**
	 * @return the adminId
	 */
	public int getAdminId()
	{
		return AdminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId)
	{
		AdminId = adminId;
	}

	/**
	 * @return the adminPassword
	 */
	public String getAdminPassword()
	{
		return AdminPassword;
	}

	/**
	 * @param adminPassword the adminPassword to set
	 */
	public void setAdminPassword(String adminPassword)
	{
		AdminPassword = adminPassword;
	}

	public Admin(int adminId, String adminPassword)
	{
		super();
		AdminId = adminId;
		AdminPassword = adminPassword;
	}

}
