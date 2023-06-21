package com.clinicapp.klinikrandevuristemi.edit;


import com.clinicapp.klinikrandevuristemi.model.Termin;
import com.clinicapp.klinikrandevuristemi.service.TerminService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddTerminTest {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TerminService terminService;

    @Before
    public void setUp(){
        Termin termin = new Termin(1L,
                2,
                1,
                "Vorbesprechung",
                "10.07.2023");

        terminService.saveTermin(termin);
    }

    @Test
    public void testGetTerminById(){
        Long terminId = terminService.findAll().get(0).getID();

        // Termin servisinde bulunan findTerminByID metodu ile oluşturulan termin nesnesini alıyoruz
        Optional<Termin> termin = terminService.findTerminByID(terminId);

        assertThat(termin).isPresent();
        // Dönen nesnenin özelliklerini test ediyoruz
        assertThat(termin.get().getID()).isEqualTo(1L);
        assertThat(termin.get().getZimmerID()).isEqualTo(2);
        assertThat(termin.get().getKundeID()).isEqualTo(1);
        assertThat(termin.get().getType()).isEqualTo("Vorbesprechung");
        assertThat(termin.get().getDatum()).isEqualTo("10.07.2023");
    }

    @After
    public void cleanUp(){
        Long terminID = terminService.findAll().get(0).getID();
        Optional<Termin> servedTermin = terminService.findTerminByID(terminID);

        terminService.deleteTerminById(terminID);
    }

}
