package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import java.util.Deque;

public interface IRequestParser {

    HttpRequest parse(Deque<String> rawRequest);

}
