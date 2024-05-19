package com.sam.egovernance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDetailsDto {
    private String districtName;
    private String name;
    private String request;
    private String priority;
    private String description;
}
