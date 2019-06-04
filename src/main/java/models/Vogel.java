package models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vogel")
public class Vogel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "vogelsoort", nullable = false)
    private String vogelsoort;

    @Column(name = "afkorting", nullable = false)
    private String afkorting;

    @Column(name = "startbroedperiode", nullable = false)
    private Date startBroedperiode;

    @Column(name = "eindbroedperiode", nullable = false)
    private Date eindBroedPeriode;

    @Column(name = "puntenbroedpaar", nullable = false)
    private int puntenBroedpaar;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "vogelwaarnemingid")
    @Fetch(FetchMode.SELECT)
    private List<Waarneming> waarnemingen = new ArrayList<>();

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getVogelsoort() {
        return vogelsoort;
    }

    public void setVogelsoort(String vogelsoort) {
        this.vogelsoort = vogelsoort;
    }

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    public Date getStartBroedperiode() {
        return startBroedperiode;
    }

    public void setStartBroedperiode(Date startBroedperiode) {
        this.startBroedperiode = startBroedperiode;
    }

    public Date getEindBroedPeriode() {
        return eindBroedPeriode;
    }

    public void setEindBroedPeriode(Date eindBroedPeriode) {
        this.eindBroedPeriode = eindBroedPeriode;
    }

    public int getPuntenBroedpaar() {
        return puntenBroedpaar;
    }

    public void setPuntenBroedpaar(int puntenBroedpaar) {
        this.puntenBroedpaar = puntenBroedpaar;
    }

    public List<Waarneming> getWaarnemingen() {
        return Collections.unmodifiableList(this.waarnemingen);
    }

    public void setWaarnemingen(List<Waarneming> waarnemingen) {
        this.waarnemingen.clear();
        this.waarnemingen.addAll(waarnemingen);
    }

    // Constructors
    public Vogel() {

    }

    public Vogel(String vogelsoort, String afkorting, Date startBroedperiode, Date eindBroedPeriode, int puntenBroedpaar) {
        this.vogelsoort = vogelsoort;
        this.afkorting = afkorting;
        this.startBroedperiode = startBroedperiode;
        this.eindBroedPeriode = eindBroedPeriode;
        this.puntenBroedpaar = puntenBroedpaar;
    }

    public Vogel(int id, String vogelsoort, String afkorting, Date startBroedperiode, Date eindBroedPeriode, int puntenBroedpaar, List<Waarneming> waarnemingen) {
        this.id = id;
        this.vogelsoort = vogelsoort;
        this.afkorting = afkorting;
        this.startBroedperiode = startBroedperiode;
        this.eindBroedPeriode = eindBroedPeriode;
        this.puntenBroedpaar = puntenBroedpaar;
        this.waarnemingen = waarnemingen;
    }

    // Methods
    public void addWaarneming(Waarneming waarneming) {
        this.waarnemingen.add(waarneming);
    }

    public void removeWaarneming(Waarneming waarneming) {
        this.waarnemingen.remove(waarneming);
    }

    @Override
    public String toString() {
        return this.afkorting;
    }
}
