package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> addClients(List<Client> clients) {
        List<Client> saved = new ArrayList<>();
        clientRepository.saveAll(clients).forEach(saved::add);
        return saved;
    }

    @Override
    public Client updateClient(Client client) {
        retrieveClient(client.getIdClient());
        return clientRepository.save(client);
    }

    @Override
    public List<Client> retrieveAllClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clientRepository.findById(idClient)
                .orElseThrow(() -> new IllegalArgumentException("Client introuvable : " + idClient));
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }
}
