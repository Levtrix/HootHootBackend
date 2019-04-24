package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "waarneming")
public class Waarneming {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "datumwaaarneming", nullable = false)
    private Date datumWaarneming;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vogelid", insertable = false, updatable = false)
    private Vogel vogel;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "soortwaarneming")
    private SoortWaarneming soortWaarneming;

    // Getters and setters
    public int getId() {
        return id;
    }

    public Date getDatumWaarneming() {
        return datumWaarneming;
    }

    public void setDatumWaarneming(Date datumWaarneming) {
        this.datumWaarneming = datumWaarneming;
    }

    public Vogel getVogel() {
        return vogel;
    }

    public void setVogel(Vogel vogel) {
        this.vogel = vogel;
    }

    public SoortWaarneming getSoortWaarneming() {
        return soortWaarneming;
    }

    public void setSoortWaarneming(SoortWaarneming soortWaarneming) {
        this.soortWaarneming = soortWaarneming;
    }

    // Constructors
    public Waarneming() {

    }

    public Waarneming(Date datumWaarneming, Vogel vogel, SoortWaarneming soortWaarneming) {
        this.datumWaarneming = datumWaarneming;
        this.vogel = vogel;
        this.soortWaarneming = soortWaarneming;
    }

    public Waarneming(int id, Date datumWaarneming, Vogel vogel, SoortWaarneming soortWaarneming) {
        this.id = id;
        this.datumWaarneming = datumWaarneming;
        this.vogel = vogel;
        this.soortWaarneming = soortWaarneming;
    }

    // Methods
    public int PuntenWaarneming() {
        return this.soortWaarneming.ordinal() + 1;
    }

    @Override
    public String toString() {
        return this.vogel.toString();
    }
}
