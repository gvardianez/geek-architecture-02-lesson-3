package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private HttpRequestBuilder HttpRequestBuilder;

    private String method;

    private String url;

    private Map<String, String> headers = new HashMap<>();

    private String body;

    public HttpRequest() {
    }

    public HttpRequest(String method, String url, Map<String, String> headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public static HttpRequestBuilder createHttpRequest() {
        return new HttpRequestBuilder();
    }

    public static class HttpRequestBuilder {

        private final HttpRequest httpRequest;

        private HttpRequestBuilder() {
            httpRequest = new HttpRequest();
        }

        public HttpRequestBuilder addMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public HttpRequestBuilder addUrl(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public HttpRequestBuilder addHeaders(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }

        public HttpRequestBuilder addBody(String body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build() {
            return httpRequest;
        }

    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

}
