package ru.geekbrains.structure_patterns.bridge;

public class Main {

    public static void main(String[] args) {
        Theme theme = new DarkTheme();
        WebPage webPage = new About(theme);
        WebPage careerPage = new Careers(theme);
        webPage.getContent();
        careerPage.getContent();
    }

}
