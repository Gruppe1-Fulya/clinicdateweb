package com.clinicapp.klinikrandevuristemi.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.Set;


@Entity
@Table(name="KUNDE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"BURGER_ID"}) // burgeridler ayni ise kisi ayni kisi olur
public class Kunde {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="KUNDE_ID")
    private Long ID;

    @Column(name = "KUNDE_NAME")
    private String name;

    @Column(name ="KUNDE_NACHNAME")
    private String nachname;

    @Column(name="BURGER_ID")
    private Long BurgerID;

    @Column(name ="TELNUMMER")
    private String telnummer;

    @Column(name ="ANMERKUNG")
    private String anmerkung;

    @Column(name="STATUS")
    private String status; //manytomant yaptigimizda kullanamiyoruz bunu ogrenmek gerekiyor

    // buraya bır terminlist eklemk lazım kundednin butun terminilerini orda tutmak icin
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="TERMINEN", joinColumns = @JoinColumn(name="KUNDE_ID"), inverseJoinColumns = @JoinColumn(name="TERMIN_ID"))
    private Set<Termin> terminen;

    public Kunde( Long ID,String name, String nachname, Long burgerID, String telnummer, String anmerkung, String status, Set<Termin> terminen) {
        this.ID = ID;
        this.name = name;
        this.nachname = nachname;
        this.BurgerID = burgerID;
        this.telnummer = telnummer;
        this.anmerkung = anmerkung;
        this.status = status;
        this.terminen = terminen;
    }

    public Kunde( String name, String nachname, Long burgerID, String telnummer, String anmerkung, String status) {
        this.name = name;
        this.nachname = nachname;
        this.BurgerID = burgerID;
        this.telnummer = telnummer;
        this.anmerkung = anmerkung;
        this.status = status;
    }



}
