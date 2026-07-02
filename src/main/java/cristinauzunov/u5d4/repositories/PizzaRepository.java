package cristinauzunov.u5d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cristinauzunov.u5d4.entities.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}