package cristinauzunov.u5d4.config;

import java.util.List;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cristinauzunov.u5d4.entities.Bevanda;
import cristinauzunov.u5d4.entities.Pizza;
import cristinauzunov.u5d4.entities.Topping;
import cristinauzunov.u5d4.repositories.BevandaRepository;
import cristinauzunov.u5d4.repositories.PizzaRepository;
import cristinauzunov.u5d4.repositories.ToppingRepository;

@Component
public class MenuRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MenuRunner.class);

    // i Bean del menù, letti dal context
    private Topping prosciutto;
    private Topping ananas;
    private Pizza margherita;
    private Pizza hawaiian;
    private Bevanda cocaCola;
    private Bevanda acqua;

    // i repository per salvare sul DB
    private ToppingRepository toppingRepository;
    private PizzaRepository pizzaRepository;
    private BevandaRepository bevandaRepository;

    public MenuRunner(Topping prosciutto, Topping ananas,
                      Pizza margherita, Pizza hawaiian,
                      Bevanda cocaCola, Bevanda acqua,
                      ToppingRepository toppingRepository,
                      PizzaRepository pizzaRepository,
                      BevandaRepository bevandaRepository) {
        this.prosciutto = prosciutto;
        this.ananas = ananas;
        this.margherita = margherita;
        this.hawaiian = hawaiian;
        this.cocaCola = cocaCola;
        this.acqua = acqua;
        this.toppingRepository = toppingRepository;
        this.pizzaRepository = pizzaRepository;
        this.bevandaRepository = bevandaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // 1. salvo prima i toppings (le pizze dipendono da loro)
        toppingRepository.save(prosciutto);
        toppingRepository.save(ananas);

        // 2. salvo le pizze
        pizzaRepository.save(margherita);
        pizzaRepository.save(hawaiian);

        // 3. salvo le bevande
        bevandaRepository.save(cocaCola);
        bevandaRepository.save(acqua);

        logger.info("Menu salvato sul database!");

        // 4. provo le due query dell'esercizio 2
        List<Topping> toppingEconomici = toppingRepository.findByPrezzoLessThan(1.5);
        logger.info("Toppings con prezzo minore di 1.5:");
        for (Topping t : toppingEconomici) {
            logger.info(" - " + t.getNome() + " (" + t.getPrezzo() + "€)");
        }

        List<Bevanda> bevandeLeggere = bevandaRepository.trovaBevandeLeggere(100);
        logger.info("Bevande con meno di 100 calorie:");
        for (Bevanda b : bevandeLeggere) {
            logger.info(" - " + b.getNome() + " (" + b.getCalorie() + " kcal)");
        }
    }
}