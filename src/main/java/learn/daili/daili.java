package learn.daili;

interface animal{
    public void eat(String message) ;
}
public class daili {
    public static void main(String[] args){
        bigdog bigdog = new bigdog() ;
        bigdog.eat(" pencil ");
    }
}
class dog implements animal{

    @Override
    public void eat(String message) {
        System.out.println("dog is eating " + message);
    }
}
class bigdog implements animal{

    @Override
    public void eat(String message) {
        dog dog = new dog() ;
        dog.eat(message);
    }
}