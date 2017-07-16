package business;

import freamwork.BeanFactory;
import freamwork.ProxyFactory;
import freamwork.handler.MyAfter;
import freamwork.handler.MyAround;
import freamwork.handler.MyBefore;

import java.util.ArrayList;
import java.util.List;


public class Client {
    public static void main(String[] args) {
        //注入bean
        BeanFactory beanFactory = init();

        //设置代理
        ProxyFactory proxyFactory = (ProxyFactory) beanFactory.get("proxyFactory");

        //返回代理类
        Subject subject = (Subject) proxyFactory.createProxy();

        //输出切面后的内容
        subject.dosomething();

//        Subject2 subject2 = (Subject2) proxyFactory.createProxy();
//        subject2.dance();
    }


    //注入bean
    public static BeanFactory init(){
        BeanFactory beanFactory = new BeanFactory();


        //注入切面
        beanFactory.put("MyBefore", new MyBefore());
        beanFactory.put("MyAfter", new MyAfter());
        beanFactory.put("MyAround", new MyAround());

        //注入被代理类
        Subject target = new MySubject();
        beanFactory.put("realSubject", target);

        //新生成一个代理类
        ProxyFactory proxyFactory = new ProxyFactory();

        //写入代理接口
        List<Class> proxyInterface = new ArrayList<>();
        proxyInterface.add(Subject.class);
        proxyInterface.add(Subject2.class);
        proxyFactory.setProxyInterfaces(proxyInterface);
        //写入切点
        String[] handlerNames = new String[]{"MyBefore","MyAfter","MyAround"};
        proxyFactory.setInterceptorNames(handlerNames);
        //写入目标类
        proxyFactory.setTarget(target);

        //注入代理类
        beanFactory.put("proxyFactory", proxyFactory);


        return beanFactory;
    }
}


