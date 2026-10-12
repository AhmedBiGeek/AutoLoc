package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    public MaintenanceController(IMaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    // http://localhost:8080/maintenance/add-maintenance
    @PostMapping("/add-maintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.addMaintenance(maintenance);
    }

    // http://localhost:8080/maintenance/add-maintenances
    @PostMapping("/add-maintenances")
    public List<Maintenance> addMaintenances(@RequestBody List<Maintenance> maintenances) {
        return maintenanceService.addMaintenances(maintenances);
    }

    // http://localhost:8080/maintenance/update-maintenance
    @PutMapping("/update-maintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.updateMaintenance(maintenance);
    }

    // http://localhost:8080/maintenance/retrieve-all-maintenances
    @GetMapping("/retrieve-all-maintenances")
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    // http://localhost:8080/maintenance/retrieve-maintenance/1
    @GetMapping("/retrieve-maintenance/{maintenance-id}")
    public Maintenance retrieveMaintenance(@PathVariable("maintenance-id") Long idMaintenance) {
        return maintenanceService.retrieveMaintenance(idMaintenance);
    }

    // http://localhost:8080/maintenance/remove-maintenance/1
    @DeleteMapping("/remove-maintenance/{maintenance-id}")
    public void removeMaintenance(@PathVariable("maintenance-id") Long idMaintenance) {
        maintenanceService.removeMaintenance(idMaintenance);
    }
}
