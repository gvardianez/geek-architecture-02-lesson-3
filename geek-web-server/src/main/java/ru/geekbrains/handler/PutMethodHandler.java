package ru.geekbrains.handler;

import ru.geekbrains.IResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.request.HttpRequest;
import ru.geekbrains.domain.request.decorator.Method;
import ru.geekbrains.domain.response.HttpResponse;
import ru.geekbrains.service.ISocketService;

@Handler(order = 0, method = Method.PUT)
public class PutMethodHandler extends MethodHandlerImpl {

    public PutMethodHandler(MethodHandler handler, ISocketService socketService, IResponseSerializer responseSerializer, ServerConfig config) {
        super(Method.PUT.toString(), handler, socketService, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createHttpResponse()
                           .addStatus(200)
                           .addStatusCodeName("OK")
                           .addBody("<h1>Put handle</h1>")
                           .build();
    }
}
