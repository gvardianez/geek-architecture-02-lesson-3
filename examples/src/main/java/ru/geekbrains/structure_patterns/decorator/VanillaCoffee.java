package ru.geekbrains.structure_patterns.decorator;

public class VanillaCoffee implements Coffee{

    private final Coffee coffee;

    private final float costVanilla;

    public VanillaCoffee(Coffee coffee, float costVanilla) {
        this.coffee = coffee;
        this.costVanilla = costVanilla;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " " + "with vanilla";
    }

    @Override
    public float getCost() {
        return coffee.getCost() + this.costVanilla;
    }


}
