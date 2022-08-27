package ru.geekbrains;

import ru.geekbrains.domain.response.HttpResponse;

public interface IResponseSerializer {

    String serialize(HttpResponse response);

}
