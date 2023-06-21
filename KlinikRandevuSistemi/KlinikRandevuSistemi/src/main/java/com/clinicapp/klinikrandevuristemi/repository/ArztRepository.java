package com.clinicapp.klinikrandevuristemi.repository;

import com.clinicapp.klinikrandevuristemi.model.Arzt;

import java.util.List;
import java.util.Optional;


public interface ArztRepository{

    Optional<Arzt> findByID(Integer ID);

    void addMultipleArzte(List<Arzt> arzteList);

    List<Arzt> findAll();

    Arzt updateArzt(Arzt arzt);
}
