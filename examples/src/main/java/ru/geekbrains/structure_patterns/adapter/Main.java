package ru.geekbrains.structure_patterns.adapter;

public class Main {

    public static void main(String[] args) {
        Lion lion = new AfricanLion();
        WildDog wildDog = new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(wildDog);
        Hunter hunter = new Hunter();
        hunter.hunt(lion);
        hunter.hunt(wildDogAdapter);
    }

}
