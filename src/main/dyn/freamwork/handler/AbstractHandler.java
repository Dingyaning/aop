package freamwork.handler;

import java.lang.reflect.InvocationHandler;

/**
 * Created by dingyaning on 2017/6/20.
 */
public abstract class AbstractHandler implements InvocationHandler {

    private Object target;


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
