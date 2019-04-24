package models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bezoek")
public class Bezoek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "starttijd", nullable = false)
    private Date startTijd;

    @Column(name = "eindtijd")
    private Date eindTijd;

    @ManyToOne(optional = false)
    @JoinColumn(name = "telgebiedid", insertable = false, updatable = false)
    private Telgebied telgebied;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vogeltellerid", insertable = false, updatable = false)
    private Vogelteller vogelteller;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "waarnemingid")
    @Fetch(FetchMode.SELECT)
    private List<Waarneming> waarnemingen = new ArrayList<>();

    // Getters and setters
    public int getId() {
        return id;
    }

    public Date getStartTijd() {
        return startTijd;
    }

    public void setStartTijd(Date startTijd) {
        this.startTijd = startTijd;
    }

    public Date getEindTijd() {
        return eindTijd;
    }

    public void setEindTijd(Date eindTijd) {
        this.eindTijd = eindTijd;
    }

    public Telgebied getTelgebied() {
        return telgebied;
    }

    public void setTelgebied(Telgebied telgebied) {
        this.telgebied = telgebied;
    }

    public Vogelteller getVogelteller() {
        return vogelteller;
    }

    public void setVogelteller(Vogelteller vogelteller) {
        this.vogelteller = vogelteller;
    }

    public List<Waarneming> getWaarnemingen() {
        return Collections.unmodifiableList(waarnemingen);
    }

    public void setWaarnemingen(List<Waarneming> waarnemingen) {
        if (waarnemingen.size() != 0) {
            this.waarnemingen.clear();
            this.waarnemingen = waarnemingen;
        }
    }

    // Constructors
    public Bezoek() {

    }

    public Bezoek(Date startTijd, Telgebied telgebied, Vogelteller vogelteller) {
        this.startTijd = startTijd;
        this.telgebied = telgebied;
        this.vogelteller = vogelteller;
    }

    public Bezoek(Date startTijd, Date eindTijd, Telgebied telgebied, Vogelteller vogelteller) {
        this.startTijd = startTijd;
        this.eindTijd = eindTijd;
        this.telgebied = telgebied;
        this.vogelteller = vogelteller;
    }

    public Bezoek(int id, Date startTijd, Date eindTijd, Telgebied telgebied, Vogelteller vogelteller, List<Waarneming> waarnemingen) {
        this.id = id;
        this.startTijd = startTijd;
        this.eindTijd = eindTijd;
        this.telgebied = telgebied;
        this.vogelteller = vogelteller;
        this.waarnemingen = waarnemingen;
    }

    // Methods
    public void addWaarneming(Waarneming waarneming) {
        this.waarnemingen.add(waarneming);
    }

    public void deleteWaarneming(Waarneming waarneming) {
        this.waarnemingen.remove(waarneming);
    }

    public int TotaalAantalPuntenWaarnemingen(Vogel vogel) {
        int totaalAantalPunten = 0;

        for (Waarneming w : this.waarnemingen) {
            if (vogel.getId() == w.getVogel().getId()) {
                totaalAantalPunten = totaalAantalPunten + w.PuntenWaarneming();
            }
        }

        return totaalAantalPunten;
    }
}
