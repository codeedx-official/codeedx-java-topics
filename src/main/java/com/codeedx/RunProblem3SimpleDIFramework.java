package com.codeedx;

import com.codeedx.external.app.ServiceA;
import com.codeedx.external.app.SomeTask;
import com.codeedx.external.app.Task;
import com.codeedx.reflection.SimpleDIFramework;

public class RunProblem3SimpleDIFramework {
    public static void main(String[] args) {
        // Create an instance of the DI framework
        SimpleDIFramework diFramework = new SimpleDIFramework();

        // Register dependencies
        diFramework.registerDependency(Task.class, new SomeTask());

        // Create an instance of ServiceB
        ServiceA serviceA = new ServiceA();

        // Inject dependencies into ServiceB
        diFramework.injectDependencies(serviceA);

        // Now, ServiceB can use ServiceA
        serviceA.execute();
    }
}
