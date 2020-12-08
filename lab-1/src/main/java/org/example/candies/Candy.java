package org.example.candies;

import org.example.candies.exceptions.NegativeSugarAmountException;

import java.util.Objects;

public abstract class Candy {
    private Color color;
    private float sugarAmount;
    private String name;
    private double weight;

    public Candy(Color color, float sugarAmount, String name, double weight) {
        this.color = color;
        this.sugarAmount = sugarAmount;
        this.name = name;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public float getSugarAmount() {
        return sugarAmount;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSugarAmount(float sugarAmount) throws NegativeSugarAmountException {
        if(sugarAmount < 0)
            throw new NegativeSugarAmountException("You can't change sugar amount to negative number");
        this.sugarAmount = sugarAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return Float.compare(candy.sugarAmount, sugarAmount) == 0 &&
                color == candy.color &&
                name.equals(candy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, sugarAmount, name);
    }
}
