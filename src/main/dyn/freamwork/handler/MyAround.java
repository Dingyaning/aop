package freamwork.handler;

import java.lang.reflect.Method;

/**
 * Created by dingyaning on 2017/6/20.
 */
public class MyAround extends AroundHandler {

    @Override
    public void after(Object proxy, Method method, Object[] args) {
        System.out.println("--------after around handler--------");
    }

    @Override
    public void before(Object proxy, Method method, Object[] args) {
        System.out.println("--------before around handler--------");
    }
}
