package com.clinicapp.klinikrandevuristemi.repository;

import com.clinicapp.klinikrandevuristemi.model.Termin;

import java.util.List;
import java.util.Optional;


public interface TerminRepository{

    Optional<Termin> findById(Long ID);
    // burdaki ID termin ID ama onu ozellestirmek gerekebilir

    List<Termin> findAll();

    void saveTermin(Termin termin);

    Termin updateTermin(Termin termin);

    public void deleteTerminById(Long ID);

    void deleteKundeByBurgerID(Long BurgerID);

}