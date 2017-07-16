package freamwork;

import business.Subject;
import freamwork.handler.AbstractHandler;

import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <bean id=""
 *
 *
 *
 *
 */
public class ProxyFactory {

    private Object target;

    List<AbstractHandler> handlers = new ArrayList<>();

    Class[] targetInterfaces;


    //代理的目标类
    public void setTarget(Subject subject){
        target = subject;
    }


    //代理的接口
    public void setProxyInterfaces(List<Class> proxyInterface) {

        targetInterfaces = proxyInterface.toArray(new Class[proxyInterface.size()]);
    }



    //加入切面
    public void setInterceptorNames(String[] interceptors) {
        List<String>  handlerNames = Arrays.asList(interceptors);
        for (String handlerName : handlerNames) {
            AbstractHandler handlerType = (AbstractHandler)BeanFactory.factory.get(handlerName);
            handlers.add(handlerType);
        }
    }

    //拿代理类
    public Object createProxy(){
        Object proxyObject =  target;


        for (int i=0;i < handlers.size(); ++i) {

            handlers.get(i).setTarget(proxyObject);//循环注入切面

            proxyObject = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                    targetInterfaces, handlers.get(i));
        }

        return proxyObject;

    }

}
