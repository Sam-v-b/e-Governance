package com.sam.egovernance.service;

import com.sam.egovernance.dto.LoginDto;
import com.sam.egovernance.dto.RegisterDto;
import com.sam.egovernance.responses.LoginResponse;

public interface EService {
    String saveUser(RegisterDto registerDto);

    LoginResponse loginUser(LoginDto loginDto);
}
