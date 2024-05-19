package com.sam.egovernance.service;

import com.sam.egovernance.dto.DistrictDetailsDto;
import com.sam.egovernance.responses.ResponseDetails;

public interface DistrictService {
    ResponseDetails reportRequestDistrict(String request, DistrictDetailsDto districtDetailsDto);
}
