package com.barnies.springboot.loginandreg.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.barnies.springboot.loginandreg.dto.UserDto;
import com.barnies.springboot.loginandreg.model.Role;
import com.barnies.springboot.loginandreg.model.User;
import com.barnies.springboot.loginandreg.repos.RoleRepository;
import com.barnies.springboot.loginandreg.repos.UserRepository;
import com.barnies.springboot.loginandreg.util.TbConstants;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
    	
    	this.userRepository = userRepository;
    	this.roleRepository = roleRepository;
    	this.passwordEncoder = passwordEncoder;
    	
    }

    @Override
    public void saveUser(UserDto userDto) {
        Role role = roleRepository.findByUsername(TbConstants.Roles.USER);

        if (role == null)
            role = roleRepository.save(new Role(TbConstants.Roles.USER));

        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),
                Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
