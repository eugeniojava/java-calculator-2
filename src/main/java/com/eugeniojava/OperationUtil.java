package com.eugeniojava;

import com.eugeniojava.operation.Operation;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class OperationUtil {
    private static final Map<String, Operation> operations = new HashMap<>();
    private static final String OPERATION_PACKAGE = "com.eugeniojava.operation";

    static {
        loadOperations();
    }

    private OperationUtil() {
    }

    public static Map<String, Operation> getOperations() {
        return operations;
    }

    private static void loadOperations() {
        getOperationClasses().forEach(oc -> operations.put(
                oc.getDeclaredAnnotation(Symbol.class).value(),
                getInstanceOf(oc)
        ));
    }

    private static Set<Class<?>> getOperationClasses() {
        Reflections reflections = new Reflections(OPERATION_PACKAGE);
        return reflections.getTypesAnnotatedWith(Symbol.class);
    }

    private static Operation getInstanceOf(Class<?> clazz) {
        try {
            return (Operation) clazz.getConstructors()[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
