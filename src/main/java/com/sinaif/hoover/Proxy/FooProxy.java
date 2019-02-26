package com.sinaif.hoover.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理模式
 * 1.继承 InvocationHandler，重写invoke方法
 * 2.
 */
public class FooProxy   implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
