package rest.repository;

import models.Vogelteller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VogeltellerRepository implements IVogeltellerRepo, IVogeltellerContainerRepo{
    @Autowired
    private IVogeltellerJpaRepository repo;

    @Override
    public List<Vogelteller> getAllVogeltellers() {
        return repo.findAll();
    }

    @Override
    public Vogelteller getVogeltellerById(int id) {
        return repo.getOne(id);
    }

    @Override
    public void createVogelteller(Vogelteller vogelteller) {
        repo.save(vogelteller);
    }

    @Override
    public void deleteVogelteller(Vogelteller vogelteller) {
        repo.delete(vogelteller);
    }

    @Override
    public void updateVogelteller(Vogelteller vogelteller) {
        repo.save(vogelteller);
    }
}
