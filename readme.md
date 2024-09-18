# Mastering Java Reflections

## Coding Exercises

### Problem 1 - Basic Reflection

Given the following setup with an `ExecutorService` and a `Task` interface, we want to explore the class details of `ServiceA` using Java Reflection.

**Problem Statement:**

Write a program that:

1. Uses Java Reflection to inspect the `ServiceA` class.
2. Prints the name of the class.
3. Prints the name of its superclass.
4. Prints the names and modifiers of all public methods declared in the class.

Use the following interfaces and class structure for the exercise:

```java
public interface ExecutorService {
    void execute();
}

public class ServiceA implements ExecutorService {

    private Task task;

    public void execute() {
        System.out.println("ServiceA is executing");
        task.doSomething();
    }
}

public interface Task {
    void doSomething();
}
```

**Hints**:

- You can retrieve the class name, superclass, and methods of `ServiceA` using the `Class` object and methods like `getName()`, `getSuperclass()`, and `getMethods()`.
- The public methods include both declared and inherited methods.

**Expected Output**:

Your program should output something similar to this:

```
Class Name: ServiceA
Superclass: java.lang.Object
Public Methods:
 - public void execute()
 - public final native void wait(long)
 - public final native void wait(long, int)
 - public void wait()
 - public boolean equals(java.lang.Object)
 - public java.lang.String toString()
 - public int hashCode()
 - public final native java.lang.Class getClass()
 - public final native void notify()
 - public final native void notifyAll()
```

### Problem 2 - Build `ReflectionUtils`

**Problem Statement:**

Create a utility class, `ReflectionUtils`, to demonstrate various functionalities of Java Reflection. The class should be able to:

1. **Print Class Information**: Display the class name, superclass, and implemented interfaces.
2. **Print Methods**: List all public methods and also provide an option to list all methods, including private ones.
3. **Invoke Methods**: Invoke all public methods, and provide functionality to invoke private methods as well.
4. **Print Fields**: List all public fields, and provide an option to include private fields.
5. **Handle Annotations**: Print all annotations on the class, its methods, and fields.
6. **Create Instances Dynamically**: Dynamically create a new instance of any class, even if it has private constructors.

### Problem 3 - Build a `SimpleDIFramework` like Spring

**Problem Statement:**

Build a simple **Dependency Injection (DI) framework** using Java Reflection. The goal is to automatically inject dependencies into a target object's fields annotated with `@Inject`, without requiring manual initialization.

The framework should:

1. **Register Dependencies**: Allow registering pre-existing dependencies into a map for future injections.
2. **Inject Dependencies**: Automatically inject the necessary dependencies into the target object's fields that are marked with `@Inject`.
3. **Handle Missing Dependencies**: If a dependency is not already registered, the framework should create it using its no-argument constructor and register it for future use.
4. **Support Private Fields**: Ensure that private fields can also have dependencies injected.