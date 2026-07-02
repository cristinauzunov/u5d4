package cristinauzunov.u5d4.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Pizza extends ProdottoMenu {

    private double prezzoBase;
    private int calorieBase;

    @ManyToMany
    private List<Topping> toppings;

    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    public Pizza(String nome, double prezzoBase, int calorieBase) {
        super(nome);
        this.prezzoBase = prezzoBase;
        this.calorieBase = calorieBase;
        this.toppings = new ArrayList<>();
    }

    public void aggiungiTopping(Topping t) {
        toppings.add(t);
    }

    public double getPrezzo() {
        double totale = prezzoBase;
        for (Topping t : toppings) {
            totale = totale + t.getPrezzo();
        }
        return totale;
    }

    public int getCalorie() {
        int totale = calorieBase;
        for (Topping t : toppings) {
            totale = totale + t.getCalorie();
        }
        return totale;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        String descrizione = getNome() + " - " + getPrezzo() + "€ (" + getCalorie() + " kcal)";
        if (!toppings.isEmpty()) {
            descrizione = descrizione + "\n   Toppings: ";
            for (Topping t : toppings) {
                descrizione = descrizione + t.getNome() + " ";
            }
        }
        return descrizione;
    }
}