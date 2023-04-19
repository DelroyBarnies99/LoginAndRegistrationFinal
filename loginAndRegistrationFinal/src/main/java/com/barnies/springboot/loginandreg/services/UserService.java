package com.barnies.springboot.loginandreg.services;

import com.barnies.springboot.loginandreg.dto.UserDto;
import com.barnies.springboot.loginandreg.model.User;

public interface UserService {
	
	public void saveUser(UserDto userDto);
	
	User findUserByUsername(String username);

}
