package com.sam.egovernance.controller;

import com.sam.egovernance.dto.RegisterDto;
import com.sam.egovernance.service.EService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private EService eService;

    /*
     * This is used to register a new user
     */
    @PostMapping
    public String registerUser(@RequestBody RegisterDto registerDto) {
        return eService.saveUser(registerDto);
    }
}
