package rest.service;

import models.Vogelteller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IVogeltellerRepo;

@Component
public class VogeltellerService implements IVogeltellerService{
    @Autowired
    private IVogeltellerRepo repo;

    @Override
    public void updateVogelteller(Vogelteller vogelteller) {
        repo.updateVogelteller(vogelteller);
    }
}
