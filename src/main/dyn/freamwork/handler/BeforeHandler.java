package freamwork.handler;

import java.lang.reflect.Method;

/**
 * Created by dingyaning on 2017/6/19.
 */
public abstract class BeforeHandler extends AbstractHandler  {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(proxy,method,args);
        return method.invoke(getTarget(),args);
    }

    public abstract void before(Object proxy, Method method, Object[] args);
}
