package ru.geekbrains.domain.request;

public class RequestFactory {

    public static Request createGetHttpRequest(Request httpRequest) {
        return new GetHttpRequest(httpRequest);
    }

    public static Request createPostHttpRequest(Request httpRequest) {
        return new PostHttpRequest(httpRequest);
    }

    public static Request createHttpRequestWithMethod(Request request, String method) {
        switch (method) {
            case "GET":
                return new GetHttpRequest(request);

            case "POST":
                return new PostHttpRequest(request);

            default:
                throw new RuntimeException("Invalid method");
        }

    }


}
