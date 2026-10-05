package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> employes) {
        List<Employe> saved = new ArrayList<>();
        employeRepository.saveAll(employes).forEach(saved::add);
        return saved;
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        retrieveEmploye(employe.getIdEmploye());
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> retrieveAllEmployes() {
        List<Employe> employes = new ArrayList<>();
        employeRepository.findAll().forEach(employes::add);
        return employes;
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return employeRepository.findById(idEmploye)
                .orElseThrow(() -> new IllegalArgumentException("Employe introuvable : " + idEmploye));
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }
}
