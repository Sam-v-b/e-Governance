package com.sam.egovernance.controller;

import com.sam.egovernance.dto.DistrictDetailsDto;
import com.sam.egovernance.responses.ResponseDetails;
import com.sam.egovernance.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/district")
public class DistrictDetailsController {
    @Autowired
    private DistrictService districtService;

    /*
     * This is used to register the request at district level
     */
    @PostMapping
    public ResponseEntity<ResponseDetails> reportRequest(@RequestParam(required = false) String request,
                                                         @RequestBody DistrictDetailsDto districtDetailsDto) {
        ResponseDetails responseDetails = districtService.reportRequestDistrict(request, districtDetailsDto);
        return ResponseEntity.ok(responseDetails);
    }
}
