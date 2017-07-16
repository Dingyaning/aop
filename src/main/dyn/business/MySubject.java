package business;

/**
 * Created by dingyaning on 2017/6/20.
 */
public class MySubject implements Subject,Subject2{
    @Override
    public void dosomething() {
        System.out.println("----- do something -----");
    }

    @Override
    public void dance() {
        System.out.println("----- dance -----");
    }
}
