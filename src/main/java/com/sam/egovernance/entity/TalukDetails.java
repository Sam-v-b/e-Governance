package com.sam.egovernance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class TalukDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String talukName;
    private String districtName;
    private String name;
    private String request;
    private String priority;
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
