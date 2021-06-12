package org.perscholas.services;

import lombok.extern.java.Log;
import org.perscholas.daos.IClientRepo;

import org.perscholas.models.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class ClientService {

    private final IClientRepo clientRepo;

    @Autowired
    public ClientService(IClientRepo clientRepo) {this.clientRepo = clientRepo; }

    public List<Client> getClients() {return clientRepo.findAll();}

    public Client addNewClient(Client client){
        Optional<Client> clientOptional = clientRepo.findClientByclientEmail(client.getClientEmail());
        if(clientOptional.isPresent()){
            throw new IllegalStateException(clientOptional + " is already in use.");
        }
        return clientRepo.save(client);
    }
}
