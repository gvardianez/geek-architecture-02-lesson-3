package ru.geekbrains;

import ru.geekbrains.domain.request.HttpRequest;
import ru.geekbrains.domain.request.Request;
import ru.geekbrains.domain.request.RequestFactory;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser implements IRequestParser {

    public static RequestParser getInstance() {
        return new RequestParser();
    }

    private RequestParser() {
    }

    @Override
    public Request parse(Deque<String> rawRequest) {
        String[] firstLine = rawRequest.pollFirst().split(" ");
        Map<String, String> headers = new HashMap<>();
        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank()) {
                break;
            }
            String[] header = line.split(": ");
            headers.put(header[0], header[1]);
        }
        StringBuilder sb = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            sb.append(rawRequest.pollFirst());
        }

        HttpRequest httpRequest = HttpRequest.createHttpRequest()
                                             .addUrl(firstLine[1])
                                             .addHeaders(headers)
                                             .addBody(sb.toString())
                                             .build();

        return RequestFactory.createHttpRequestWithMethod(httpRequest, firstLine[0]);
    }

}
