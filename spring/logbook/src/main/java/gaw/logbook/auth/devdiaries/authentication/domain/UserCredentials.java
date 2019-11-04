package gaw.logbook.auth.devdiaries.authentication.domain;

public class UserCredentials {
	private String userid;  
    private String password;
    
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
