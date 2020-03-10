package learn.obser;

import java.util.ArrayList;
import java.util.List;

public class createPaimai implements paimai{
    public List<maijia> list = new ArrayList<>() ;
    @Override
    public void changeMoney(int newMoney) {
        for(maijia item : list){
            item.update(newMoney);
        }
    }

    @Override
    public void add(maijia maijia) {
        list.add(maijia) ;
    }
}
