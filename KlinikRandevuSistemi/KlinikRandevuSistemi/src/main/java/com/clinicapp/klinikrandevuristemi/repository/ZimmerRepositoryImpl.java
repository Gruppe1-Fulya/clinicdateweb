package com.clinicapp.klinikrandevuristemi.repository;

import com.clinicapp.klinikrandevuristemi.model.Zimmer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ZimmerRepositoryImpl implements ZimmerRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Optional<Zimmer> findById(Integer ID) {
        Zimmer zimmer = entityManager.find(Zimmer.class,ID);
        return Optional.ofNullable(zimmer);
    }

    @Override
    public void addMultipleZimmer(List<Zimmer> zimmerList) {
        for (Zimmer zimmer : zimmerList) {
            entityManager.persist(zimmer);
        }
    }

    @Override
    public List<Zimmer> findAll() {
        return entityManager.createQuery("FROM Zimmer ", Zimmer.class).getResultList();
    }

    @Override
    public Zimmer updateZimmer(Zimmer zimmer) {
        return entityManager.merge(zimmer);
    }
}
