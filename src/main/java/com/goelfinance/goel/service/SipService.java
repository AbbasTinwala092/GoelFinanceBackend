package com.goelfinance.goel.service;

import com.goelfinance.goel.dto.ClientDto;
import com.goelfinance.goel.dto.SipDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SipService {
    SipDto createSip(SipDto sipDto);
    List<SipDto> getAllSip();
    SipDto getSipById(Long sipId);
    void deleteSip(Long sipId);
}
