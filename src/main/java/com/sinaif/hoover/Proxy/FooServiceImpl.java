package com.sinaif.hoover.Proxy;

public class FooServiceImpl implements FooService {
    @Override
    public void doMethod() {
        System.out.println("--------------doMethod--------------");
    }

    @Override
    public void doFields(String fields) {
        System.out.println("--------------doFields--------------"+fields);
    }

    @Override
    public void doClass() {
        System.out.println("--------------doClass--------------");
    }
}
