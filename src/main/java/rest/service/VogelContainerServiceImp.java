package rest.service;

import models.Vogel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IVogelContainerRepo;

import java.util.List;

@Component
public class VogelContainerServiceImp implements IVogelContainerService{
    @Autowired
    private IVogelContainerRepo repo;

    @Override
    public Vogel getVogelById(int id) {
        return repo.getVogelById(id);
    }

    @Override
    public List<Vogel> getVogels() {
        return repo.getAllVogels();
    }

    @Override
    public void saveVogel(Vogel vogel) {
        repo.createVogel(vogel);
    }

    @Override
    public void deleteVogel(Vogel vogel) {
        repo.deleteVogel(vogel);
    }
}
