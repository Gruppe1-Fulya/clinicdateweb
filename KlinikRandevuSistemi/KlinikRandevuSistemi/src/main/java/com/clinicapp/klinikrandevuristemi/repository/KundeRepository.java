package com.clinicapp.klinikrandevuristemi.repository;

import com.clinicapp.klinikrandevuristemi.model.Kunde;

import java.util.List;
import java.util.Optional;


public interface KundeRepository {

    Optional<Kunde> findById(Long BurgerID);

    void saveKunde(Kunde kunde);

    Kunde updateKunde(Kunde kunde);

    List<Kunde> findAll();

    void deleteKundeByBurgerID(Long BurgerID);


}
