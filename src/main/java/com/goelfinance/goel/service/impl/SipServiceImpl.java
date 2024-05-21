package com.goelfinance.goel.service.impl;

import com.goelfinance.goel.dto.SipDto;
import com.goelfinance.goel.entity.Client;
import com.goelfinance.goel.entity.Sip;
import com.goelfinance.goel.mapper.ClientMapper;
import com.goelfinance.goel.mapper.SipMapper;
import com.goelfinance.goel.repository.ClientRepository;
import com.goelfinance.goel.repository.SipRepository;
import com.goelfinance.goel.service.SipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SipServiceImpl implements SipService {

    @Autowired
    private SipRepository sipRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public SipDto createSip(SipDto sipDto) {
        if (sipDto.getClientId() == null || sipDto.getTitle() == null || sipDto.getValue() == null
                || sipDto.getStartDate() == null) {
            throw new IllegalArgumentException("Required fields missing.");
        }

        // Check if client exists
        Client client = clientRepository.findById(sipDto.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found."));

        // Create Sip entity and map fields
        Sip sip = new Sip();
        sip.setTitle(sipDto.getTitle());
        sip.setCapFund(sipDto.getCapFund());
        sip.setValue(sipDto.getValue());
        sip.setStartDate(sipDto.getStartDate());
        sip.setClient(client);

        // Save Sip entity
        Sip savedSip = sipRepository.save(sip);

        // Map saved Sip entity back to SipDto and return
        return SipMapper.mapToSipDto(savedSip);
    }

    @Override
    public List<SipDto> getAllSip() {
        List<Sip> sips = sipRepository.findAll();
        return sips.stream().map((sip)-> SipMapper.mapToSipDto(sip)).collect(Collectors.toList());
    }

    @Override
    public SipDto getSipById(Long sipId) {
        Sip sip = sipRepository.findById(sipId).orElseThrow(()->new RuntimeException("SIP does not exist"));
        return SipMapper.mapToSipDto(sip);
    }

    @Override
    public void deleteSip(Long sipId) {
        sipRepository.deleteById(sipId);
    }

}
