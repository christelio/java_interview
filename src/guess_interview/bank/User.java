package guess_interview.bank;



public class User {

	//µÇÂ¼ÒµÎñ
	private String userName;
	private String userPassword;
	private Float balance;
	
	
	
	
	
	public User(String userName, String userPassword, Float balance) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.balance = balance;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	
}
