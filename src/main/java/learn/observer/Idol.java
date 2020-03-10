package learn.observer;

//抽象主题
public interface Idol {
    public void addFan(Fan fan) ;
    public void deFan(Fan fan) ;
    public void notify(String message) ;
}
