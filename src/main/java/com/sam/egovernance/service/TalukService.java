package com.sam.egovernance.service;

import com.sam.egovernance.dto.TalukDetailsDto;
import com.sam.egovernance.responses.ResponseDetails;

public interface TalukService {
    ResponseDetails reportRequestTaluk(String request, TalukDetailsDto talukDetailsDto);
}
