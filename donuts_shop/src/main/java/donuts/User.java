package donuts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class User {
	private int userId;
	private String mailAddress;
	private byte[] password;
	private String address;
	private String userName;
	private String zip;
	private String registerDateTime;
	private boolean isAdmin;
	
	public User(int userId, String mailAddress, String userName,  String address, String zip, byte[] password, String registerDateTime, boolean isAdmin) {
		this.userId = userId;
		this.mailAddress = mailAddress;
		this.userName = userName;
		this.address = address;
		this.zip = zip;
		this.password = password;
		this.registerDateTime = registerDateTime;
		this.isAdmin = isAdmin;
	}
	
	public byte[] toHash(String pw) {
		return DigestUtils.sha256("salt" + pw + "salt");
		
	}

	public int getUserId() {
		return userId;
	}

	public String getMailAddress() {
		return mailAddress;
	}
	
	public byte[] getPassword() {
		return password;
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

	public String getRegisterDateTime() {
		return registerDateTime;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}
}
