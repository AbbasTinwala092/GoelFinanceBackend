package com.goelfinance.goel.service;

import com.goelfinance.goel.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);
    List<ClientDto> getAllClients();
    ClientDto getClientById(Long clientId);
    void deleteClient(Long clientId);
    ClientDto updateClient(Long clientId, ClientDto clientDto);
}