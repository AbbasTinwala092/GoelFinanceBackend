package com.goelfinance.goel.controller;

import com.goelfinance.goel.dto.ClientDto;
import com.goelfinance.goel.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto){
        return new ResponseEntity<>(clientService.createClient(clientDto), HttpStatus.CREATED);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long clientId){
        ClientDto clientDto = clientService.getClientById(clientId);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients(){
        List<ClientDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable Long clientId){
        clientService.deleteClient(clientId);
        return ResponseEntity.ok("Successfully deleted Client details");
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long clientId ,@RequestBody ClientDto clientDto){
        ClientDto updatedClient = clientService.updateClient(clientId, clientDto);

        return ResponseEntity.ok(updatedClient);
    }
}
