package ru.geekbrains.behavioral_patterns.template_method;

public class AndroidBuilder extends Builder{

    @Override
    public void test() {
        System.out.println("Android test");
    }

    @Override
    public void lint() {
        System.out.println("Android lint");
    }

    @Override
    public void assemble() {
        System.out.println("Android assemble");
    }

    @Override
    public void deploy() {
        System.out.println("Android deploy");
    }
}
