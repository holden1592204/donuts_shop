package donuts;

import java.sql.Date;

public class User {
	private int userId;
	private String mailAddress;
	private String address;
	private String userName;
	private String zip;
	private Date registerDateTime;
	
	public User(int userId, String mailAddress, String address, String userName, String zip, Date registerDateTime) {
		this.userId = userId;
		this.mailAddress = mailAddress;
		this.address = address;
		this.userName = userName;
		this.zip = zip;
		this.registerDateTime = registerDateTime;
	}

	public int getUserId() {
		return userId;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getAddress() {
		return address;
	}

	public String getUserName() {
		return userName;
	}

	public String getZip() {
		return zip;
	}

	public Date getRegisterDateTime() {
		return registerDateTime;
	}

	
}
