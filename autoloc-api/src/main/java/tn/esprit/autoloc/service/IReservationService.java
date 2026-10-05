package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);

    List<Reservation> addReservations(List<Reservation> reservations);

    Reservation updateReservation(Reservation reservation);

    List<Reservation> retrieveAllReservations();

    Reservation retrieveReservation(Long idReservation);

    void removeReservation(Long idReservation);
}
