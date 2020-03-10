package learn.ProCus_2;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.naming.Name;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProCus_2 {
    private static final int PRODUCER_NUMS = 3 ;
    private static final int CONSUMER_NUMS = 5 ;
    public static void main(String[] args)throws InterruptedException{
        ReentrantLock lock = new ReentrantLock( );
        Condition pro = lock.newCondition() ;
        Condition cus = lock.newCondition() ;
        Resourse resourse = new Resourse() ;
        ExecutorService proPool = Executors.newFixedThreadPool(PRODUCER_NUMS) ;
        ExecutorService cusPool = Executors.newFixedThreadPool(CONSUMER_NUMS) ;
        for(int i = 0 ; i < PRODUCER_NUMS ; i++){
            proPool.execute(new Producer(resourse));
        }
        for(int i = 0 ; i< CONSUMER_NUMS ; i++){
            cusPool.execute(new Consumer(resourse));
        }
        Thread.sleep(5000);
        proPool.shutdownNow() ;
        cusPool.shutdownNow() ;

    }
}

class Resourse{
    private int productId = 1 ;
    private String productName  ;
    private boolean flag = false ;
    ReentrantLock lock = new ReentrantLock() ;
    Condition proCon = lock.newCondition() ;
    Condition cusCon = lock.newCondition() ;
    public void product(String Name){
        this.lock.lock();
        try{
            while(flag){
                proCon.await();
            }
            flag  = true ;
            this.productName = productId++ +  " -------- " + Name ;
            System.out.println(Thread.currentThread().getName() + " is Product " + this.productName);
            cusCon.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            this.lock.unlock();
        }
    }
    public void consume(){
        this.lock.lock();
        try{
            while(!flag){
                cusCon.await();
            }
            flag = false ;
            System.out.println(Thread.currentThread().getName() + " is consume " + this.productName);
            proCon.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            this.lock.unlock();
        }
    }
}
class Resource{
    private int productId = 1 ;
    private String productName  ;
    private boolean flag = false ;
    ReentrantLock lock = new ReentrantLock() ;
    Condition proCon = lock.newCondition() ;
    Condition conCon = lock.newCondition() ;
    public void product(String Name){
        lock.lock();
        try{
            while(flag){
                try {
                    proCon.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            this.productName = Name + " ------- " + productId++ ;
            System.out.println(Thread.currentThread().getName() + " 生产者正在生产: " + this.productName);
            flag = true ;
            conCon.signal();
        }finally {
            lock.lock();
        }
    }

    public void consume(){
        lock.lock();
        try{
            while(!flag){
                try{
                    conCon.await() ;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            flag = false ;
            System.out.println(Thread.currentThread().getName() + " 正在消费: " + this.productName);
            proCon.signal();
        }finally{
            lock.unlock();
        }
    }
}

class Consumer implements Runnable{
    Resourse resourse  ;

    public Consumer(Resourse resourse) {
        this.resourse = resourse;
    }

    @Override
    public void run() {
        while(true){
            resourse.consume();
        }
    }
}

class Producer implements Runnable{
    Resourse resourse  ;

    public Producer(Resourse resourse) {
        this.resourse = resourse;
    }

    @Override
    public void run() {
        while(true){
            resourse.product(" pen ");
        }
    }
}


