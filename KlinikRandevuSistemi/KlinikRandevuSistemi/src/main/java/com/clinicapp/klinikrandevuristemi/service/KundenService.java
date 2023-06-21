package com.clinicapp.klinikrandevuristemi.service;


import com.clinicapp.klinikrandevuristemi.model.Kunde;


import java.util.Optional;
import java.util.List;



public interface KundenService {

    Optional<Kunde> findKundeByBurgerID(Long BurgerID);

    void saveKunde(Kunde kunde);


    Kunde updateKunde(Kunde kunde);

    List<Kunde> findAll();
    void deleteKundeByBurgerID(Long BurgerID);
}
