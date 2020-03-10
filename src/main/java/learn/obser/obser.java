package learn.obser;

public class obser {
    public static void main(String[] args){
        createPaimai paimai = new createPaimai() ;
        paimai.add(new createMaijia("a"));
        paimai.add(new createMaijia("b"));
        paimai.add(new createMaijia("c"));
        paimai.add(new createMaijia("d"));
        paimai.changeMoney(5);
        paimai.changeMoney(10);
    }
}
