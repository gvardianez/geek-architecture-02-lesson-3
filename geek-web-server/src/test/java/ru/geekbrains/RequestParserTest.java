package ru.geekbrains;

import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.domain.request.decorator.Request;

import java.util.Deque;
import java.util.LinkedList;

public class RequestParserTest {

    private static final String rawTestRequest =
        "GET /index.html HTTP/1.1\n" +
        "Host: localhost:8088\n" +
        "Connection: keep-alive\n" +
        "\n";

    private final IRequestParser requestParser = RequestParser.getInstance();

    @Test
    public void testParsing() {
        Deque<String> raw = new LinkedList<>();
        rawTestRequest.lines().forEach(raw::add);
       Request req = requestParser.parse(raw);

        Assert.assertEquals("GET", req.getMethod());
    }
}
