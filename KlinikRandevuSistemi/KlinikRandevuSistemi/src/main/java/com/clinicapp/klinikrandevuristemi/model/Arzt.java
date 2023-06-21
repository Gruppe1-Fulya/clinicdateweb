package com.clinicapp.klinikrandevuristemi.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="ARZT")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Arzt {

    @Id
    @Column(name ="ARZT_ID")
    private Integer ID;

    @Column(name="ARZT_NAME")
    private String arztname;

    @Column(name="ARZT_NACHNAME")
    private String arztnachname;


    // sistemeki doktorlar burda eklenmesi lazim yani burda calisip direkt secimlerde gozukmeli
}
