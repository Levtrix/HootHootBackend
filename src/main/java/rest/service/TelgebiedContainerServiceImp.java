package rest.service;

import models.Telgebied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.ITelgebiedContainerRepo;

import java.util.List;

@Component
public class TelgebiedContainerServiceImp implements ITelgebiedContainerService{
    @Autowired
    private ITelgebiedContainerRepo repo;

    @Override
    public Telgebied getTelgebiedById(int id) {
        return  repo.getTelgebiedById(id);
    }

    @Override
    public List<Telgebied> getTelgebieden() {
        return repo.getAllTelgebieden();
    }

    @Override
    public void saveTelgebied(Telgebied telgebied) {
        repo.createTelgebied(telgebied);
    }

    @Override
    public void deleteTelgebied(Telgebied telgebied) {
        repo.deleteTelgebied(telgebied);
    }
}
