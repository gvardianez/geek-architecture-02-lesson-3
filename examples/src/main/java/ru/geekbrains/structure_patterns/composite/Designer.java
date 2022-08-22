package ru.geekbrains.structure_patterns.composite;

public class Designer implements Employees {

    private final String name;
    private float salary;

    public Designer(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getSalary() {
        return salary;
    }

    @Override
    public void setSalary(float salary) {
        this.salary = salary;
    }

}
