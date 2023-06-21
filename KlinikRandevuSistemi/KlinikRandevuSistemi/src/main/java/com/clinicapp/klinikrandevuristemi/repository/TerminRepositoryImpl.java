package com.clinicapp.klinikrandevuristemi.repository;

import com.clinicapp.klinikrandevuristemi.model.Termin;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;


@Repository
public class TerminRepositoryImpl implements TerminRepository{

    @PersistenceContext
    private EntityManager entitiyManager;
    @Override
    public Optional<Termin> findById(Long ID) {
        return Optional.empty();
    }

    @Override
    public List<Termin> findAll() {
        return entitiyManager.createQuery("FROM Termin", Termin.class).getResultList();
    }

    @Override
    public void saveTermin(Termin termin) {
        entitiyManager.persist(termin);
    }

    @Override
    public Termin updateTermin(Termin termin) {
        return entitiyManager.merge(termin);
    }

    @Override
    public  void deleteTerminById(Long ID){
        Termin termin = entitiyManager.find(Termin.class,ID);
        entitiyManager.remove(termin);
    }

}
