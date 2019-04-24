package rest.repository;

import models.Vogelteller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVogeltellerJpaRepository extends JpaRepository<Vogelteller, Integer> {
}
