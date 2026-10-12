package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipement")
public class EquipementController {

    private final IEquipementService equipementService;

    public EquipementController(IEquipementService equipementService) {
        this.equipementService = equipementService;
    }

    // http://localhost:8080/equipement/add-equipement
    @PostMapping("/add-equipement")
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    // http://localhost:8080/equipement/add-equipements
    @PostMapping("/add-equipements")
    public List<Equipement> addEquipements(@RequestBody List<Equipement> equipements) {
        return equipementService.addEquipements(equipements);
    }

    // http://localhost:8080/equipement/update-equipement
    @PutMapping("/update-equipement")
    public Equipement updateEquipement(@RequestBody Equipement equipement) {
        return equipementService.updateEquipement(equipement);
    }

    // http://localhost:8080/equipement/retrieve-all-equipements
    @GetMapping("/retrieve-all-equipements")
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    // http://localhost:8080/equipement/retrieve-equipement/1
    @GetMapping("/retrieve-equipement/{equipement-id}")
    public Equipement retrieveEquipement(@PathVariable("equipement-id") Long idEquipement) {
        return equipementService.retrieveEquipement(idEquipement);
    }

    // http://localhost:8080/equipement/remove-equipement/1
    @DeleteMapping("/remove-equipement/{equipement-id}")
    public void removeEquipement(@PathVariable("equipement-id") Long idEquipement) {
        equipementService.removeEquipement(idEquipement);
    }
}
