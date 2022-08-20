package ru.geekbrains.service;

import java.io.Closeable;
import java.util.Deque;

public interface ISocketService extends Closeable {

    Deque<String> readRequest();

    void writeResponse(String rawResponse);

}
