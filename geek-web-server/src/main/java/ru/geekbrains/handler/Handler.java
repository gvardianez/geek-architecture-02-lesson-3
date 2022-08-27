package ru.geekbrains.handler;

import ru.geekbrains.domain.request.decorator.Method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Handler {

    int order();

    Method method();
}
