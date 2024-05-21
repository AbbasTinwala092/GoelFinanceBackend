package com.goelfinance.goel.mapper;

import com.goelfinance.goel.dto.ClientDto;
import com.goelfinance.goel.entity.Client;

public class ClientMapper {

    public static Client mapToClient(ClientDto clientDto){
        return new Client(
                clientDto.getClientId(),
                clientDto.getFullName(),
                clientDto.getAge(),
                clientDto.getAddress(),
                clientDto.getIncome(),
                clientDto.getContactNumber(),
                clientDto.getEmail(),
                clientDto.getOccupation(),
                clientDto.getPanNumber(),
                clientDto.getDob()
        );
    }

    public static ClientDto mapToClientDto(Client client){
        return new ClientDto(
                client.getClientId(),
                client.getFullName(),
                client.getAge(),
                client.getAddress(),
                client.getIncome(), 
                client.getContactNumber(),
                client.getEmail(),
                client.getOccupation(),
                client.getPanNumber(),
                client.getDob()
        );
    }
}
