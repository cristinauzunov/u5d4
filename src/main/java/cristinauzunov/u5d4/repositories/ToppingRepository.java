package cristinauzunov.u5d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cristinauzunov.u5d4.entities.Topping;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Long> {

    // trova tutti i toppings con prezzo minore di quello passato
    List<Topping> findByPrezzoLessThan(double prezzo);
}