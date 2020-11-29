package com.project.registerapi.service;


import com.project.registerapi.model.Client;
import com.project.registerapi.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client registerClient(Client client){

        return clientRepository.save(client);
    }

    public List<Client> findClientByName(String fullName){

        return clientRepository.findByFullName(fullName);
    }

    public Optional<Client> findClientById(Long id){

        return clientRepository.findById(id);
    }

    public void deleteClient(Client client){
        clientRepository.delete(client);
    }

    public Client updateClient(Client client){

        return clientRepository.save(client);
    }
}
