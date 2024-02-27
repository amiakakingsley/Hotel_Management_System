package com.amiaka.UserService;

import com.amiaka.UserDto.ChangePasswordDto;
import com.amiaka.UserDto.UserDto;

public interface UserService {
	void SaveUser(UserDto userDto);
	
	 UserDto findByEmail(String email);
	 
	 void ChangePassword(ChangePasswordDto newPassword);
}
