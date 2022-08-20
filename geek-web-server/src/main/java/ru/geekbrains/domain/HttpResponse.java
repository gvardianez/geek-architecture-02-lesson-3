package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private int statusCode;

    private String statusCodeName;

    private Map<String, String> headers = new HashMap<>();

    private String body;

    public HttpResponse() {
    }

    public static HttpResponseBuilder createHttpResponse() {
        return new HttpResponseBuilder();
    }

    public static class HttpResponseBuilder {

        private final HttpResponse httpResponse;

        private HttpResponseBuilder() {
           httpResponse = new HttpResponse();
        }

        public HttpResponseBuilder addStatus(int status) {
            this.httpResponse.statusCode = status;
            return this;
        }

        public HttpResponseBuilder addStatusCodeName(String statusCodeName) {
            this.httpResponse.statusCodeName = statusCodeName;
            return this;
        }

        public HttpResponseBuilder addHeaders(Map<String, String> headers) {
            this.httpResponse.headers = headers;
            return this;
        }

        public HttpResponseBuilder addBody(String body) {
            this.httpResponse.body = body;
            return this;
        }

        public HttpResponse build() {
            return httpResponse;
        }

    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
    public String getStatusCodeName() {
        return statusCodeName;
    }

}
