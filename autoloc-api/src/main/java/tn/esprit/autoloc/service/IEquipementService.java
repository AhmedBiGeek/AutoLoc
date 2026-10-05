package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipementService {

    Equipement addEquipement(Equipement equipement);

    List<Equipement> addEquipements(List<Equipement> equipements);

    Equipement updateEquipement(Equipement equipement);

    List<Equipement> retrieveAllEquipements();

    Equipement retrieveEquipement(Long idEquipement);

    void removeEquipement(Long idEquipement);
}
