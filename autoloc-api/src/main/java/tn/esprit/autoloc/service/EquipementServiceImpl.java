package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipementServiceImpl implements IEquipementService {

    private final EquipementRepository equipementRepository;

    public EquipementServiceImpl(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> addEquipements(List<Equipement> equipements) {
        List<Equipement> saved = new ArrayList<>();
        equipementRepository.saveAll(equipements).forEach(saved::add);
        return saved;
    }

    @Override
    public Equipement updateEquipement(Equipement equipement) {
        retrieveEquipement(equipement.getIdEquipement());
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> retrieveAllEquipements() {
        List<Equipement> equipements = new ArrayList<>();
        equipementRepository.findAll().forEach(equipements::add);
        return equipements;
    }

    @Override
    public Equipement retrieveEquipement(Long idEquipement) {
        return equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new IllegalArgumentException("Equipement introuvable : " + idEquipement));
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }
}
