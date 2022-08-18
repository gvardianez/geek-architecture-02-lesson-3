package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.IFileService;
import ru.geekbrains.service.ISocketService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;

public class RequestHandler implements Runnable {

    private final ISocketService socketService;
    private final IFileService fileService;
    private final IRequestParser requestParser;
    private final ResponseSerializer responseSerializer;

    public static RequestHandler getInstance(ISocketService socketService,
                                             IFileService fileService,
                                             IRequestParser requestParser,
                                             ResponseSerializer responseSerializer) {

        return new RequestHandler(socketService, fileService, requestParser, responseSerializer);
    }

    private RequestHandler(ISocketService socketService,
                           IFileService fileService,
                           IRequestParser requestParser,
                           ResponseSerializer responseSerializer) {
        this.socketService = socketService;
        this.fileService = fileService;
        this.requestParser = requestParser;
        this.responseSerializer = responseSerializer;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest req = requestParser.parse(rawRequest);

        if (!fileService.exists(req.getUrl())) {
            HttpResponse resp = HttpResponse.createHttpResponse()
                    .addStatus(404)
                    .addStatusCodeName("NOT_FOUND")
                    .addHeaders(new HashMap<>() {{
                        put("Content-Type", "text/html; charset=utf-8");
                    }})
                    .build();
            socketService.writeResponse(responseSerializer.serialize(resp));
            return;
        }

        HttpResponse resp = HttpResponse.createHttpResponse()
                .addStatus(200)
                .addStatusCodeName("OK")
                .addHeaders(new HashMap<>() {{
                    put("Content-Type", "text/html; charset=utf-8");
                }})
                .addBody(fileService.readFile(req.getUrl()))
                .build();
        socketService.writeResponse(responseSerializer.serialize(resp));

        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
