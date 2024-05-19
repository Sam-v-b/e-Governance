package com.sam.egovernance.service;

import com.sam.egovernance.dto.TalukDetailsDto;
import com.sam.egovernance.entity.TalukDetails;
import com.sam.egovernance.repo.TalukRepo;
import com.sam.egovernance.responses.ResponseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TalukServiceImpl implements TalukService{
    @Autowired
    private TalukRepo talukRepo;
    @Override
    public ResponseDetails reportRequestTaluk(String request, TalukDetailsDto talukDetailsDto) {
        ResponseDetails responseDetails = new ResponseDetails();
        TalukDetails talukDetails = new TalukDetails();
        TalukDetails existingRequest = talukRepo.findTalukDetailsByRequest(request);
        if(existingRequest != null){
            if(talukDetailsDto.getName() != null){
                existingRequest.setName(talukDetailsDto.getName());
            }
            if(talukDetailsDto.getTalukName() != null){
                existingRequest.setTalukName(talukDetailsDto.getTalukName());
            }
            if(talukDetailsDto.getDistrictName() != null){
                existingRequest.setDistrictName(talukDetailsDto.getDistrictName());
            }
            if(talukDetailsDto.getRequest() != null){
                existingRequest.setRequest(talukDetailsDto.getRequest());
            }
            if(talukDetailsDto.getPriority() != null){
                existingRequest.setPriority(talukDetailsDto.getPriority());
            }
            if(talukDetailsDto.getDescription() != null){
                existingRequest.setPriority(talukDetailsDto.getDescription());
            }
            existingRequest.setUpdatedTime(LocalDateTime.now());
            talukRepo.save(existingRequest);
        }else {
            talukDetails.setName(talukDetailsDto.getName());
            talukDetails.setTalukName(talukDetailsDto.getTalukName());
            talukDetails.setDistrictName(talukDetailsDto.getDistrictName());
            talukDetails.setRequest(talukDetailsDto.getRequest());
            talukDetails.setPriority(talukDetailsDto.getPriority());
            talukDetails.setDescription(talukDetailsDto.getDescription());
            talukDetails.setCreatedTime(LocalDateTime.now());
            talukRepo.save(talukDetails);
        }
        responseDetails.setResponseMessage("Your request has been logged successfully!...");
        responseDetails.setRequest(talukDetailsDto.getRequest());
        responseDetails.setPriority(talukDetailsDto.getPriority());
        responseDetails.setDescription(talukDetailsDto.getDescription());
        return responseDetails;
    }
}
