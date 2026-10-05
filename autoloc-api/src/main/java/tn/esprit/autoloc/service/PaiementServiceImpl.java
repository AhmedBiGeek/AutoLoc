package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;

    public PaiementServiceImpl(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> paiements) {
        List<Paiement> saved = new ArrayList<>();
        paiementRepository.saveAll(paiements).forEach(saved::add);
        return saved;
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        retrievePaiement(paiement.getIdPaiement());
        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> retrieveAllPaiements() {
        List<Paiement> paiements = new ArrayList<>();
        paiementRepository.findAll().forEach(paiements::add);
        return paiements;
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return paiementRepository.findById(idPaiement)
                .orElseThrow(() -> new IllegalArgumentException("Paiement introuvable : " + idPaiement));
    }

    @Override
    public void removePaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }
}
