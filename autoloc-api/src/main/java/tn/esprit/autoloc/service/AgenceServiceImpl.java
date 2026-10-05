package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;

    public AgenceServiceImpl(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> addAgences(List<Agence> agences) {
        List<Agence> saved = new ArrayList<>();
        agenceRepository.saveAll(agences).forEach(saved::add);
        return saved;
    }

    @Override
    public Agence updateAgence(Agence agence) {
        retrieveAgence(agence.getIdAgence());
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> retrieveAllAgences() {
        List<Agence> agences = new ArrayList<>();
        agenceRepository.findAll().forEach(agences::add);
        return agences;
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence)
                .orElseThrow(() -> new IllegalArgumentException("Agence introuvable : " + idAgence));
    }

    @Override
    public void removeAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }
}
