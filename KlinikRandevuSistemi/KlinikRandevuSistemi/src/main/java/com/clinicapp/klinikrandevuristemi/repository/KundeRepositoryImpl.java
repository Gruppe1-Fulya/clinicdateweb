package com.clinicapp.klinikrandevuristemi.repository;

import com.clinicapp.klinikrandevuristemi.model.Kunde;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class KundeRepositoryImpl implements KundeRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<Kunde> findById(Long BurgerID) {
        Kunde kunde = entityManager.find(Kunde.class,BurgerID);
        return Optional.ofNullable(kunde);
    }

    @Override
    public void saveKunde(Kunde kunde) {
        entityManager.persist(kunde);
    }

    @Override
    public Kunde updateKunde(Kunde kunde) {
        return entityManager.merge(kunde);
    }

    @Override
    public List<Kunde> findAll() {
        return entityManager.createQuery("FROM Kunde", Kunde.class).getResultList();
    }

    @Override
    public void deleteKundeByBurgerID(Long BurgerID){
        Kunde kunde = entityManager.find(Kunde.class, BurgerID);
        entityManager.remove(kunde);
    }
}

