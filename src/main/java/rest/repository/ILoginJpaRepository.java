package rest.repository;

import models.Vogelteller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginJpaRepository extends JpaRepository<Vogelteller, Integer> {
    Vogelteller findVogeltellerByGebruikersnaamAndAndWachtwoord(String gebruikersnaam, String wachtwoord);
}
