package com.sam.egovernance.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String message;
    private String token;
    private  String name;
}
