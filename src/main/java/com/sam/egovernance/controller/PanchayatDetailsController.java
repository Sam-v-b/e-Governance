package com.sam.egovernance.controller;

import com.sam.egovernance.dto.PanchayatDetailsDto;
import com.sam.egovernance.responses.ResponseDetails;
import com.sam.egovernance.service.PanchayatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://locathost:4200")
@RequestMapping("/panchayat")
public class PanchayatDetailsController {
    @Autowired
    private PanchayatService panchayatService;
    /*
     * This is used to register the request at panchayat level
     */
    @PostMapping
    public ResponseEntity<ResponseDetails> reportRequest(@RequestParam(required = false) String request,
                                                         @RequestBody PanchayatDetailsDto panchayatDetailsDto) {
        ResponseDetails responseDetails = panchayatService.reportRequestPanchayat(request, panchayatDetailsDto);
        return ResponseEntity.ok(responseDetails);
    }
}
