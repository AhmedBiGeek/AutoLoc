package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        List<Reservation> saved = new ArrayList<>();
        reservationRepository.saveAll(reservations).forEach(saved::add);
        return saved;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        retrieveReservation(reservation.getIdReservation());
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> retrieveAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        return reservations;
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation)
                .orElseThrow(() -> new IllegalArgumentException("Reservation introuvable : " + idReservation));
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}
