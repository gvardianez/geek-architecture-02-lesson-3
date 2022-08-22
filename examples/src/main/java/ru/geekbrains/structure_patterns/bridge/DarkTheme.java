package ru.geekbrains.structure_patterns.bridge;

public class DarkTheme implements Theme{

    @Override
    public String getColor() {
        return "Dark color";
    }
}
