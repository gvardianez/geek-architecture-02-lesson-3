package ru.geekbrains.structure_patterns.decorator;

public class MilkCoffee implements Coffee {

    private final Coffee coffee;

    private final float costMilk;

    public MilkCoffee(Coffee coffee, float costMilk) {
        this.coffee = coffee;
        this.costMilk = costMilk;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " " + "with milk";
    }

    @Override
    public float getCost() {
        return coffee.getCost() + this.costMilk;
    }
}
