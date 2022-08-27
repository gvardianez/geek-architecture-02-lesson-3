package ru.geekbrains.domain.request.decorator;

import java.util.Map;

public interface Request {

    String getMethod();

    String getUrl();

    Map<String, String> getHeaders();

    String getBody();


}
