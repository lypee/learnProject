package learn.ThreadLocalDemo;

import java.util.concurrent.CountDownLatch;

public class ThreadLocalDemo {
    private static ThreadLocal<String> threadLocal =
            new ThreadLocal<>();
    public void setString(String string){
        threadLocal.set(string);
    }
    public String getString(){
        return threadLocal.get() ;
    }
    public static void main(String[] args){
        int threads = 9 ;
        ThreadLocalDemo demo = new ThreadLocalDemo() ;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for(int i = 0;  i < threads ; i++){
            Thread thread = new Thread(()->{
                demo.setString(Thread.currentThread().getName());
                System.out.println("demo getString: "+demo.getString());
                countDownLatch.countDown();

            },"执行线程 ："+ i);
            thread.start();
        }
    }
}
