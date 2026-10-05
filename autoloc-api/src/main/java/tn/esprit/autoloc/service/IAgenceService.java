package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IAgenceService {

    Agence addAgence(Agence agence);

    List<Agence> addAgences(List<Agence> agences);

    Agence updateAgence(Agence agence);

    List<Agence> retrieveAllAgences();

    Agence retrieveAgence(Long idAgence);

    void removeAgence(Long idAgence);
}
