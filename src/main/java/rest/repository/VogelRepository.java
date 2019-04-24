package rest.repository;

import models.Vogel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VogelRepository implements IVogelRepo, IVogelContainerRepo{
    @Autowired
    private IVogelJpaRepository repo;

    @Override
    public List<Vogel> getAllVogels() {
        return repo.findAll();
    }

    @Override
    public Vogel getVogelById(int id) {
        return repo.getOne(id);
    }

    @Override
    public void createVogel(Vogel vogel) {
        repo.save(vogel);
    }

    @Override
    public void deleteVogel(Vogel vogel) {
        repo.delete(vogel);
    }

    @Override
    public void updateVogel(Vogel vogel) {
        repo.save(vogel);
    }
}
