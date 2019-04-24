package rest.service;

import models.Vogel;

import java.util.List;

public interface IVogelContainerService {
    Vogel getVogelById(int id);
    List<Vogel> getVogels();
    void saveVogel(Vogel vogel);
    void deleteVogel(Vogel vogel);
}
