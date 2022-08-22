package ru.geekbrains.structure_patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    private final List<Employees> employees;

    public Organization() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employees employee) {
        this.employees.add(employee);
    }

    public float getNetSalaries() {
        return employees.stream().map(Employees::getSalary).reduce(0.f, Float::sum);
    }

}
