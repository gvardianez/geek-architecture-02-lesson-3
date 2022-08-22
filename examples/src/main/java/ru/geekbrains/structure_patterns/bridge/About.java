package ru.geekbrains.structure_patterns.bridge;

public class About implements WebPage {

    protected final Theme theme;

    public About(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void getContent() {
        System.out.println("About page " + theme.getColor());
    }
}
