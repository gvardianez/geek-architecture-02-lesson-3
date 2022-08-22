package ru.geekbrains.domain.request;

import java.util.Map;

public class GetHttpRequest implements Request{

    private final Request request;

    public GetHttpRequest(Request request) {
        this.request = request;
    }

    @Override
    public String getMethod() {
        return Method.GET.toString();
    }

    @Override
    public String getUrl() {
        return request.getUrl();
    }

    @Override
    public Map<String, String> getHeaders() {
        return request.getHeaders();
    }

    @Override
    public String getBody() {
        return request.getBody();
    }
}
