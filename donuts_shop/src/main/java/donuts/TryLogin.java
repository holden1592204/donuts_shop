package donuts;

public class TryLogin {
	private String mailAddress;
	private String password;
	
	public TryLogin(String mailaddress, String password) {
		this.mailAddress = mailAddress;
		this.password = password;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getPassword() {
		return password;
	}
	
	
}
