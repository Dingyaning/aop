package freamwork.handler;

import java.lang.reflect.Method;

/**
 * Created by dingyaning on 2017/6/20.
 */
public class MyBefore extends BeforeHandler {

    @Override
    public void before(Object proxy, Method method, Object[] args) {
        System.out.println("--------before handler--------");
    }
}
