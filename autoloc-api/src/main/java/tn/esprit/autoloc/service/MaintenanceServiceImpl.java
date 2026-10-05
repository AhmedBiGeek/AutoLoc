package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> addMaintenances(List<Maintenance> maintenances) {
        List<Maintenance> saved = new ArrayList<>();
        maintenanceRepository.saveAll(maintenances).forEach(saved::add);
        return saved;
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        retrieveMaintenance(maintenance.getIdMaintenance());
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        List<Maintenance> maintenances = new ArrayList<>();
        maintenanceRepository.findAll().forEach(maintenances::add);
        return maintenances;
    }

    @Override
    public Maintenance retrieveMaintenance(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance)
                .orElseThrow(() -> new IllegalArgumentException("Maintenance introuvable : " + idMaintenance));
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }
}
