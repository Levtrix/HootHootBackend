package rest.repository;

import models.Vogel;

import java.util.List;

public interface IVogelContainerRepo {
    List<Vogel> getAllVogels();
    Vogel getVogelById(int id);
    void createVogel(Vogel vogel);
    void deleteVogel(Vogel vogel);
}
