package ru.geekbrains.structure_patterns.proxy;

public class Main {

    public static void main(String[] args) {
        SecuredDoor door = new SecuredDoor(new LabDoor());

        door.open("asd");

        door.open("sfgikefjhio");

        door.close();
    }

}
