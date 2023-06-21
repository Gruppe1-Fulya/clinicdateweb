package com.clinicapp.klinikrandevuristemi.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="TERMIN")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of={"ID"})
@NoArgsConstructor
@AllArgsConstructor
public class Termin {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="TERMIN_ID")
    private Long ID;

    // bir kundenin birden fazla termini olabilir
    @Column(name="KUNDE_ID")
    private Long kundeID;
    @Column(name="ZIMMER_ID")
    private Integer zimmerID;
    @Column(name="ARZT_ID")
    private Integer arztID;
    @Column(name="TYPE")
    private String type;
    @Column(name="DATUM")
    private String Datum;

    public Termin(Long ID, Long kundeID, Integer zimmerID, Integer arztID, String type, String datum) {
        this.ID = ID;
        this.kundeID = kundeID;
        this.zimmerID = zimmerID;
        this.arztID = arztID;
        this.type = type;
        this.Datum = datum;
    }

    public Termin( Long kundeID, Integer zimmerID, Integer arztID, String type, String datum) {
        this.kundeID = kundeID;
        this.zimmerID = zimmerID;
        this.arztID = arztID;
        this.type = type;
        this.Datum = datum;
    }
}
