package com.clinicapp.klinikrandevuristemi.service.ServiceImpl;

import com.clinicapp.klinikrandevuristemi.model.Arzt;
import com.clinicapp.klinikrandevuristemi.repository.ArztRepository;
import com.clinicapp.klinikrandevuristemi.service.ArztService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArztServiceImpl implements ArztService {

    private ArztRepository arztRepository;

    @Autowired
    public void setArztRepository(ArztRepository arztRepository){
        this.arztRepository=arztRepository;
    }

    @Override
    public void addMultipleArzte(List<Arzt> arzteList) {
        arzteList = new ArrayList<>();
        arzteList.add(new Arzt(1, "Irem Nisa", "Kaplan"));
        arzteList.add(new Arzt(2, "Ayse Nur", "Oyzu"));
        arzteList.add(new Arzt(3, "Raziye", "Uzun"));
        arztRepository.addMultipleArzte(arzteList);
    }

    @Override
    public Optional<Arzt> findArztByID(Integer ID) {
        return arztRepository.findByID(ID);
    }

    @Override
    public List<Arzt> findAll() {
        return arztRepository.findAll();
    }

    @Override
    public Arzt updateArzt(Arzt arzt) {
        return arztRepository.updateArzt(arzt);
    }
}
