package com.codeedx.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleDIFramework {

    private final Map<Class<?>, Object> dependencyMap = new HashMap<>();

    // Method to register a dependency
    public void registerDependency(Class<?> type, Object implementation) {
        dependencyMap.put(type, implementation);
    }

    // Method to inject dependencies into the target object
    public void injectDependencies(Object target) {
        Class<?> clazz = target.getClass();

        // Iterate over all fields of the class
        for (Field field : clazz.getDeclaredFields()) {
            // Check if the field is annotated with @Inject
            if (field.isAnnotationPresent(Inject.class)) {
                // Get the field type (class of the field)
                Class<?> fieldType = field.getType();

                // Find the corresponding dependency in the map
                Object dependency = dependencyMap.get(fieldType);

                // If dependency is not registered, create it and register it
                if (dependency == null) {
                    dependency = createDependency(fieldType);
                    if (dependency != null) {
                        registerDependency(fieldType, dependency);
                    } else {
                        throw new RuntimeException("Failed to create dependency: " + fieldType.getName());
                    }
                }

                // Inject the dependency
                field.setAccessible(true); // Allow access to private fields
                try {
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject dependency: " + fieldType.getName(), e);
                }
            }
        }
    }

    // Helper method to create a dependency using reflection
    private <T> T createDependency(Class<T> type) {
        try {
            // Try to find a no-argument constructor
            Constructor<T> constructor = type.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of: " + type.getName(), e);
        }
    }

}

