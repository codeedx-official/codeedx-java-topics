package com.codeedx.external.app;

public class ServiceA implements ExecutorService {
    private Task task;

    public void execute() {
        System.out.println("ServiceB is executing");
        task.doSomething();
    }
}