package ru.geekbrains.service;

import java.net.Socket;

public final class SocketServiceFactory {

    public static ISocketService create(Socket socket){
        return new SocketService(socket);
    }


}
