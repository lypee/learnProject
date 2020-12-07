package learn.observer;

import java.util.ArrayList;
import java.util.List;

//具体主题
public class ConcreteIdol implements Idol {
    private List<Fan> list = new ArrayList<>() ;
    @Override
    public void addFan(Fan fan) {
        list.add(fan) ;
    }

    @Override
    public void deFan(Fan fan) {
        list.remove(fan) ;
    }

    @Override
    public void notify(String message) {
        for(Fan fan: list){
            fan.update(message);
        }
    }
}
