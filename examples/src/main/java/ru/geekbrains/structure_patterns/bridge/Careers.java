package ru.geekbrains.structure_patterns.bridge;

public class Careers implements WebPage {

    protected final Theme theme;

    public Careers(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void getContent() {
        System.out.println("Careers with + " + theme.getColor());
    }
}
