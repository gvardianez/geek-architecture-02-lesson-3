package ru.geekbrains;

import ru.geekbrains.domain.request.HttpRequest;
import ru.geekbrains.handler.MethodHandler;
import ru.geekbrains.service.ISocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final ISocketService socketService;
    private final IRequestParser requestParser;
    private final MethodHandler methodHandler;

    public static RequestHandler getInstance(ISocketService socketService,
                                             IRequestParser requestParser,
                                             MethodHandler methodHandler) {

        return new RequestHandler(socketService, requestParser, methodHandler);
    }

    private RequestHandler(ISocketService socketService,
                           IRequestParser requestParser,
                           MethodHandler methodHandler) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.methodHandler = methodHandler;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest req = requestParser.parse(rawRequest);
        methodHandler.handle(req);
        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
