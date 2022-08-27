package ru.geekbrains.handler;

import ru.geekbrains.domain.request.HttpRequest;

public interface MethodHandler {

    void handle(HttpRequest httpRequest);

}
