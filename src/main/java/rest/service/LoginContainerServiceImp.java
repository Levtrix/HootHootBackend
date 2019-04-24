package rest.service;

import models.Vogelteller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.ILoginContainerRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginContainerServiceImp implements ILoginContainerService {
    private List<Vogelteller> loggedInUsers = new ArrayList<>();

    @Autowired
    private ILoginContainerRepo repo;

    @Override
    public void saveVogelteller(Vogelteller vogelteller) {
        repo.createVogelteller(vogelteller);
    }

    @Override
    public Vogelteller authenticate(Vogelteller vogelteller) {
        Vogelteller tmpVogelteller = repo.authenticate(vogelteller);
        Vogelteller jsonObject = new Vogelteller(vogelteller.getId(), vogelteller.getNaam(), vogelteller.getGebruikersnaam());
        return jsonObject;
    }

    @Override
    public boolean logout(Vogelteller vogelteller) {
        // TODO: Will be implemented with JWT
        return false;
    }
}
