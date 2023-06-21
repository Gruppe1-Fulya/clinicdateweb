package com.clinicapp.klinikrandevuristemi.edit;


import com.clinicapp.klinikrandevuristemi.model.Kunde;
import com.clinicapp.klinikrandevuristemi.service.KundenService;
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
public class AddKundeTest {

    @Autowired
    private KundenService kundenService;

    @Before
    public void setUp(){
        Kunde kunde = new Kunde("Fatma",
                "Uzun",
                369852147L,
                "5597689098",
                "Die Kundin mochte nur eine Vorbesprechung",
                "Vorbesprechung");

        kundenService.saveKunde(kunde);
    }
    @Test
    public void testGetKundeByBurgerID(){
        // Önceden kaydedilen müşteriye ait BurgerID'yi alıyoruz
        Long kundeBurgerID = kundenService.findAll().get(3).getBurgerID();

        // Önceden kaydedilen müşterinin BurgerID'yi kullanarak ilgili nesneyi getiriyoruz
        Optional<Kunde> kunde = kundenService.findKundeByBurgerID(kundeBurgerID);

        assertThat(kunde.isPresent());
        // Dönen nesnenin özelliklerini test ediyoruz
        assertThat(kunde.get().getName()).isEqualTo("Fatma");
        assertThat(kunde.get().getNachname()).isEqualTo("Uzun");
        assertThat(kunde.get().getTelnummer()).isEqualTo("5597689098");
        assertThat(kunde.get().getStatus()).isEqualTo("Vorbesprechung");
    }

    @After
    public void cleanUp(){
        Long BurgerID = kundenService.findAll().get(3).getBurgerID();
        Optional<Kunde> kunde = kundenService.findKundeByBurgerID(BurgerID);

        kundenService.deleteKundeByBurgerID(BurgerID);
    }
}
