package learn.printNumber;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class printNumber {
    public static void main(String[] args)throws InterruptedException{
        ReentrantLock lock = new ReentrantLock() ;
        Condition conditionA = lock.newCondition() ;
        Condition conditionB = lock.newCondition() ;
        Condition conditionC = lock.newCondition() ;

        ExecutorService poolService = new ThreadPoolExecutor(3,3,60 , TimeUnit.SECONDS ,new LinkedBlockingDeque<>()) ;
        poolService.execute(new Eight(lock , conditionA ,conditionB));
        poolService.execute(new Eight(lock , conditionB ,conditionC));
        poolService.execute(new Eight(lock, conditionC ,conditionA));
        Thread.sleep(5000);
        poolService.shutdownNow() ;
    }
}
class One{
    private static final AtomicInteger counter = new AtomicInteger(0) ;
    public static class Worker implements Runnable{
        private static final int TOTAL_PRINT_COUNT = 100 ;
        private static final int PRE_PRINT_COUNT = 1 ;
        private final Condition current ;
        private final Condition after ;
        private final ReentrantLock lock  ;
        private String key ;
        public Worker(String key ,ReentrantLock lock, Condition current, Condition after) {
            this.lock = lock;
            this.current = current;
            this.after = after;
            this.key = key ;
        }
        @Override
        public void run() {
            this.lock.lock();
            try{
                for(int i = 0 ; i < TOTAL_PRINT_COUNT ; i++){
                        System.out.println(key + " 正在打印: "+ counter.incrementAndGet());
                        after.signal();
                    if(i < TOTAL_PRINT_COUNT   ){
                        try{
                            current.await();
                        }catch (InterruptedException e ){
                            e.printStackTrace();
                        }
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
class Two{
    private ReentrantLock lock ;
    private Condition conditionA ;
    private Condition conditionB ;
    private Condition conditionC ;
    private static final AtomicInteger counter = new AtomicInteger(0) ;
    public static class Worker implements Runnable{
        private static final int TOTAL_PRINT_COUNT = 100 ;
        String key ;
        Lock lock ;
        Condition current ;
        Condition next ;

        public Worker(String key, Lock lock, Condition current, Condition next) {
            this.key = key;
            this.lock = lock;
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            this.lock.lock();
            try{
                while(counter.get() < 100){
                    System.out.println(key + " 正在打印: "+ counter.incrementAndGet());
                    next.signal();
                    current.await();
                    next.signal();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally{
                this.lock.unlock();
            }
        }
    }
}
class Three implements Runnable{
    private static final AtomicInteger counter = new AtomicInteger(0) ;
    Lock lock = new ReentrantLock()  ;
    Condition current = lock.newCondition() ;
    Condition next = lock.newCondition() ;

    public Three(Lock lock, Condition current, Condition next) {
        this.lock = lock;
        this.current = current;
        this.next = next;
    }


    @Override
    public void run() {
        lock.lock();
        try{
            while(counter.get() < 100){
                System.out.println(Thread.currentThread().getName() + " 正在打印： "+counter.incrementAndGet());
                next.signal();
                current.await();
            }
            next.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
class Four implements Runnable{
    private static final AtomicInteger counter = new AtomicInteger(0);
    ReentrantLock lock  ;
    Condition curr ;
    Condition next ;

    public Four(ReentrantLock lock, Condition curr, Condition next) {
        this.lock = lock;
        this.curr = curr;
        this.next = next;
    }

    @Override
    public void run() {
        this.lock.lock();
        try{
            while(counter.get() < 100){
                System.out.println(Thread.currentThread().getName() + " 正在打印: " + counter.incrementAndGet());
                next.signal();
                curr.await();
            }
            next.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            this.lock.unlock();
        }
    }
}
class Five implements Runnable{
    private static final int TOTAL_PRINT_COUNT = 100 ;
    private static final AtomicInteger counter = new AtomicInteger(0) ;
    Lock lock  ;
    Condition cur ;
    Condition next ;

    public Five(Lock lock, Condition cur, Condition next) {
        this.lock = lock;
        this.cur = cur;
        this.next = next;
    }
    @Override
    public void run(){
        this.lock.lock();
        try{
            while(counter.get() < 100){
                System.out.println(Thread.currentThread().getName() + " 正在打印： " + counter.incrementAndGet());
                next.signal();
                cur.await(); ;
            }
            next.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            this.lock.unlock();
        }
    }
}
class Six implements  Runnable{
    private static AtomicInteger counter = new AtomicInteger(0);
    private Lock lock ;

    public Six(Lock lock, Condition cur, Condition next) {
        this.lock = lock;
        this.cur = cur;
        this.next = next;
    }

    private Condition cur ;
    private Condition next ;
    @Override
    public void run() {
        lock.lock();
        try{
            while(counter.get() < 100){
                System.out.println(Thread.currentThread().getName() + " is printing : "+ counter.incrementAndGet());
                next.signal();
                cur.await();
            }
            next.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class Seven implements  Runnable{
    private Lock lock ;
    private Condition cur ;
    private Condition next ;
    private static AtomicInteger counter = new AtomicInteger(0) ;
    public Seven(Lock lock, Condition cur, Condition next) {
        this.lock = lock;
        this.cur = cur;
        this.next = next;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            while(counter.get() < 100){
                System.out.println(Thread.currentThread().getName() + " is printing " + counter.incrementAndGet());
                next.signal();
                cur.await();
            }
            next.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
class Eight implements  Runnable{
    public static AtomicInteger counter = new AtomicInteger(0) ;
    Lock lock ;
    Condition cur  ;
    Condition next ;

    public Eight(Lock lock, Condition cur, Condition next) {
        this.lock = lock;
        this.cur = cur;
        this.next = next;
    }

    @Override
    public void run() {
        this.lock.lock();
        try{
            while(counter.get() < 99){
                System.out.println(Thread.currentThread().getName() + " is printing " + counter.incrementAndGet());
                next.signal();
                cur.await();
            }
            next.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            this.lock.unlock();
        }
    }
}