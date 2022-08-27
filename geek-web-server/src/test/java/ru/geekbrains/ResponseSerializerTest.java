package ru.geekbrains;

import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.domain.response.HttpResponse;

import java.util.HashMap;

public class ResponseSerializerTest {

    private static final HttpResponse httpResponse = HttpResponse.createHttpResponse()
            .addStatus(200)
            .addStatusCodeName("OK")
            .addHeaders(new HashMap<>() {{
                put("Content-Type", "text/html; charset=utf-8");
            }})
            .addBody("<h1>Hello!!!</h1>")
            .build();

    private static final IResponseSerializer responseSerializer = ResponseSerializer.getInstance();

    private final static String NEW_LINE = "\n";

    @Test
    public void testSerialize() {
        String response = responseSerializer.serialize(httpResponse);
        System.out.println(response);
        Assert.assertEquals("HTTP/1.1 200 OK", response.split(NEW_LINE)[0]);
        Assert.assertEquals("HTTP/1.1 200 OK\n" +
                                    "Content-Type: text/html; charset=utf-8\n" +
                                    "\n" +
                                    "<h1>Hello!!!</h1>", response);
    }

}
