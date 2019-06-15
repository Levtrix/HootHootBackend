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

    @Column(name = "latitude", columnDefinition = "Decimal(10,3)")
    private double lat;

    @Column(name = "longitude")
    private double lng;

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

    public double getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    // Constructors
    public Waarneming() {

    }

    public Waarneming(Date datumWaarneming, Vogel vogel, SoortWaarneming soortWaarneming, double lat, double lng) {
        this.datumWaarneming = datumWaarneming;
        this.vogel = vogel;
        this.soortWaarneming = soortWaarneming;
        this.lat = lat;
        this.lng = lng;
    }

    public Waarneming(int id, Date datumWaarneming, Vogel vogel, SoortWaarneming soortWaarneming, double lat, double lng) {
        this.id = id;
        this.datumWaarneming = datumWaarneming;
        this.vogel = vogel;
        this.soortWaarneming = soortWaarneming;
        this.lat = lat;
        this.lng = lng;
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
