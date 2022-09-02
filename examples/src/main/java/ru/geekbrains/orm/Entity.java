package ru.geekbrains.orm;

public interface Entity {

    void markNew();

    void markUpdate();

    void markRemoved();

}
