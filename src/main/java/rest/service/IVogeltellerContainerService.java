package rest.service;

import models.Vogelteller;

import java.util.List;

public interface IVogeltellerContainerService {
    Vogelteller getVogeltellerById(int id);
    List<Vogelteller> getVogeltellers();
    void deleteVogelteller(Vogelteller vogelteller);
}
