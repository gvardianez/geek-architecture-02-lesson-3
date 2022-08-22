package ru.geekbrains.structure_patterns.composite;

public class Main {

    public static void main(String[] args) {
        Employees john = new Designer("John", 120.2f);
        Employees vasya = new Developer("Vasya", 253.5f);

        Organization organization = new Organization();
        organization.addEmployee(john);
        organization.addEmployee(vasya);

        System.out.println(organization.getNetSalaries());
    }



}
