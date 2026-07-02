package cristinauzunov.u5d4.entities;

import jakarta.persistence.Entity;

@Entity
public class Bevanda extends ProdottoMenu {

    private double prezzo;
    private int calorie;

    public Bevanda() {
    }

    public Bevanda(String nome, double prezzo, int calorie) {
        super(nome);
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getCalorie() {
        return calorie;
    }

    @Override
    public String toString() {
        return getNome() + " - " + prezzo + "€ (" + calorie + " kcal)";
    }
}