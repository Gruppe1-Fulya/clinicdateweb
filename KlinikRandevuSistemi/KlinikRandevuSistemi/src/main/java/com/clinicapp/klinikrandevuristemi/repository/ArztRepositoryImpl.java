package com.clinicapp.klinikrandevuristemi.repository;

import com.clinicapp.klinikrandevuristemi.model.Arzt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArztRepositoryImpl implements ArztRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ArztRepositoryImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Arzt> findAll(){
        return entityManager.createQuery("FROM Arzt ", Arzt.class).getResultList();
    }
    @Override
    public Optional<Arzt> findByID(Integer ID) {
        Arzt arzt = entityManager.find(Arzt.class, ID);
        return Optional.ofNullable(arzt);
    }

    @Override
    public void addMultipleArzte(List<Arzt> arzteList) {
        for (Arzt arzt : arzteList) {
            entityManager.persist(arzt);
        }
    }
    @Override
    public Arzt updateArzt(Arzt arzt){
        return entityManager.merge(arzt);
    }

}
