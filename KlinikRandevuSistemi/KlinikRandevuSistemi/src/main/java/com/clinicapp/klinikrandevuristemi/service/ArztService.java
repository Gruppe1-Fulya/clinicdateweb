package com.clinicapp.klinikrandevuristemi.service;


import com.clinicapp.klinikrandevuristemi.model.Arzt;



import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ArztService {

     void addMultipleArzte(List<Arzt> arzteList);
     Optional<Arzt> findArztByID(Integer ID);

     List<Arzt> findAll();

     Arzt updateArzt(Arzt arzt);


}
