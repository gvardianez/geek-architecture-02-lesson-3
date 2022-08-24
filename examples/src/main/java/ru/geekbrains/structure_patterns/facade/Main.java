package ru.geekbrains.structure_patterns.facade;

public class Main {

    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade(new Computer());
        computerFacade.turnOn();
        computerFacade.turnOff();
    }
}
