package com.sam.egovernance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String userName;
    private String name;
    private String password;
    private Long aadharNumber;
    private Long phoneNumber;
    private String email;
}
