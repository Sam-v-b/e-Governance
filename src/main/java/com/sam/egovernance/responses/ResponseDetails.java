package com.sam.egovernance.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDetails {
    private String responseMessage;
    private String request;
    private String priority;
    private String description;
}
