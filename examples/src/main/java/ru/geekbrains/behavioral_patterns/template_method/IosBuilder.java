package ru.geekbrains.behavioral_patterns.template_method;

public class IosBuilder extends Builder{

    @Override
    public void test() {
        System.out.println("Ios test");
    }

    @Override
    public void lint() {
        System.out.println("Ios lint");
    }

    @Override
    public void assemble() {
        System.out.println("Ios assemble");
    }

    @Override
    public void deploy() {
        System.out.println("Ios deploy");
    }
}
