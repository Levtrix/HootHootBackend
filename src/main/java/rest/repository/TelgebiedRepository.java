package rest.repository;

import models.Telgebied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelgebiedRepository implements ITelgebiedRepo, ITelgebiedContainerRepo{
    @Autowired
    private ITelgebiedJpaRepository repo;


    @Override
    public List<Telgebied> getAllTelgebieden() {
        return repo.findAll();
    }

    @Override
    public Telgebied getTelgebiedById(int id) {
        return repo.getOne(id);
    }

    @Override
    public void createTelgebied(Telgebied telgebied) {
        repo.save(telgebied);
    }

    @Override
    public void deleteTelgebied(Telgebied telgebied) {
        repo.delete(telgebied);
    }

    @Override
    public void updateTelgebied(Telgebied telgebied) {
        repo.save(telgebied);
    }
}
