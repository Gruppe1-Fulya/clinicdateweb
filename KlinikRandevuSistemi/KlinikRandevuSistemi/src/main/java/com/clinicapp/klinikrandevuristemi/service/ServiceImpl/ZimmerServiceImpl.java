package com.clinicapp.klinikrandevuristemi.service.ServiceImpl;

import com.clinicapp.klinikrandevuristemi.model.Zimmer;
import com.clinicapp.klinikrandevuristemi.repository.ZimmerRepository;
import com.clinicapp.klinikrandevuristemi.service.ZimmerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ZimmerServiceImpl implements ZimmerService {

    private  ZimmerRepository zimmerRepository;

    @Autowired
    public ZimmerServiceImpl(ZimmerRepository zimmerRepository){
        this.zimmerRepository=zimmerRepository;
    }

    @Override
    public void addMultipleZimmer(List<Zimmer> zimmerList) {
        zimmerList= new ArrayList<>();
        zimmerList.add(new Zimmer(1,"zimmer1"));
        zimmerList.add(new Zimmer(2,"zimmer2"));
        zimmerList.add(new Zimmer(3,"Zimmer3"));
        zimmerRepository.addMultipleZimmer(zimmerList);
    }

    @Override
    public Optional<Zimmer> findZimmerByID(Integer ID) {
        return zimmerRepository.findById(ID);
    }

    @Override
    public List<Zimmer> findAll() {
        return zimmerRepository.findAll();
    }

    @Override
    public Zimmer updateZimmer(Zimmer zimmer) {
        return zimmerRepository.updateZimmer(zimmer);
    }
}
