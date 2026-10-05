package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IClientService {

    Client addClient(Client client);

    List<Client> addClients(List<Client> clients);

    Client updateClient(Client client);

    List<Client> retrieveAllClients();

    Client retrieveClient(Long idClient);

    void removeClient(Long idClient);
}
