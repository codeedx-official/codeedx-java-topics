package com.codeedx.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ReflectionUtils {

    // 1. Print Class info
    public static void printClassInfo(Class<?> clazz) {
        System.out.println("Class Name: " + clazz.getName());
        System.out.println("Superclass: " + clazz.getSuperclass());
        System.out.println("Interfaces: ");
        for (Class<?> iface : clazz.getInterfaces()) {
            System.out.println(" - " + iface.getName());
        }
        System.out.println();
    }

    // 2. Print all methods
    public static void printAllMethods(Class<?> clazz) {
        System.out.println("Public Methods:");
        for (Method method : clazz.getMethods()) {
            System.out.println(" - " + method.getName());
        }
        System.out.println();
    }

    // 3. Print all methods including private
    public static void printAllMethodsIncludingPrivate(Class<?> clazz) {
        System.out.println("All Methods (including private):");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(" - " + method.getName());
        }
        System.out.println();
    }

    // 4. Invoke all public methods
    public static void invokeAllMethods(Object instance) {
        Class<?> clazz = instance.getClass();
        for (Method method : clazz.getMethods()) {
            if (method.getParameterCount() == 0) { // Only invoke methods with no parameters
                try {
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println("Failed to invoke method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    // 5. Invoke all methods including private
    public static void invokeAllMethodsIncludingPrivate(Object instance) {
        Class<?> clazz = instance.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getParameterCount() == 0) { // Only invoke methods with no parameters
                try {
                    method.setAccessible(true); // Make private methods accessible
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println("Failed to invoke method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    // 6. Print all fields
    public static void printAllFields(Class<?> clazz) {
        System.out.println("Public Fields:");
        for (Field field : clazz.getFields()) {
            System.out.println(" - " + field.getName() + " (type: " + field.getType().getName() + ")");
        }
        System.out.println();
    }

    // 7. Print all fields including private
    public static void printAllFieldsIncludingPrivate(Class<?> clazz) {
        System.out.println("All Fields (including private):");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(" - " + field.getName() + " (type: " + field.getType().getName() + ")");
        }
        System.out.println();
    }

    // 8. Print all annotations
    public static void printAllAnnotations(Class<?> clazz) {
        System.out.println("Annotations:");
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(" - " + annotation.annotationType().getName());
        }
        // Print annotations on methods
        System.out.println("\nAnnotations at Method Level:");
        for (Method method : clazz.getDeclaredMethods()) {
            for (Annotation annotation : method.getAnnotations()) {
                System.out.println("Method: " + method.getName() + " - " + annotation.annotationType().getName());
            }
        }

        // Print annotations on fields
        System.out.println("\nAnnotations at Field Level:");
        for (Field field : clazz.getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                System.out.println("Field: " + field.getName() + " - " + annotation.annotationType().getName());
            }
        }
        System.out.println();
    }

    // 9. Create a new instance of the class
    public static <T> T newInstance(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true); // Make the constructor accessible if it's private
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create a new instance of: " + clazz.getName(), e);
        }
    }
}
