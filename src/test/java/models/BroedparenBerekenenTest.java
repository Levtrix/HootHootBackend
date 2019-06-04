package models;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class BroedparenBerekenenTest {
    private Telgebied telgebied;
    private Vogelteller vogelteller;
    private Vogel vogel1;
    private Vogel vogel2;

    @Before
    public void TestInitialize() {
        telgebied = new Telgebied(1, "De Paarse Heide", "Groningen", 34, 35, 50, 60);
        vogelteller = new Vogelteller(1, "John Doe", "jdoe", "1wachtwoord!");

        Date startBroedperiodeVogel1 = new GregorianCalendar(2019, Calendar.MARCH, 15).getTime();
        Date eindeBroedperiodeVogel1 = new GregorianCalendar(2019, Calendar.JUNE, 20).getTime();
        List<Waarneming> vogel1Waarnemingen = new ArrayList<>();
        vogel1 = new Vogel(1, "Applevink", "AV", startBroedperiodeVogel1, eindeBroedperiodeVogel1, 3, vogel1Waarnemingen);

        Date statBroedperiodeVogel2 = new GregorianCalendar(2019, Calendar.APRIL, 15).getTime();
        Date eindeBroedperiodeVogel2 = new GregorianCalendar(2019, Calendar.MAY, 10).getTime();
        List<Waarneming> vogel2Waarnemingen = new ArrayList<>();
        vogel2 = new Vogel(2, "Blauwe Reiger", "BLR", statBroedperiodeVogel2, eindeBroedperiodeVogel2, 5, vogel2Waarnemingen);
    }

    @Test
    public void TestBerekenAantalBroedparen() {
        Date datumWaarneming1 = new GregorianCalendar(2019, Calendar.APRIL, 23).getTime();
        List<Waarneming> waarnemingen = new ArrayList<>();
        waarnemingen.add(new Waarneming(1, datumWaarneming1, vogel1, SoortWaarneming.NestIndicerend, 50));
        waarnemingen.add(new Waarneming(2, datumWaarneming1, vogel1, SoortWaarneming.TerritoriumIndicerend, 50));
        waarnemingen.add(new Waarneming(3, datumWaarneming1, vogel2, SoortWaarneming.VogelAanwezig, 50));
        waarnemingen.add(new Waarneming(4, datumWaarneming1, vogel1, SoortWaarneming.VogelAanwezig, 50));
        waarnemingen.add(new Waarneming(5, datumWaarneming1, vogel2, SoortWaarneming.VogelAanwezig,50));
        telgebied.addBezoek(new Bezoek(1, datumWaarneming1, datumWaarneming1, telgebied, vogelteller, waarnemingen));

        assertEquals(2, telgebied.BerekenAantalBroedparen(vogel1));
    }

    @Test
    public void TestAfrondingBerekenAantalBroedparen() {
        Date datumWaarneming = new GregorianCalendar(2019, Calendar.APRIL, 23).getTime();
        List<Waarneming> waarnemingen = new ArrayList<>();
        waarnemingen.add(new Waarneming(1, datumWaarneming, vogel2, SoortWaarneming.NestIndicerend, 50));
        waarnemingen.add(new Waarneming(2, datumWaarneming, vogel1, SoortWaarneming.TerritoriumIndicerend, 50));
        waarnemingen.add(new Waarneming(3, datumWaarneming, vogel2, SoortWaarneming.VogelAanwezig, 50));
        waarnemingen.add(new Waarneming(4, datumWaarneming, vogel2, SoortWaarneming.VogelAanwezig, 50));
        waarnemingen.add(new Waarneming(5, datumWaarneming, vogel2, SoortWaarneming.VogelAanwezig, 50));
        telgebied.addBezoek(new Bezoek(1, datumWaarneming, datumWaarneming, telgebied, vogelteller, waarnemingen));

        assertEquals(1, telgebied.BerekenAantalBroedparen(vogel2));
    }

    @Test
    public void TestBerekenAantalBroedparenBuitenBroedperiode() {
        Date datumWaarneming = new GregorianCalendar(2019, Calendar.JANUARY, 22).getTime();
        List<Waarneming> waarnemingen = new ArrayList<>();
        waarnemingen.add(new Waarneming(1, datumWaarneming, vogel2, SoortWaarneming.NestIndicerend, 50));
        waarnemingen.add(new Waarneming(2, datumWaarneming, vogel1, SoortWaarneming.TerritoriumIndicerend, 50));
        waarnemingen.add(new Waarneming(3, datumWaarneming, vogel2, SoortWaarneming.VogelAanwezig, 50));
        waarnemingen.add(new Waarneming(4, datumWaarneming, vogel1, SoortWaarneming.VogelAanwezig, 50));
        waarnemingen.add(new Waarneming(5, datumWaarneming, vogel2, SoortWaarneming.VogelAanwezig, 50));
        telgebied.addBezoek(new Bezoek(1, datumWaarneming, datumWaarneming, telgebied, vogelteller, waarnemingen));

        assertEquals(0, telgebied.BerekenAantalBroedparen(vogel1));
    }

    @Test
    public void TestBerekenAantalBroedparenMetGeenWaarnemingen() {
        Date datumWaarneming = new GregorianCalendar(2019, Calendar.APRIL, 23).getTime();
        List<Waarneming> waarnemingen = new ArrayList<>();
        waarnemingen.add(new Waarneming(1, datumWaarneming, vogel1, SoortWaarneming.NestIndicerend, 50));
        waarnemingen.add(new Waarneming(2, datumWaarneming, vogel1, SoortWaarneming.TerritoriumIndicerend, 50));
        waarnemingen.add(new Waarneming(3, datumWaarneming, vogel1, SoortWaarneming.VogelAanwezig, 50));
        waarnemingen.add(new Waarneming(4, datumWaarneming, vogel1, SoortWaarneming.VogelAanwezig, 50));
        waarnemingen.add(new Waarneming(5, datumWaarneming, vogel1, SoortWaarneming.VogelAanwezig, 50));
        telgebied.addBezoek(new Bezoek(1, datumWaarneming, datumWaarneming, telgebied, vogelteller, waarnemingen));

        assertEquals(0, telgebied.BerekenAantalBroedparen(vogel2));
    }
}