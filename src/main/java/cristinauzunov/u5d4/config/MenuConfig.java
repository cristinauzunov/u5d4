package cristinauzunov.u5d4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cristinauzunov.u5d4.entities.Bevanda;
import cristinauzunov.u5d4.entities.Pizza;
import cristinauzunov.u5d4.entities.Topping;

@Configuration
public class MenuConfig {

    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 1.5, 80);
    }

    @Bean
    public Topping ananas() {
        return new Topping("Ananas", 1.0, 50);
    }

    @Bean
    public Pizza margherita() {
        return new Pizza("Margherita", 5.0, 600);
    }

    @Bean
    public Pizza hawaiian(Topping prosciutto, Topping ananas) {
        Pizza p = new Pizza("Hawaiian", 5.0, 600);
        p.aggiungiTopping(prosciutto);
        p.aggiungiTopping(ananas);
        return p;
    }

    @Bean
    public Bevanda cocaCola() {
        return new Bevanda("Coca Cola", 2.5, 140);
    }

    @Bean
    public Bevanda acqua() {
        return new Bevanda("Acqua", 1.0, 0);
    }
}