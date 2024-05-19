package com.sam.egovernance.service;

import com.sam.egovernance.dto.LoginDto;
import com.sam.egovernance.dto.RegisterDto;
import com.sam.egovernance.entity.User;
import com.sam.egovernance.repo.UserRepo;
import com.sam.egovernance.responses.LoginResponse;
import com.sam.egovernance.utility.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class EServiceImpl implements EService{
    @Autowired
    private UserRepo repo;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public String saveUser(RegisterDto registerDto) {
        User user = new User();
        User existingUser = repo.findByUserName(registerDto.getUserName());
        if(existingUser != null){
            return ("User found with same username please give some other username");
        }
        else {
            user.setUserName(registerDto.getUserName());
            user.setName(registerDto.getName());
            user.setPassword(registerDto.getPassword());
            user.setAadharNumber(registerDto.getAadharNumber());
            user.setPhoneNumber(registerDto.getPhoneNumber());
            user.setEmail(registerDto.getEmail());
            repo.save(user);
            return ("User registered successfully");
        }
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        LoginResponse loginResponse = new LoginResponse();
        User user = repo.findByUserName(loginDto.getUserName());
        if(user == null){
            loginResponse.setMessage("User not found");
        }else{
            if(user.getPassword().equals(loginDto.getPassword())){
                loginResponse.setMessage("User logged in successfully");
                loginResponse.setName(user.getName());
                UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUserName());
                loginResponse.setToken(jwtUtils.generateToken(userDetails));
            }else{
                loginResponse.setMessage("Invalid password");
            }
        }
        return loginResponse;
    }
}
