package ru.geekbrains.behavioral_patterns.template_method;

public class Main {

    public static void main(String[] args) {

        Builder android = new AndroidBuilder();
        Builder ios = new IosBuilder();
        android.build();
        ios.build();

    }

}
