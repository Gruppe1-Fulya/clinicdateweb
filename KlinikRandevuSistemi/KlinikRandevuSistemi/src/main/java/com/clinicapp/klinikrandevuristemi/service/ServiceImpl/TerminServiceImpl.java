package com.clinicapp.klinikrandevuristemi.service.ServiceImpl;

import com.clinicapp.klinikrandevuristemi.model.Termin;
import com.clinicapp.klinikrandevuristemi.repository.TerminRepository;
import com.clinicapp.klinikrandevuristemi.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TerminServiceImpl implements TerminService {

    private TerminRepository terminRepository;

    @Autowired
    public void setTerminRepository(TerminRepository terminRepository){
        this.terminRepository=terminRepository;
    }

    @Override
    public Optional<Termin> findTerminByID(Long ID) {
        return terminRepository.findById(ID);
    }

    @Override
    public void saveTermin(Termin termin) {
        terminRepository.saveTermin(termin);

    }

    @Override
    public List<Termin> findAll() {
        return terminRepository.findAll();
    }

    @Override
    public Termin updateTermin(Termin termin) {
        return terminRepository.updateTermin(termin);
    }

    @Override
    public void deleteTerminById(Long ID){
        terminRepository.deleteTerminById(ID);
    }
}
