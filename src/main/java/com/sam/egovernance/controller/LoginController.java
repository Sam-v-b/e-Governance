package com.sam.egovernance.controller;

import com.sam.egovernance.dto.LoginDto;
import com.sam.egovernance.responses.LoginResponse;
import com.sam.egovernance.service.EService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private EService eService;
    /*
     * This is used for logging in
     */
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginDto loginDto){
       return eService.loginUser(loginDto);
    }
}
