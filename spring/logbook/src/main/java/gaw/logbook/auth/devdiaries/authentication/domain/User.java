package gaw.logbook.auth.devdiaries.authentication.domain;

public class User {
	private String userid;
	private String username;
	private String password;
	private String kodeCabang;
	private String roles;
	
	public User() {
		super();
	}

//	public User(String userid, String username) {
//		super();
//		this.userid = userid;
//		this.username = username;
//	}

	public User(String userid, String username, String password, String kodeCabang, String roles) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.kodeCabang = kodeCabang;
		this.roles = roles;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKodeCabang() {
		return kodeCabang;
	}

	public void setKodeCabang(String kodeCabang) {
		this.kodeCabang = kodeCabang;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
