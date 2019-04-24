package rest.repository;

import models.Vogel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVogelJpaRepository extends JpaRepository<Vogel, Integer> {
}
