package com.clinicapp.klinikrandevuristemi.configuration;

import com.clinicapp.klinikrandevuristemi.model.Kunde;
import com.clinicapp.klinikrandevuristemi.model.Termin;
import com.clinicapp.klinikrandevuristemi.repository.ArztRepository;
import com.clinicapp.klinikrandevuristemi.repository.KundeRepository;
import com.clinicapp.klinikrandevuristemi.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Component
public class DataLoader implements ApplicationRunner {

    private final KundeRepository kundeRepository;
    private final TerminRepository terminRepository;
    private final ArztRepository arztRepository;

    @Autowired
    public DataLoader(KundeRepository kundeRepository, TerminRepository terminRepository, ArztRepository arztRepository){
        this.arztRepository=arztRepository;
        this.terminRepository=terminRepository;
        this.kundeRepository = kundeRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Kunde kunde = new Kunde();
        Termin termin = new Termin();
        terminRepository.saveTermin(termin);
        kundeRepository.saveKunde(kunde);


        Set<Termin> terminSet = new HashSet<>(Arrays.asList(termin, termin));


    }
}
