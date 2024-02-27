package com.amiaka.UserDto;

public class ChangePasswordDto {

	private String name;
	private String password;
	private String password2;
	
	public ChangePasswordDto() {}

	public ChangePasswordDto(String name, String password, String password2) {
		super();
		this.name = name;
		this.password = password;
		this.password2 = password2;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Override
	public String toString() {
		return "ChangePasswordDto [name=" + name + ", password=" + password + ", password2=" + password2 + "]";
	}
	
	
}
