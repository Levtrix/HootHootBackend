package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "vogelteller")
public class Vogelteller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "naam", nullable = false)
    private String naam;

    @Column(name = "gebruikersnaam", nullable = false)
    private String gebruikersnaam;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "wachtwoord", nullable = false)
    private String wachtwoord;

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

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    // Constructors
    public Vogelteller() {

    }

    public Vogelteller(String naam) {
        this.naam = naam;
    }

    public Vogelteller(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Vogelteller(String naam, String gebruikersnaam, String wachtwoord) {
        this.naam = naam;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Vogelteller(int id, String naam, String gebruikersnaam) {
        this.id = id;
        this.naam = naam;
        this.gebruikersnaam = gebruikersnaam;
    }

    public Vogelteller(int id, String naam, String gebruikersnaam, String wachtwoord) {
        this.id = id;
        this.naam = naam;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    // Methods

    @Override
    public String toString() {
        return this.naam;
    }
}
