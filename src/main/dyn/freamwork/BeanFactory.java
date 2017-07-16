package freamwork;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dingyaning on 2017/6/19.
 */
public class BeanFactory {

    public static Map<String,Object> factory = new HashMap();


    public void put(String beanName, Object bean) {
        if (factory.get(beanName) != null) {
            System.out.println("error! bean repetition!");
            return;
        }
        factory.put(beanName,bean);
    }

    public Object get(String beanName) {
        return factory.get(beanName);
    }

}
