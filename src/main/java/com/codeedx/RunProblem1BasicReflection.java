package com.codeedx;

import com.codeedx.external.app.ServiceA;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class RunProblem1BasicReflection {
    public static void main(String[] args) {
        Class<?> clazz = ServiceA.class;

        // Get the class name
        System.out.println("Class Name: " + clazz.getName());

        // Get the superclass
        System.out.println("Superclass: " + clazz.getSuperclass().getName());

        // Get the public methods
        System.out.println("Public Methods:");
        for (Method method : clazz.getMethods()) {
            System.out.println(" - " + Modifier.toString(method.getModifiers()) + " "  + method.getName());
        }
    }
}
