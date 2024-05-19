package com.sam.egovernance.controller;

import com.sam.egovernance.dto.TalukDetailsDto;
import com.sam.egovernance.responses.ResponseDetails;
import com.sam.egovernance.service.TalukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/taluk")
public class TalukDetailsController {
    @Autowired
    private TalukService talukService;

    /*
     * This is used to register the request at taluk level
     */
    @PostMapping
    public ResponseEntity<ResponseDetails> reportRequest(@RequestParam(required = false) String request,
                                                         @RequestBody TalukDetailsDto talukDetailsDto) {
        ResponseDetails responseDetails = talukService.reportRequestTaluk(request, talukDetailsDto);
        return ResponseEntity.ok(responseDetails);
    }
}
