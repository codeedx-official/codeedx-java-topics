package com.codeedx.external.app;

public class SomeTask implements Task {
    public void doSomething() {
        print("Doing Some Task");
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}
