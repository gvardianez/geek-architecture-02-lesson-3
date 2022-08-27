package ru.geekbrains.handler;

import ru.geekbrains.IResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.request.HttpRequest;
import ru.geekbrains.domain.request.decorator.Method;
import ru.geekbrains.domain.response.HttpResponse;
import ru.geekbrains.service.IFileService;
import ru.geekbrains.service.ISocketService;

import java.util.HashMap;

@Handler(order = 0, method = Method.GET)
public class GetMethodHandler extends MethodHandlerImpl {

    private final IFileService fileService;

    public GetMethodHandler(MethodHandler handler,
                            ISocketService socketService,
                            IResponseSerializer responseSerializer,
                            ServerConfig config,
                            IFileService fileService) {
        super(Method.GET.toString(), handler, socketService, responseSerializer, config);
        this.fileService = fileService;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        if (!fileService.exists(request.getUrl())) {
            return HttpResponse.createHttpResponse()
                               .addStatus(404)
                               .addStatusCodeName("NOT_FOUND")
                               .addHeaders(new HashMap<>() {{
                                   put("Content-Type", "text/html;     charset=utf-8");
                               }})
                               .build();
        }

        return HttpResponse.createHttpResponse()
                           .addStatus(200)
                           .addStatusCodeName("OK")
                           .addHeaders(new HashMap<>() {{
                               put("Content-Type", "text/html; charset=utf-8");
                           }})
                           .addBody(fileService.readFile(request.getUrl()))
                           .build();

    }
}
