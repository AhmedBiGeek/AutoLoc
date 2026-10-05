package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {

    Paiement addPaiement(Paiement paiement);

    List<Paiement> addPaiements(List<Paiement> paiements);

    Paiement updatePaiement(Paiement paiement);

    List<Paiement> retrieveAllPaiements();

    Paiement retrievePaiement(Long idPaiement);

    void removePaiement(Long idPaiement);
}
