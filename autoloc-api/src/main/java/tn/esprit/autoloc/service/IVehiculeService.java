package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {

    Vehicule addVehicule(Vehicule vehicule);

    List<Vehicule> addVehicules(List<Vehicule> vehicules);

    Vehicule updateVehicule(Vehicule vehicule);

    List<Vehicule> retrieveAllVehicules();

    Vehicule retrieveVehicule(Long idVehicule);

    void removeVehicule(Long idVehicule);
}
