package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratServiceImpl implements IContratService {

    private final ContratRepository contratRepository;

    public ContratServiceImpl(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> addContrats(List<Contrat> contrats) {
        List<Contrat> saved = new ArrayList<>();
        contratRepository.saveAll(contrats).forEach(saved::add);
        return saved;
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        retrieveContrat(contrat.getIdContrat());
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contrats = new ArrayList<>();
        contratRepository.findAll().forEach(contrats::add);
        return contrats;
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat)
                .orElseThrow(() -> new IllegalArgumentException("Contrat introuvable : " + idContrat));
    }

    @Override
    public void removeContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }
}
