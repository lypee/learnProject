package learn.single;

public class single {
  private static class getInstance{
      private static single instance = new single();
  }
  private single(){}

  public single getSingle(){
      return getInstance.instance ;
  }
}
class singleone{
    private static class Instance{
        private static singleone instance = new singleone() ;
    }
    private singleone(){}
    public singleone getInstance(){
        return Instance.instance ;
    }
}
class singletwo{
    private volatile static singletwo instance = null ;
    private singletwo(){}
    public static singletwo getInstance(){
        if(instance == null){
            synchronized(singletwo.class){
                if(instance == null){
                    instance = new singletwo() ;
                }
            }
        }
        return instance ;
    }
}
class singleThree{
    private static volatile  singleThree  instance = null ;
    private  singleThree(){}
    public singleThree getInstance(){
        if(instance == null){
            synchronized (singleThree.class){
                if(instance == null){
                    instance = new singleThree() ;
                }
            }
        }
        return instance ;
    }
}
class singleFour{
    private static class createInstance{
        private  static final singleFour instarnce = new singleFour() ;
    }
    private  singleFour(){}
    public singleFour getInstance(){
        return createInstance.instarnce ;
    }
}
class singleFive{
    private static singleFive instance = null ;
    private singleFive(){}
    public static singleFive getInstance(){
        if(instance == null){
            synchronized (singleFive.class){
                if(instance == null){
                    instance = new singleFive() ;
                }
            }
        }
        return instance ;
    }
}
class singleSix{
    private static class instance{
        private static singleSix instance =  new singleSix() ;
    }
    private singleSix(){}
    public static singleSix getInstance(){
        return instance.instance ;
    }
}
