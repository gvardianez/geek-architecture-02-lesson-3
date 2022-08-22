package ru.geekbrains.structure_patterns.decorator;

public class SimpleCoffee implements Coffee {

    private float cost;

    public SimpleCoffee(float cost) {
        this.cost = cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public float getCost() {
        return cost;
    }
}
