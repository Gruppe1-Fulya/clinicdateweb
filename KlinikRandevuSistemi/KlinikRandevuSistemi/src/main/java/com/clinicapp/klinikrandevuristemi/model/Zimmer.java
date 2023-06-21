package com.clinicapp.klinikrandevuristemi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="ZIMMER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Zimmer {

    @Id
    @Column(name="ZIMMER_ID")
    private Integer ID;// zaten uc tane oda var

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="TERMIN_ID", joinColumns = @JoinColumn(name="ZIMMER_ID"), inverseJoinColumns =@JoinColumn(name="TERMIN_ID"))
    private Set<Termin> terminId;// Randevu id ile ayni

    @Column(name="STATUS")
    @JoinTable()
    private String Status;

    @Column(name="ZIMMER_NAME")
    private String name;

    public Zimmer(Integer ID,String name) {
        this.ID=ID;
        this.name=name;
    }
}
