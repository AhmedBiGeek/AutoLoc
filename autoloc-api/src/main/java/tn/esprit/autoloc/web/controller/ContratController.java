package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    private final IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    // http://localhost:8080/contrat/add-contrat
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    // http://localhost:8080/contrat/add-contrats
    @PostMapping("/add-contrats")
    public List<Contrat> addContrats(@RequestBody List<Contrat> contrats) {
        return contratService.addContrats(contrats);
    }

    // http://localhost:8080/contrat/update-contrat
    @PutMapping("/update-contrat")
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }

    // http://localhost:8080/contrat/retrieve-all-contrats
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> retrieveAllContrats() {
        return contratService.retrieveAllContrats();
    }

    // http://localhost:8080/contrat/retrieve-contrat/1
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Long idContrat) {
        return contratService.retrieveContrat(idContrat);
    }

    // http://localhost:8080/contrat/remove-contrat/1
    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Long idContrat) {
        contratService.removeContrat(idContrat);
    }
}
