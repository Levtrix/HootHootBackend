package rest.repository;

import models.Telgebied;

import java.util.List;

public interface ITelgebiedContainerRepo {
    List<Telgebied> getAllTelgebieden();
    Telgebied getTelgebiedById(int id);
    void createTelgebied(Telgebied telgebied);
    void deleteTelgebied(Telgebied telgebied);
}
