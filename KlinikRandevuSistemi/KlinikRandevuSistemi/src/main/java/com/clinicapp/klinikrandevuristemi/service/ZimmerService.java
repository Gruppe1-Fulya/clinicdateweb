package com.clinicapp.klinikrandevuristemi.service;


import com.clinicapp.klinikrandevuristemi.model.Termin;
import org.springframework.stereotype.Service;
import com.clinicapp.klinikrandevuristemi.model.Zimmer;

import java.util.Optional;
import java.util.List;

public interface ZimmerService {

    void addMultipleZimmer(List<Zimmer> zimmerList);

    Optional<Zimmer> findZimmerByID(Integer ID);

    List<Zimmer> findAll();
     Zimmer updateZimmer(Zimmer zimmer);
}
