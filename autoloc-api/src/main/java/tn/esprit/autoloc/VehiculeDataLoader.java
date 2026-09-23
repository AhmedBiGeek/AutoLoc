package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@Component
public class VehiculeDataLoader implements CommandLineRunner {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeDataLoader(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public void run(String... args) {
        if (vehiculeRepository.count() > 0) {
            return;
        }

        vehiculeRepository.save(new Vehicule(
                null, "123TU4567", "Renault", "Clio",
                CategorieVehicule.CITADINE, new BigDecimal("45.00"), StatutVehicule.DISPONIBLE));
        vehiculeRepository.save(new Vehicule(
                null, "456TU8901", "Peugeot", "308",
                CategorieVehicule.BERLINE, new BigDecimal("70.00"), StatutVehicule.DISPONIBLE));
        vehiculeRepository.save(new Vehicule(
                null, "789TU2345", "Dacia", "Duster",
                CategorieVehicule.SUV, new BigDecimal("85.00"), StatutVehicule.MAINTENANCE));
    }
}
