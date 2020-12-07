package learn.print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class print{
    public static void main(String[] args)throws InterruptedException {
        ReentrantLock lock = new ReentrantLock() ;
        Condition oddCondition = lock.newCondition() ;
        Condition evenCondition = lock.newCondition() ;
        ExecutorService poolService = Executors.newFixedThreadPool(2) ;
        // = new ThreadPoolExecutor(2 ,2 ,60 ,TimeUtil.Second ,new ArrayBlockingQueue<>()) ;
        poolService.execute(new printNumber(lock , oddCondition , evenCondition , "threadA")) ;
        poolService.execute(new printNumber(lock , oddCondition , evenCondition , "threadB")) ;
        Thread.sleep(5000) ;
        poolService.shutdownNow();
    }
}

class printNumber implements Runnable{
    private static AtomicInteger counter = new AtomicInteger(1) ;
    private ReentrantLock lock ;
    private Condition oddCondition ;
    private Condition evenCondition ;
    private String key ;
    public printNumber(ReentrantLock lock , Condition oddCondition , Condition evenCondition , String key){
        this.lock = lock ;
        this.oddCondition = oddCondition ;
        this.evenCondition = evenCondition ;
        this.key = key ;
    }
    @Override
    public void run(){
        lock.lock() ;
        try{
            while(counter.get() <= 100){
                if(counter.get() % 2 == 0){
                    System.out.println(key + ": " + counter.getAndIncrement()) ;
                    oddCondition.signal() ;
                    evenCondition.await() ;
                }else{
                    System.out.println(key + ": " + counter.getAndIncrement()) ;
                    evenCondition.signal() ;
                    oddCondition.await() ;
                }
            }
            evenCondition.signal() ;
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }finally{
            lock.unlock() ;
        }
    }
}