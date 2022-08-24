package ru.geekbrains.structure_patterns.bridge;

public class LightTheme implements Theme {

    @Override
    public String getColor() {
        return "Light color";
    }
}
