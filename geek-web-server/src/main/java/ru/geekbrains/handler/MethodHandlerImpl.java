package ru.geekbrains.handler;

import ru.geekbrains.IResponseSerializer;
import ru.geekbrains.domain.request.HttpRequest;
import ru.geekbrains.domain.response.HttpResponse;
import ru.geekbrains.service.ISocketService;

public abstract class MethodHandlerImpl implements MethodHandler {

    private final String method;

    private final MethodHandler nextHandler;

    protected final ISocketService socketService;

    protected final IResponseSerializer responseSerializer;

    public MethodHandlerImpl(String method, MethodHandler handler, ISocketService socketService, IResponseSerializer responseSerializer) {
        this.method = method;
        this.nextHandler = handler;
        this.socketService = socketService;
        this.responseSerializer = responseSerializer;
    }

    @Override
    public void handle(HttpRequest httpRequest) {
        HttpResponse response;
        if (method.equals(httpRequest.getMethod())) {
            response = handleInternal(httpRequest);
        } else if (nextHandler != null) {
            nextHandler.handle(httpRequest);
            return;
        }else {
            response = HttpResponse.createHttpResponse()
                    .addStatus(405)
                    .addStatusCodeName("METHOD_NOT_ALLOWED")
                    .addBody("<h1>Method not allowed</h1>")
                    .build();
        }
        String res = responseSerializer.serialize(response);
        socketService.writeResponse(res);
    }


    protected abstract HttpResponse handleInternal(HttpRequest request);
}
