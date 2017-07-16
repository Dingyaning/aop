package test;

/**
 * Created by dingyaning on 2017/7/16.
 */
public class Test {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        UserService proxy = (UserService) invocationHandler.getProxy();

        proxy.doSomething();
    }
}
