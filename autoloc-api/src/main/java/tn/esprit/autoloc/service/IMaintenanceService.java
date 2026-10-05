package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    Maintenance addMaintenance(Maintenance maintenance);

    List<Maintenance> addMaintenances(List<Maintenance> maintenances);

    Maintenance updateMaintenance(Maintenance maintenance);

    List<Maintenance> retrieveAllMaintenances();

    Maintenance retrieveMaintenance(Long idMaintenance);

    void removeMaintenance(Long idMaintenance);
}
