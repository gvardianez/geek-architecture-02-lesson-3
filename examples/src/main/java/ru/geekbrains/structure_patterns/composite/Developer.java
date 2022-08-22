package ru.geekbrains.structure_patterns.composite;

public class Developer implements Employees {

    private final String name;
    private float salary;

    public Developer(String name, float salary) {
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
