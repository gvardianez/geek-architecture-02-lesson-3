package ru.geekbrains.service;

public interface IFileService {

    String readFile(String filename);

    boolean exists(String filename);

    boolean isDirectory(String filename);

}
