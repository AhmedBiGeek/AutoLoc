package tn.esprit.autoloc;

import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@Component
public class VehiculeDataLoader implements CommandLineRunner {

    private final VehiculeRepository vehiculeRepository;
    private final EntityManager entityManager;

    public VehiculeDataLoader(VehiculeRepository vehiculeRepository, EntityManager entityManager) {
        this.vehiculeRepository = vehiculeRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (vehiculeRepository.count() > 0) {
            return;
        }

        Agence agence = new Agence();
        agence.setNom("AutoLoc Centre");
        agence.setVille("Tunis");
        agence.setAdresse("Avenue Habib Bourguiba");
        agence.setTelephone("71000000");
        entityManager.persist(agence);

        vehiculeRepository.save(vehicule("123TU4567", "Renault", "Clio",
                CategorieVehicule.CITADINE, "45.00", StatutVehicule.DISPONIBLE, agence));
        vehiculeRepository.save(vehicule("456TU8901", "Peugeot", "308",
                CategorieVehicule.BERLINE, "70.00", StatutVehicule.DISPONIBLE, agence));
        vehiculeRepository.save(vehicule("789TU2345", "Dacia", "Duster",
                CategorieVehicule.SUV, "85.00", StatutVehicule.MAINTENANCE, agence));
    }

    private Vehicule vehicule(String immatriculation, String marque, String modele,
                              CategorieVehicule categorie, String tarif, StatutVehicule statut,
                              Agence agence) {
        Vehicule vehicule = new Vehicule();
        vehicule.setImmatriculation(immatriculation);
        vehicule.setMarque(marque);
        vehicule.setModele(modele);
        vehicule.setCategorie(categorie);
        vehicule.setTarifJournalier(new BigDecimal(tarif));
        vehicule.setStatut(statut);
        vehicule.setAgence(agence);
        return vehicule;
    }
}
