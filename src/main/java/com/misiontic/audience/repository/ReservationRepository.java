package com.misiontic.audience.repository;

import com.misiontic.audience.entities.Audience;
import com.misiontic.audience.entities.Reservation;
import com.misiontic.audience.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public  List<Reservation> getDatesReport(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<Reservation> getReservationStatusReport(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Object[]> getTopClients(){
        return reservationCrudRepository.getTopClients();
    }
}
