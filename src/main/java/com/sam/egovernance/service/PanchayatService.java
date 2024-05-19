package com.sam.egovernance.service;

import com.sam.egovernance.dto.PanchayatDetailsDto;
import com.sam.egovernance.responses.ResponseDetails;

public interface PanchayatService {
    ResponseDetails reportRequestPanchayat(String request, PanchayatDetailsDto panchayatDetailsDto);
}
