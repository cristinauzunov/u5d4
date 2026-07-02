package cristinauzunov.u5d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cristinauzunov.u5d4.entities.Bevanda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BevandaRepository extends JpaRepository<Bevanda, Long> {

    // trova le bevande con calorie minori del valore passato
    @Query("SELECT b FROM Bevanda b WHERE b.calorie < :maxCalorie")
    List<Bevanda> trovaBevandeLeggere(@Param("maxCalorie") int maxCalorie);
}