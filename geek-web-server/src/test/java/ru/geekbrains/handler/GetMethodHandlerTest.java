package ru.geekbrains.handler;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.domain.request.HttpRequest;
import ru.geekbrains.domain.response.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.IFileService;
import ru.geekbrains.service.SocketService;

import static org.mockito.Mockito.mock;

public class GetMethodHandlerTest {

    private final static HttpRequest httpRequest =
            HttpRequest.createHttpRequest()
                       .build();

    @Test
    public void testHandleInternal() {
        IFileService fileService = mock(FileService.class);
        GetMethodHandler getMethodHandler = new GetMethodHandler(null, mock(SocketService.class), mock(ResponseSerializer.class), fileService);
        Mockito.doReturn(false)
               .when(fileService)
               .exists(httpRequest.getUrl());
        HttpResponse httpResponse = getMethodHandler.handleInternal(httpRequest);
        Assert.assertEquals(httpResponse.getStatusCode(),404);
        Assert.assertEquals(httpResponse.getStatusCodeName(),"NOT_FOUND");
        Mockito.doReturn(true)
               .when(fileService)
               .exists(httpRequest.getUrl());
        httpResponse = getMethodHandler.handleInternal(httpRequest);
        Assert.assertEquals(httpResponse.getStatusCode(),200);
        Assert.assertEquals(httpResponse.getStatusCodeName(),"OK");
        Assert.assertEquals(httpResponse.getHeaders().get("Content-Type"), "text/html; charset=utf-8");
        Assert.assertNull(httpResponse.getBody());
        Mockito.doReturn("<h1>GET Method</h1>")
               .when(fileService)
               .readFile(httpRequest.getUrl());
        httpResponse = getMethodHandler.handleInternal(httpRequest);
        Assert.assertEquals(httpResponse.getBody(),"<h1>GET Method</h1>");
    }

}
