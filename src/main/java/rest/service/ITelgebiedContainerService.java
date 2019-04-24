package rest.service;

import models.Telgebied;

import java.util.List;

public interface ITelgebiedContainerService {
    Telgebied getTelgebiedById(int id);
    List<Telgebied> getTelgebieden();
    void saveTelgebied(Telgebied telgebied);
    void deleteTelgebied(Telgebied telgebied);
}
