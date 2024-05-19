package com.sam.egovernance.service;

import com.sam.egovernance.dto.PanchayatDetailsDto;
import com.sam.egovernance.entity.PanchayatDetails;
import com.sam.egovernance.repo.PanchayatRepo;
import com.sam.egovernance.responses.ResponseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PanchayatServiceImpl implements PanchayatService {
    @Autowired
    private PanchayatRepo panchayatRepo;

    @Override
    public ResponseDetails reportRequestPanchayat(String request, PanchayatDetailsDto panchayatDetailsDto) {
        ResponseDetails responseDetails = new ResponseDetails();
        PanchayatDetails panchayatDetails = new PanchayatDetails();
        PanchayatDetails existingRequest = panchayatRepo.findPanchayatDetailsByRequest(request);
        if (existingRequest != null) {
            if (panchayatDetailsDto.getName() != null) {
                existingRequest.setName(panchayatDetailsDto.getName());
            }
            if (panchayatDetailsDto.getPanchayatName() != null) {
                existingRequest.setPanchayatName(panchayatDetailsDto.getPanchayatName());
            }
            if (panchayatDetailsDto.getTalukName() != null) {
                existingRequest.setTalukName(panchayatDetailsDto.getTalukName());
            }
            if (panchayatDetailsDto.getDistrictName() != null) {
                existingRequest.setDistrictName(panchayatDetailsDto.getDistrictName());
            }
            if (panchayatDetailsDto.getRequest() != null) {
                existingRequest.setRequest(panchayatDetailsDto.getRequest());
            }
            if (panchayatDetailsDto.getPriority() != null) {
                existingRequest.setPriority(panchayatDetailsDto.getPriority());
            }
            if (panchayatDetailsDto.getDescription() != null) {
                existingRequest.setPriority(panchayatDetailsDto.getDescription());
            }
            existingRequest.setUpdatedTime(LocalDateTime.now());
            panchayatRepo.save(existingRequest);
        } else {
            panchayatDetails.setName(panchayatDetailsDto.getName());
            panchayatDetails.setPanchayatName(panchayatDetailsDto.getPanchayatName());
            panchayatDetails.setTalukName(panchayatDetailsDto.getTalukName());
            panchayatDetails.setDistrictName(panchayatDetailsDto.getDistrictName());
            panchayatDetails.setRequest(panchayatDetailsDto.getRequest());
            panchayatDetails.setPriority(panchayatDetailsDto.getPriority());
            panchayatDetails.setDescription(panchayatDetailsDto.getDescription());
            panchayatDetails.setCreatedTime(LocalDateTime.now());
            panchayatRepo.save(panchayatDetails);
        }
        responseDetails.setResponseMessage("Your request has been logged successfully!...");
        responseDetails.setRequest(panchayatDetailsDto.getRequest());
        responseDetails.setPriority(panchayatDetailsDto.getPriority());
        responseDetails.setDescription(panchayatDetailsDto.getDescription());
        return responseDetails;
    }
}

