package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        List<Vehicule> saved = new ArrayList<>();
        vehiculeRepository.saveAll(vehicules).forEach(saved::add);
        return saved;
    }

    @Override
    public Vehicule updateVehicule(Vehicule vehicule) {
        retrieveVehicule(vehicule.getIdVehicule());
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        List<Vehicule> vehicules = new ArrayList<>();
        vehiculeRepository.findAll().forEach(vehicules::add);
        return vehicules;
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new IllegalArgumentException("Vehicule introuvable : " + idVehicule));
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }
}
