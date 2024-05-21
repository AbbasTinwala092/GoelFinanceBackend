package com.goelfinance.goel.mapper;

import com.goelfinance.goel.dto.ClientDto;
import com.goelfinance.goel.dto.SipDto;
import com.goelfinance.goel.entity.Client;
import com.goelfinance.goel.entity.Sip;
import com.goelfinance.goel.repository.ClientRepository;

public class SipMapper {

    private static ClientRepository clientRepository;

    public static Sip mapToSip(SipDto sipDto){
        return new Sip(
                sipDto.getSipId(),
                mapToClient(sipDto.getClientId()),
                sipDto.getTitle(),
                sipDto.getCapFund(),
                sipDto.getValue(),
                sipDto.getStartDate()
        );
    }

    public static SipDto mapToSipDto(Sip sip){
        return new SipDto(
                sip.getSipId(),
                sip.getClient().getClientId(),
                sip.getTitle(),
                sip.getCapFund(),
                sip.getValue(),
                sip.getStartDate()
        );
    }
    private static Client mapToClient(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }

    // Setter method for ClientRepository (for dependency injection)
    public static void setClientRepository(ClientRepository clientRepository) {
        SipMapper.clientRepository = clientRepository;
    }

}
