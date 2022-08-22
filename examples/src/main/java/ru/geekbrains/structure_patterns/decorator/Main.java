package ru.geekbrains.structure_patterns.decorator;

public class Main {

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee(10.5f);
        System.out.println(coffee.getDescription()+ " "+coffee.getCost());
        coffee = new MilkCoffee(coffee,3.2f);
        System.out.println(coffee.getDescription() + " " + coffee.getCost());
        coffee = new VanillaCoffee(coffee,4.2f);
        System.out.println(coffee.getDescription() + " " + coffee.getCost());

    }




}
