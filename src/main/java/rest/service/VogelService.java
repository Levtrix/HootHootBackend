package rest.service;

import models.Vogel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IVogelRepo;

@Component
public class VogelService implements IVogelService{
    @Autowired
    private IVogelRepo repo;

    @Override
    public void update(Vogel vogel) {
        repo.updateVogel(vogel);
    }
}
