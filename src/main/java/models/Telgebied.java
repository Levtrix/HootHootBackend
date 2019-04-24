package models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "telgebied")
public class Telgebied {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "naam", nullable = false)
    private String naam;

    @Column(name = "kaart", nullable = false)
    private String kaart;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "bezoekid")
    @Fetch(FetchMode.SELECT)
    private List<Bezoek> bezoeken = new ArrayList<>();

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getKaart() {
        return kaart;
    }

    public void setKaart(String kaart) {
        this.kaart = kaart;
    }

    public List<Bezoek> getBezoeken() {
        return Collections.unmodifiableList(this.bezoeken);
    }

    public void setBezoeken(List<Bezoek> bezoeken) {
        if (bezoeken.size() != 0) {
            this.bezoeken.clear();
            this.bezoeken = bezoeken;
        }
    }

    // Constructors
    public Telgebied() {

    }

    public Telgebied(String naam, String kaart) {
        this.naam = naam;
        this.kaart = kaart;
    }

    public Telgebied(int id, String naam, String kaart) {
        this.id = id;
        this.naam = naam;
        this.kaart = kaart;
    }

    // Methods
    public void addBezoek(Bezoek bezoek) {
        this.bezoeken.add(bezoek);
    }

    public void removeBezoek(Bezoek bezoek) {
        this.bezoeken.remove(bezoek);
    }

    private List<Bezoek> BezoekenInBroedPeriode(Vogel vogel) {
        List<Bezoek> bezoekenInPeriode = new ArrayList<>();

        for (Bezoek b : this.bezoeken) {
            if (b.getStartTijd().after(vogel.getStartBroedperiode()) && b.getEindTijd().before(vogel.getEindBroedPeriode())) {
                bezoekenInPeriode.add(b);
            }
        }

        return bezoekenInPeriode;
    }

    public int BerekenAantalBroedparen(Vogel vogel) {
        List<Bezoek> bezoekenInBroedPeriode = this.BezoekenInBroedPeriode(vogel);
        int totaalAantalPuntenWaarnemingen = 0;

        for (Bezoek b : bezoekenInBroedPeriode) {
            totaalAantalPuntenWaarnemingen = totaalAantalPuntenWaarnemingen + b.TotaalAantalPuntenWaarnemingen(vogel);
        }

        return totaalAantalPuntenWaarnemingen / vogel.getPuntenBroedpaar();
    }

    @Override
    public String toString() {
        return this.naam;
    }
}
