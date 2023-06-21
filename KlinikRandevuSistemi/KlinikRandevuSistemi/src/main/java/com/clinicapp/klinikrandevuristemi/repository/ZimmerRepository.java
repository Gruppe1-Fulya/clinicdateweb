package com.clinicapp.klinikrandevuristemi.repository;

import com.clinicapp.klinikrandevuristemi.model.Zimmer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ZimmerRepository {

    Optional<Zimmer> findById(Integer ID);
    void addMultipleZimmer(List<Zimmer> zimmerList);

    List<Zimmer> findAll();

    Zimmer updateZimmer(Zimmer zimmer);

}
