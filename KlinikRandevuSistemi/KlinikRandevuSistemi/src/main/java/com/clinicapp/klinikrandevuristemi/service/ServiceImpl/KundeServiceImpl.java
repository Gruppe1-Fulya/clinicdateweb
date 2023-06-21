package com.clinicapp.klinikrandevuristemi.service.ServiceImpl;

import com.clinicapp.klinikrandevuristemi.model.Kunde;
import com.clinicapp.klinikrandevuristemi.repository.KundeRepository;
import com.clinicapp.klinikrandevuristemi.service.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KundeServiceImpl implements KundenService {


    private KundeRepository kundeRepository;

    @Autowired
    public void setKundeRepository(KundeRepository kundeRepository){
        this.kundeRepository=kundeRepository;
    }


    @Override
    public Optional<Kunde> findKundeByBurgerID(Long BurgerID) {
        return kundeRepository.findById(BurgerID);
    }

    @Override
    public void saveKunde(Kunde kunde) {
        kundeRepository.saveKunde(kunde);
    }

    @Override
    public Kunde updateKunde(Kunde kunde) {
        return kundeRepository.updateKunde(kunde);
    }

    @Override
    public List<Kunde> findAll() {
        return kundeRepository.findAll();
    }

    @Override
    public void deleteKundeByBurgerID(Long BurgerID){ kundeRepository.deleteKundeByBurgerID(BurgerID);}
}
