package com.codeedx;

import com.codeedx.external.app.ServiceA;
import com.codeedx.external.app.SomeTask;
import com.codeedx.reflection.ReflectionUtils;

public class RunProblem2ReflectionUtils {
    public static void main(String[] args) {
        // Obtain the Class Object
        Class<SomeTask> clazz = SomeTask.class;

        // 1. Print class info
        ReflectionUtils.printClassInfo(clazz);

        // 2. Print all methods
        ReflectionUtils.printAllMethods(clazz);

        // 3. Print all methods including private
        ReflectionUtils.printAllMethodsIncludingPrivate(clazz);

        // 4. Invoke all public methods
        SomeTask someTask = ReflectionUtils.newInstance(clazz);
        // ReflectionUtils.invokeAllMethods(taskA);

        // 5. Invoke all methods including private
        ReflectionUtils.invokeAllMethodsIncludingPrivate(someTask);

        // 6. Print all fields
        ReflectionUtils.printAllFields(clazz);

        // 7. Print all fields including private
        ReflectionUtils.printAllFieldsIncludingPrivate(clazz);

        // 8. Print all annotations
        ReflectionUtils.printAllAnnotations(ServiceA.class);
    }
}
