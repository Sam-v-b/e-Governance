package com.sam.egovernance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanchayatDetailsDto {
    private String panchayatName;
    private  String talukName;
    private String districtName;
    private String name;
    private String request;
    private String priority;
    private String description;
}
