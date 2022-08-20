package ru.geekbrains.service;

import java.net.Socket;

public final class ServiceFactory { // не уверен, что стоит вот например объединить создание двух сервисов,
    // все же они выполняют достаточно разные задачи

    public static ISocketService createSocketService(Socket socket){
        return new SocketService(socket);
    }

    public static IFileService createFileService(String rootDir) {
        return new FileService(rootDir);
    }

}
