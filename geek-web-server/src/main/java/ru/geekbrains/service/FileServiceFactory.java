package ru.geekbrains.service;

public final class FileServiceFactory {

    public static IFileService create(String rootDir) { //если бы у нас было несколько реализаций
        return new FileService(rootDir);                //FileService была бы какая то выборка, а                                                           так это просто в целях обучения, как я                                                              понимаю пример
    }

}
