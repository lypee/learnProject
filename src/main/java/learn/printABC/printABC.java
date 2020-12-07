package learn.printABC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class printABC {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService poolService  = Executors.newFixedThreadPool(3) ;
        ReentrantLock lock = new ReentrantLock() ;
        Condition conditionA = lock.newCondition() ;
        Condition conditionB = lock.newCondition() ;
        Condition conditionC = lock.newCondition() ;
        poolService.execute(new Eight("A" ,10 ,1 ,lock ,conditionA ,conditionB));
        poolService.execute(new Eight("B" ,10 ,2 ,lock ,conditionB ,conditionC));
        poolService.execute(new Eight("C" ,10 ,3 ,lock ,conditionC ,conditionA));
        Thread.sleep(5000);
        poolService.shutdownNow() ;
    }


}
//基于一个Reentrantlock和三个Condition打印
class one{
        private ReentrantLock lock = new ReentrantLock() ;
        private Condition conditionA = lock.newCondition() ;
        private Condition conditionB = lock.newCondition() ;
        private Condition conditionC = lock.newCondition() ;
        private static volatile int state = 1 ;
        public static class Worker implements Runnable{
            String key ;
            Integer count ;
            Lock lock ;
            Condition current ;
            Condition next ;
            Integer targetState ;

            public Worker(String key, Integer count, Lock lock, Condition current, Condition next, Integer targetState) {
                this.key = key;
                this.count = count;
                this.lock = lock;
                this.current = current;
                this.next = next;
                this.targetState = targetState;
            }

            @Override
            public void run() {
                    this.lock.lock();
                    try{
                        for(int i = 0 ; i <= count ; i++){
                            if(state != targetState){
                                current.await();
                            }
                            System.out.println(key +  " " + state);
                            state++ ;
                            if(state > 3){
                                state = 1 ;
                            }
                            next.signal();
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        this.lock.unlock();
                    }
            }
        }
}
class Two{
    private ReentrantLock lock = new ReentrantLock() ;
    private Condition conditionA = lock.newCondition() ;
    private Condition conditionB = lock.newCondition() ;
    private Condition conditionC = lock.newCondition() ;
    private static volatile int state = 1 ;
    static class Worker implements Runnable{
        String key ;
        Integer count ;
        Integer targetState ;
        Lock lock ;
        Condition current ;
        Condition next ;

        public Worker(String key, Integer count, Integer targetState, Lock lock, Condition current, Condition next) {
            this.key = key;
            this.count = count;
            this.targetState = targetState;
            this.lock = lock;
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            this.lock.lock();
            try{
                for(int i = 1 ; i <= count ; i++){
                    if(targetState != state){
                        current.await();
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                this.lock.unlock() ;
            }
        }
    }
}

class Three{
    private static volatile int state = 1 ;
    public static class Worker implements Runnable{
        String key ;
        Integer count ;
        Integer targetCount ;
        Lock lock ;
        Condition current ;
        Condition next ;

        public Worker(String key, Integer count, Integer targetCount, Lock lock, Condition current, Condition next) {
            this.key = key;
            this.count = count;
            this.targetCount = targetCount;
            this.lock = lock;
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            this.lock.lock();
            try{
                for(int i = 1 ; i <= count ;i++){
                    if(state != targetCount){
                        current.await();
                    }
                    System.out.println(key + " 正在打印： " + state);
                    state++ ;
                    if(state > 3 ){
                        state = 1 ;
                    }
                    next.signal();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                this.lock.unlock();
            }
        }
    }
}
class Four implements Runnable{
    private static volatile int state = 1 ;
    String key ;
    Integer count ;
    Integer targetCount  ;
    Lock lock  ;
    Condition curr ;
    Condition next ;

    public Four(String key, Integer count, Integer targetCount, Lock lock, Condition curr, Condition next) {
        this.key = key;
        this.count = count;
        this.targetCount = targetCount;
        this.lock = lock;
        this.curr = curr;
        this.next = next;
    }

    @Override
    public void run() {
        this.lock.lock();
        try{
            for(int i = 0 ; i < count ; i++){
                if(state != targetCount){
                    curr.await();
                }
                System.out.println(key + " 正在打印： " + state);
                state++ ;
                if(state > 3){
                    state = 1 ;
                }
                next.signal();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            this.lock.unlock();
        }
    }
}
class Five implements  Runnable{
    private static volatile int state = 1 ;
    String key ;
    Integer count ;
    Integer targetState ;
    Lock lock ;
    Condition cur ;
    Condition next ;

    public Five(String key, Integer count, Integer targetState, Lock lock, Condition cur, Condition next) {
        this.key = key;
        this.count = count;
        this.targetState = targetState;
        this.lock = lock;
        this.cur = cur;
        this.next = next;
    }

    @Override
    public void run() {
        this.lock.lock();
        try{
            for(int i = 0 ; i < count ; i++){
                if(state != targetState){
                    cur.await();
                }
                System.out.println(key +  " 正在打印： "+ state);
                state++ ;
                if (state > 3 ){
                    state = 1 ;
                }
                next.signal();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            this.lock.unlock();
        }
    }
}
class Six implements Runnable{
    String key ;
    Integer targetState ;
    Integer count ;
    Lock lock ;
    Condition cur ;
    Condition next ;
    private static volatile int state = 1 ;

    public Six(String key, Integer targetState, Integer count, Lock lock, Condition cur, Condition next) {
        this.key = key;
        this.targetState = targetState;
        this.count = count;
        this.lock = lock;
        this.cur = cur;
        this.next = next;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            for(int i = 0 ; i < count ; i++){
                if(state != targetState){
                    cur.await() ;
                }
                System.out.println(key +  " is printing: " + state);
                state++ ;
                if(state > 3){
                    state = 1 ;
                }
                next.signal();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.lock();
        }
    }
}
class Seven implements Runnable{
    String key ;
    Integer count ;
    Integer targetCount ;
    Lock lock ;
    Condition cur  ;
    Condition next ;
    private static volatile int state = 1 ;
    public Seven(String key, Integer count, Integer targetCount, Lock lock, Condition cur, Condition next) {
        this.key = key;
        this.count = count;
        this.targetCount = targetCount;
        this.lock = lock;
        this.cur = cur;
        this.next = next;
    }

    @Override
    public void run() {
        this.lock.lock();
        try{
            for(int i  = 0 ; i < count ; i++){
                if(state != targetCount){
                    cur.await();
                }
                System.out.println(key + " is printing : " + state);
                state++ ;
                if(state > 3 ){
                    state = 1 ;
                }
                next.signal();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            this.lock.unlock();
        }
    }
}
class Eight implements  Runnable{
    String key ;
    Integer count ;
    Integer targetCount ;
    Lock lock ;
    Condition cur ;
    Condition next ;
    public static volatile  int state = 1 ;
    public Eight(String key, Integer count, Integer targetCount, Lock lock, Condition cur, Condition next) {
        this.key = key;
        this.count = count;
        this.targetCount = targetCount;
        this.lock = lock;
        this.cur = cur;
        this.next = next;
    }

    @Override
    public void run() {
        this.lock.lock();
        try{
            for(int i = 0 ; i < count ; i++){
                if(state != targetCount){
                    cur.await();
                }
                System.out.println(Thread.currentThread().getName() + " is printing " + key);
                state++ ;
                if(state  >3){
                    state = 1 ;
                }
                next.signal();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            this.lock.unlock();
        }
    }
}