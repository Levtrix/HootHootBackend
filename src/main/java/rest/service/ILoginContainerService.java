package rest.service;

import models.Vogelteller;

public interface ILoginContainerService {
    void saveVogelteller(Vogelteller vogelteller);
    Vogelteller authenticate(Vogelteller vogelteller);
    boolean logout(Vogelteller vogelteller);
}
