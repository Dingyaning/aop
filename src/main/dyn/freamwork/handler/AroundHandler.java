package freamwork.handler;

import java.lang.reflect.Method;

/**
 * Created by dingyaning on 2017/6/20.
 */
public abstract class AroundHandler extends  AbstractHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(proxy,method,args);
        Object object = method.invoke(getTarget(),args);
        after(proxy, method, args);

        return object;
    }

    public abstract void after(Object proxy, Method method, Object[] args);

    public abstract void before(Object proxy, Method method, Object[] args);
}
