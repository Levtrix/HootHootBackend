package rest.service;

import models.Vogelteller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IVogeltellerContainerRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class VogeltellerContainerServiceImp implements IVogeltellerContainerService{
    @Autowired
    private IVogeltellerContainerRepo repo;

    @Override
    public Vogelteller getVogeltellerById(int id) {
        Vogelteller tmpVogelteller = repo.getVogeltellerById(id);
        Vogelteller jsonObject = new Vogelteller(tmpVogelteller.getId(), tmpVogelteller.getNaam(), tmpVogelteller.getGebruikersnaam());
        return jsonObject;
    }

    @Override
    public List<Vogelteller> getVogeltellers() {
        List<Vogelteller> tmpVogeltellers = repo.getAllVogeltellers();
        List<Vogelteller> jsonObjects = new ArrayList<>();

        for (Vogelteller v : tmpVogeltellers) {
            jsonObjects.add(new Vogelteller(v.getId(), v.getNaam(), v.getGebruikersnaam()));
        }
        return jsonObjects;
    }

    @Override
    public void deleteVogelteller(Vogelteller vogelteller) {
        repo.deleteVogelteller(vogelteller);
    }
}
