package rest.repository;

import models.Vogelteller;

import java.util.List;

public interface IVogeltellerContainerRepo {
    List<Vogelteller> getAllVogeltellers();
    Vogelteller getVogeltellerById(int id);
    void createVogelteller(Vogelteller vogelteller);
    void deleteVogelteller(Vogelteller vogelteller);
}
