package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {

    private final IPaiementService paiementService;

    public PaiementController(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    // http://localhost:8080/paiement/add-paiement
    @PostMapping("/add-paiement")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    // http://localhost:8080/paiement/add-paiements
    @PostMapping("/add-paiements")
    public List<Paiement> addPaiements(@RequestBody List<Paiement> paiements) {
        return paiementService.addPaiements(paiements);
    }

    // http://localhost:8080/paiement/update-paiement
    @PutMapping("/update-paiement")
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.updatePaiement(paiement);
    }

    // http://localhost:8080/paiement/retrieve-all-paiements
    @GetMapping("/retrieve-all-paiements")
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    // http://localhost:8080/paiement/retrieve-paiement/1
    @GetMapping("/retrieve-paiement/{paiement-id}")
    public Paiement retrievePaiement(@PathVariable("paiement-id") Long idPaiement) {
        return paiementService.retrievePaiement(idPaiement);
    }

    // http://localhost:8080/paiement/remove-paiement/1
    @DeleteMapping("/remove-paiement/{paiement-id}")
    public void removePaiement(@PathVariable("paiement-id") Long idPaiement) {
        paiementService.removePaiement(idPaiement);
    }
}
