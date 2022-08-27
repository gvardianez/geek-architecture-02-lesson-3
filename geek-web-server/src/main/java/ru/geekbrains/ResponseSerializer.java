package ru.geekbrains;

import ru.geekbrains.domain.response.HttpResponse;

public class ResponseSerializer implements IResponseSerializer {

    public static ResponseSerializer getInstance() {
        return new ResponseSerializer();
    }

    private ResponseSerializer() {
    }

    @Override
    public String serialize(HttpResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 ").append(response.getStatusCode()).append(" ").append(response.getStatusCodeName()).append("\n");
        response.getHeaders().forEach((header, value) -> sb.append(header).append(": ").append(value).append("\n"));
        sb.append('\n');
        sb.append(response.getBody());
        System.out.println(sb);
        return sb.toString();
    }
}
