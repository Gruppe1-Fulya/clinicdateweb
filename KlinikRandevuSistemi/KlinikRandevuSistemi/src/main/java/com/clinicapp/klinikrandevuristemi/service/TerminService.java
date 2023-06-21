package com.clinicapp.klinikrandevuristemi.service;

import com.clinicapp.klinikrandevuristemi.model.Termin;

import java.util.List;
import java.util.Optional;


public interface TerminService {

    Optional<Termin> findTerminByID(Long ID);

    void saveTermin(Termin termin);
    List<Termin> findAll();
    Termin updateTermin(Termin termin);

     void deleteTerminById(Long ID);

}
