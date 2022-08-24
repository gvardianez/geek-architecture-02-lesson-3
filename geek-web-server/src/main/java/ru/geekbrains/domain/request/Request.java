package ru.geekbrains.domain.request;

import java.util.Map;

public interface Request {

    String getMethod();

    String getUrl();

    Map<String, String> getHeaders();

    String getBody();


}
