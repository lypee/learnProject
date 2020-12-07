package learn.observer;

public class observer {
    public static void main(String[] args){
        ConcreteIdol idol = new ConcreteIdol() ;
        ConcreteFan fanA = new ConcreteFan("A") ;
        ConcreteFan fanB = new ConcreteFan("B");
        ConcreteFan fanC = new ConcreteFan("C");
        idol.addFan(fanA);
        idol.addFan(fanB);
        idol.addFan(fanC);
        idol.notify(" this is a message ");
    }
}
