package rest.repository;

import models.Vogelteller;

public interface ILoginContainerRepo {
    void createVogelteller(Vogelteller vogelteller);
    Vogelteller authenticate(Vogelteller vogelteller);
}
