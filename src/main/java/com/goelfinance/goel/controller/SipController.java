package com.goelfinance.goel.controller;

import com.goelfinance.goel.dto.ClientDto;
import com.goelfinance.goel.dto.SipDto;
import com.goelfinance.goel.entity.Sip;
import com.goelfinance.goel.service.SipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sips")
public class SipController {
    private SipService sipService;

    public SipController(SipService sipService) {
        this.sipService = sipService;
    }

    @PostMapping
    public ResponseEntity<SipDto> addSip(@RequestBody SipDto sipDto){
        return new ResponseEntity<>(sipService.createSip(sipDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SipDto>> getAllSips(){
        List<SipDto> sips = sipService.getAllSip();
        return ResponseEntity.ok(sips);
    }

    @GetMapping("/{sipId}")
    public ResponseEntity<SipDto> getSipById(@PathVariable Long sipId){
        SipDto sipDto = sipService.getSipById(sipId);
        return ResponseEntity.ok(sipDto);
    }

    @DeleteMapping("/{sipId}")
    public ResponseEntity<String> deleteSip(@PathVariable Long sipId){
        sipService.deleteSip(sipId);
        return ResponseEntity.ok("Successfully deleted SIP details");
    }

}
