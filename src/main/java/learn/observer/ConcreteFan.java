package learn.observer;

//具体观察者
public class  ConcreteFan implements  Fan{
    private String fanName ;

    public ConcreteFan(String fanName) {
        this.fanName = fanName;
    }

    @Override
    public void update(String message) {
        System.out.println(fanName + " 知道了： "+ message);
    }
}
