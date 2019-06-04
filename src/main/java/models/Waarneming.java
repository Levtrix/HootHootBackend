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

    //TODO: seperate lat and lng
    @Column(name = "latitude_longitude")
    private int latlng;

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

    public int getLatlng() {
        return latlng;
    }

    public void setLatlng(int latlng) {
        this.latlng = latlng;
    }

    // Constructors
    public Waarneming() {

    }

    public Waarneming(Date datumWaarneming, Vogel vogel, SoortWaarneming soortWaarneming, int latlng) {
        this.datumWaarneming = datumWaarneming;
        this.vogel = vogel;
        this.soortWaarneming = soortWaarneming;
        this.latlng = latlng;
    }

    public Waarneming(int id, Date datumWaarneming, Vogel vogel, SoortWaarneming soortWaarneming, int latlng) {
        this.id = id;
        this.datumWaarneming = datumWaarneming;
        this.vogel = vogel;
        this.soortWaarneming = soortWaarneming;
        this.latlng = latlng;
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
