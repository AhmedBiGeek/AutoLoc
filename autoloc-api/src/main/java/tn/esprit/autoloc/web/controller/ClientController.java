package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    // http://localhost:8080/client/add-client
    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    // http://localhost:8080/client/add-clients
    @PostMapping("/add-clients")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return clientService.addClients(clients);
    }

    // http://localhost:8080/client/update-client
    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    // http://localhost:8080/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    // http://localhost:8080/client/retrieve-client/1
    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    // http://localhost:8080/client/remove-client/1
    @DeleteMapping("/remove-client/{client-id}")
    public void removeClient(@PathVariable("client-id") Long idClient) {
        clientService.removeClient(idClient);
    }
}
