package tn.esprit.autoloc.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    private final IEmployeService employeService;

    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    // http://localhost:8080/employe/add-employe
    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    // http://localhost:8080/employe/add-employes
    @PostMapping("/add-employes")
    public List<Employe> addEmployes(@RequestBody List<Employe> employes) {
        return employeService.addEmployes(employes);
    }

    // http://localhost:8080/employe/update-employe
    @PutMapping("/update-employe")
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeService.updateEmploye(employe);
    }

    // http://localhost:8080/employe/retrieve-all-employes
    @GetMapping("/retrieve-all-employes")
    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    // http://localhost:8080/employe/retrieve-employe/1
    @GetMapping("/retrieve-employe/{employe-id}")
    public Employe retrieveEmploye(@PathVariable("employe-id") Long idEmploye) {
        return employeService.retrieveEmploye(idEmploye);
    }

    // http://localhost:8080/employe/remove-employe/1
    @DeleteMapping("/remove-employe/{employe-id}")
    public void removeEmploye(@PathVariable("employe-id") Long idEmploye) {
        employeService.removeEmploye(idEmploye);
    }
}
