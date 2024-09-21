package com.codeedx.external.app;

import com.codeedx.reflection.Inject;

public class ServiceA implements ExecutorService {

    @Inject
    private Task task;

    public void execute() {
        System.out.println("ServiceB is executing");
        task.doSomething();
    }
}