package com.project.registerapi.controller;

import com.project.registerapi.model.City;
import com.project.registerapi.model.Client;
import com.project.registerapi.request.ClientRequest;
import com.project.registerapi.response.Response;
import com.project.registerapi.service.CityService;
import com.project.registerapi.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("v1/public/client")
public class ClientController {

    private final ClientService clientService;
    private final CityService cityService;

    public ClientController(ClientService clientService, CityService cityService) {
        this.clientService = clientService;
        this.cityService = cityService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Response<ClientRequest>> registerClient(@Valid @RequestBody ClientRequest clientRequest){

        Response<ClientRequest> response = new Response<>();

        City city = cityService.findCityByNameAndState(clientRequest.getCity().getName(), clientRequest.getCity().getState());

        if (city == null){
            response.setErrors("This city has not been registered yet.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        Client client = clientRequest.toModel();
        client.setCity(city);

        ClientRequest requestSaved = clientService.registerClient(client).toRequest();

        response.setData(requestSaved);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/name/{fullName}")
    public ResponseEntity<Response<List<Client>>> findClientByName(@Valid @PathVariable("fullName") String fullName){

        Response<List<Client>> response = new Response<>();

        List<Client> clients = clientService.findClientByName(fullName);

        if(clients.size() <= 0){
            response.setErrors("There is no customer with this name");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.setData(clients);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response<ClientRequest>> findClientByName(@Valid @PathVariable("id") Long id){

        Response<ClientRequest> response = new Response<>();

        Client client = clientService.findClientById(id).orElse(null);

        if(client == null){
            response.setErrors("Non-existent customer");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        ClientRequest clientRequest = client.toRequest();

        response.setData(clientRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Response<String>> deleteClient(@Valid @PathVariable("id") Long id){
        Response<String> response = new Response<>();

        Client client = clientService.findClientById(id).orElse(null);

        if(client == null){
            response.setErrors("Error while deleting! Customer does not exist.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        clientService.deleteClient(client);

        response.setData("Client successfully deleted!");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Response<ClientRequest>> updateClient(@Valid @RequestBody ClientRequest clientRequest, @PathVariable("id") Long id){
        Response<ClientRequest> response = new Response<>();

        Client client = clientService.findClientById(id).orElse(null);

        if(client == null){
            response.setErrors("Customer does not exist.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        client.setFullName(clientRequest.getFullName());

        ClientRequest requestUpdated = client.toRequest();

        response.setData(requestUpdated);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
