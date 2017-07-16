package freamwork.handler;

import java.lang.reflect.Method;

/**
 * Created by dingyaning on 2017/6/19.
 */
public abstract class AfterHandler extends AbstractHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object ob = method.invoke(getTarget(),args);
        after(proxy, method, args);
        return ob;
    }


    public abstract void after(Object proxy, Method method, Object[] args);
}
