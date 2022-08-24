package ru.geekbrains.structure_patterns.proxy;

public class SecuredDoor{

    private final Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }

    public void open(String password) {

        if (authenticate(password)) {
            door.open();
        } else {
            System.out.println("Big no! It ain't possible.");
        }
    }

    public void close() {
        door.close();
    }

    public boolean authenticate(String password) {
        return password.equals("sfgikefjhio");
    }


}
