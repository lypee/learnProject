package learn.ProCus;

public class ProCus {
    public static void main(String[] args){
//1.准备数据
        Product1 product = new Product1();
        //2.创建生产消费任务
        Produce1 produce = new Produce1(product);
        Consume1 consume = new Consume1(product);
        //3.创建生产线程
        Thread thread0 = new Thread(produce);
        Thread thread2 = new Thread(consume);
        Thread thread1 = new Thread(produce);
        Thread thread3 = new Thread(consume);
        //4.开启线程
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
class Product1{
    String name;
    double price;
    int count=0;

    //标识
    boolean flag = false;

    //准备生产
    public synchronized void setProduce(String name, double price) {
        while(flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.price = price;
        count ++;
        System.out.println(Thread.currentThread().getName()+"生产了:" + name+"  产品数量:"+count+"  价格"+price);
        flag = !flag;
        notifyAll();
    }
    //准备消费
    public synchronized void getProduce() {
        while(flag == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"消费了:" + name+"  产品数量:"+count+"  价格"+price);
        flag = !flag;
        notifyAll();
    }
}
//生产任务
class  Produce1 implements Runnable{

    Product1 product;

    public Produce1(Product1 product) {
        super();
        this.product = product;
    }

    @Override
    public void run() {
        while(true) {
            product.setProduce("Lpy", 10);
        }
    }
}

//消费任务
class  Consume1 implements Runnable{
    Product1 product;

    public Consume1(Product1 product) {
        super();
        this.product = product;
    }


    @Override
    public void run() {
        while(true) {
            product.getProduce();
        }
    }
}
