package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

public interface IResponseSerializer {

    String serialize(HttpResponse response);

}
