package ru.geekbrains.structure_patterns.decorator;

public class WhipCoffee implements Coffee{

    private final Coffee coffee;

    private final float costWhip;

    public WhipCoffee(Coffee coffee, float costWhip) {
        this.coffee = coffee;
        this.costWhip = costWhip;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " " + "with whip";
    }

    @Override
    public float getCost() {
        return coffee.getCost() + this.costWhip;
    }
}
