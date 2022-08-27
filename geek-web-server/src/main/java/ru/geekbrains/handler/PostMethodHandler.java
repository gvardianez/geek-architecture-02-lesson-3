package ru.geekbrains.handler;

import ru.geekbrains.IResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.request.HttpRequest;
import ru.geekbrains.domain.request.decorator.Method;
import ru.geekbrains.domain.response.HttpResponse;
import ru.geekbrains.service.ISocketService;

@Handler(order = 1, method = Method.POST)
public class PostMethodHandler extends MethodHandlerImpl {

    public PostMethodHandler(MethodHandler handler, ISocketService socketService, IResponseSerializer responseSerializer, ServerConfig config) {
        super(Method.POST.toString(), handler, socketService, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createHttpResponse()
                           .addStatus(200)
                           .addStatusCodeName("OK")
                           .addBody("<h1>Post handle</h1>")
                           .build();
    }
}
