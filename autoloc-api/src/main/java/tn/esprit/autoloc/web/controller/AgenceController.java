package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agence")
public class AgenceController {

    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    // http://localhost:8080/agence/add-agence
    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    // http://localhost:8080/agence/add-agences
    @PostMapping("/add-agences")
    public List<Agence> addAgences(@RequestBody List<Agence> agences) {
        return agenceService.addAgences(agences);
    }

    // http://localhost:8080/agence/update-agence
    @PutMapping("/update-agence")
    public Agence updateAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    // http://localhost:8080/agence/retrieve-all-agences
    @GetMapping("/retrieve-all-agences")
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    // http://localhost:8080/agence/retrieve-agence/1
    @GetMapping("/retrieve-agence/{agence-id}")
    public Agence retrieveAgence(@PathVariable("agence-id") Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    // http://localhost:8080/agence/remove-agence/1
    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long idAgence) {
        agenceService.removeAgence(idAgence);
    }
}
