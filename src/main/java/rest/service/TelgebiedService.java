package rest.service;

import models.Telgebied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.ITelgebiedRepo;

@Component
public class TelgebiedService implements ITelgebiedService{
    @Autowired
    private ITelgebiedRepo repo;

    @Override
    public void update(Telgebied telgebied) {
        repo.updateTelgebied(telgebied);
    }
}
