package ru.geekbrains.handler;

import org.reflections.Reflections;
import ru.geekbrains.IResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.service.IFileService;
import ru.geekbrains.service.ISocketService;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodHandlerFactory {

    public static MethodHandler create(ISocketService socketService,
                                       IResponseSerializer responseSerializer,
                                       ServerConfig config,
                                       IFileService fileService) {
        PutMethodHandler putMethodHandler = new PutMethodHandler(null, socketService, responseSerializer, config);
        PostMethodHandler postMethodHandler = new PostMethodHandler(putMethodHandler, socketService, responseSerializer, config);
        return new GetMethodHandler(postMethodHandler, socketService, responseSerializer, config, fileService);
    }

    public static MethodHandler createAnnotation(ISocketService socketService,
                                                 IResponseSerializer responseSerializer,
                                                 ServerConfig config,
                                                 IFileService fileService) {
        Reflections reflections = new Reflections("ru.geekbrains.handler");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Handler.class);
        classes.stream().map(aClass -> aClass.getAnnotation(Handler.class) //проверка, если несколько аннотаций с одним и тем же типом метода
                                             .method()
                                             .toString())
               .collect(Collectors.toMap(
                       Function.identity(),
                       x -> 1,
                       Integer::sum
               )).forEach((s, integer) -> {
            if (integer > 1) {
                throw new RuntimeException("There should only be one of each type of method");
            }
        });
        classes.forEach(aClass -> {
            if (!MethodHandler.class.isAssignableFrom(aClass)) {
                throw new RuntimeException("Type must be MethodHandler");
            }
        });
        classes = classes.stream().sorted(Comparator.comparingInt(o -> o.getAnnotation(Handler.class).order())).collect(Collectors.toCollection(LinkedHashSet::new));
        MethodHandler methodHandler = null;
        try {
            for (Class<?> aClass : classes) {
                if (aClass.getAnnotation(Handler.class).method().toString().equals("GET")) {
                    methodHandler = (MethodHandler) aClass.getDeclaredConstructor(
                            MethodHandler.class,
                            ISocketService.class,
                            IResponseSerializer.class,
                            ServerConfig.class,
                            IFileService.class).newInstance(methodHandler, socketService, responseSerializer, config, fileService);
                } else {
                    methodHandler = (MethodHandler) aClass.getDeclaredConstructor(
                            MethodHandler.class,
                            ISocketService.class,
                            IResponseSerializer.class,
                            ServerConfig.class).newInstance(methodHandler, socketService, responseSerializer, config);
                }
            }
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return methodHandler;

    }

}
