package com.sam.egovernance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="users")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String name;
    private String password;
    private Long aadharNumber;
    private Long phoneNumber;
    private String email;
}
