package rest.repository;

import models.Vogelteller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginRepository implements ILoginContainerRepo{
    @Autowired
    private ILoginJpaRepository repo;

    @Override
    public void createVogelteller(Vogelteller vogelteller) {
        repo.save(vogelteller);
    }

    @Override
    public Vogelteller authenticate(Vogelteller vogelteller) {
        return repo.findVogeltellerByGebruikersnaamAndAndWachtwoord(vogelteller.getGebruikersnaam(), vogelteller.getWachtwoord());
    }
}
