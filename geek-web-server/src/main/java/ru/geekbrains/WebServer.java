package ru.geekbrains;

import ru.geekbrains.config.*;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.ServiceFactory;
import ru.geekbrains.service.SocketService;
import ru.geekbrains.service.SocketServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        ServerConfig config = ServerConfigFactory.create(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(RequestHandler.getInstance(
                        ServiceFactory.createSocketService(socket),
                        ServiceFactory.createFileService(config.getWww()),
                        RequestParser.getInstance(),
                        ResponseSerializer.getInstance()
                )).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
