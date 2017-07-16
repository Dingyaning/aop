package freamwork.handler;

import java.lang.reflect.Method;

/**
 * Created by dingyaning on 2017/6/20.
 */
public class MyAfter extends AfterHandler {
    @Override
    public void after(Object proxy, Method method, Object[] args) {
        System.out.println("--------after handler--------");
    }
}
