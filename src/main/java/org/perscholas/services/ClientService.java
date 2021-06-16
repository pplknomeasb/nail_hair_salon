package org.perscholas.services;

import lombok.extern.java.Log;
import org.perscholas.daos.IClientRepo;

import org.perscholas.models.Client;

import org.perscholas.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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
        Optional<Client> clientOptional = clientRepo.findByClientConfirmationNumber(client.getCConfirmationNumber());
        if(clientOptional.isPresent()){
            throw new IllegalStateException(clientOptional + " is already in use.");
        }
        return clientRepo.save(client);
    }


    public void updateClient(Long cConfirmationNumber, String fName, String lName, Long phoneNum, String email, Date dateTime){

        boolean exists = clientRepo.existsById(cConfirmationNumber);
        if(exists){
            Client client= clientRepo.findByClientConfirmationNumber(cConfirmationNumber).get();
            log.info("Client Details were updated.");
            client.setCFname(fName);
            client.setCLname(lName);
            client.setCPhoneNum(phoneNum);
            client.setClientEmail(email);
            client.setCDateTime(dateTime);

        }


    }

    @Transactional
    public void removeClient(Long cConfirmationNumber){
        Optional<Client> clientOptional = clientRepo.findByClientConfirmationNumber(cConfirmationNumber);
        boolean exists = clientRepo.existsById(cConfirmationNumber);
        if(exists){
            log.info("Client with Confirmation number " + cConfirmationNumber+ " has been removed");
            clientRepo.deleteById(cConfirmationNumber);
        }
    }
}
