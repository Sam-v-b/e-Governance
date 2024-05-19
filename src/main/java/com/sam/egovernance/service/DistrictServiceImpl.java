package com.sam.egovernance.service;

import com.sam.egovernance.dto.DistrictDetailsDto;
import com.sam.egovernance.entity.DistrictDetails;
import com.sam.egovernance.repo.DistrictRepo;
import com.sam.egovernance.responses.ResponseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DistrictServiceImpl implements DistrictService{
    @Autowired
    private DistrictRepo districtRepo;
    @Override
    public ResponseDetails reportRequestDistrict(String request, DistrictDetailsDto districtDetailsDto) {
        ResponseDetails responseDetails = new ResponseDetails();
        DistrictDetails districtDetails = new DistrictDetails();
        DistrictDetails existingRequest = districtRepo.findDistrictDetailsByRequest(request);
        if(existingRequest != null){
            if(districtDetailsDto.getName() != null){
                existingRequest.setName(districtDetailsDto.getName());
            }
            if(districtDetailsDto.getDistrictName() != null){
                existingRequest.setDistrictName(districtDetailsDto.getDistrictName());
            }
            if(districtDetailsDto.getRequest() != null){
                existingRequest.setRequest(districtDetailsDto.getRequest());
            }
            if(districtDetailsDto.getPriority() != null){
                existingRequest.setPriority(districtDetailsDto.getPriority());
            }
            if(districtDetailsDto.getDescription() != null){
                existingRequest.setPriority(districtDetailsDto.getDescription());
            }
            existingRequest.setUpdatedTime(LocalDateTime.now());
            districtRepo.save(existingRequest);
        }else {
            districtDetails.setName(districtDetailsDto.getName());
            districtDetails.setDistrictName(districtDetailsDto.getDistrictName());
            districtDetails.setRequest(districtDetailsDto.getRequest());
            districtDetails.setPriority(districtDetailsDto.getPriority());
            districtDetails.setDescription(districtDetailsDto.getDescription());
            districtDetails.setCreatedTime(LocalDateTime.now());
            districtRepo.save(districtDetails);
        }
        responseDetails.setResponseMessage("Your request has been logged successfully!...");
        responseDetails.setRequest(districtDetailsDto.getRequest());
        responseDetails.setPriority(districtDetailsDto.getPriority());
        responseDetails.setDescription(districtDetailsDto.getDescription());
        return responseDetails;
    }
}
