package model;

public class Password {
	
	private String id;
	private String password;
	private String timStamp;
	private String username;
	private String usermail;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTimStamp() {
		return timStamp;
	}
	public void setTimStamp(String timStamp) {
		this.timStamp = timStamp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Password(String id, String password, String timStamp, String username, String usermail) {
		super();
		this.id = id;
		this.password = password;
		this.timStamp = timStamp;
		this.username = username;
		this.usermail = usermail;
	}
	public Password() {
		this("","","","","");
	}
	
	

}
