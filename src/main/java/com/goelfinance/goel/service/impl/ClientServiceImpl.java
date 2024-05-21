package com.goelfinance.goel.service.impl;

import com.goelfinance.goel.dto.ClientDto;
import com.goelfinance.goel.entity.Client;
import com.goelfinance.goel.mapper.ClientMapper;
import com.goelfinance.goel.repository.ClientRepository;
import com.goelfinance.goel.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = ClientMapper.mapToClient(clientDto);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.mapToClientDto(savedClient);
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        System.out.println(clients);
        return clients.stream().map((client)->ClientMapper.mapToClientDto(client)).collect(Collectors.toList());

    }

    @Override
    public ClientDto getClientById(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("Client does not exist"));
        return ClientMapper.mapToClientDto(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDto updateClient(Long clientId, ClientDto clientDto) {
        Client existingClient = clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("Client does not exist"));

        existingClient.setFullName(clientDto.getFullName());
        existingClient.setAge(clientDto.getAge());
        existingClient.setAddress(clientDto.getAddress());
        existingClient.setIncome(clientDto.getIncome());
        existingClient.setContactNumber(clientDto.getContactNumber());
        existingClient.setEmail(clientDto.getEmail());
        existingClient.setOccupation(clientDto.getOccupation());
        existingClient.setPanNumber(clientDto.getPanNumber());
        existingClient.setDob(clientDto.getDob());

        Client updatedClient = clientRepository.save(existingClient);

        return ClientMapper.mapToClientDto(updatedClient);
    }


}
