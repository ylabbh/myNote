import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 互斥锁 {

    /**
     *  先看前面的  多线程之间的通信  才能理解。
     *
     * 1. JDK1.5 的新特性互斥锁
     * 1.同步   使用 ReentrantLock 类的 lock()和 unlock()方法进行同步
     * 2.通信   使用 ReentrantLock 类的 newCondition()方法可以获取 Condition 对象
     *          需要等待的时候使用 Condition 的 await()方法, 唤醒的时候用 signal()方法
     *          不同的线程使用不同的 Condition, 这样就能区分唤醒的时候找哪个线程了
     *
     * 其实运用在线程通信中，使用wait(),notify(),notifyAll()不够灵活，我们希望唤醒和等待指定的锁，因此有了JDK1.5的新特性
     *
     * 使用互斥锁的不同之处
     *
     * 1.不使用同步代码块了，而是通过在流程中手动控制锁的获得和释放来实现同步。
     * 2.通信时可以唤醒指定的线程了。
     *
     *
     */
    public static void main(String[] args) {
        Printer printer1 = new Printer();
        new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        printer1.print1();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        printer1.print2();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        printer1.print3();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

}



//
class Printer1{

    private int flag = 1;

    ReentrantLock r = new ReentrantLock();
    private Condition c1 = r.newCondition();
    private Condition c2 = r.newCondition();
    private Condition c3 = r.newCondition();


    public void print1() throws InterruptedException {
        r.lock();//获得锁
        if(flag != 1){
            c1.wait();
        }
        System.out.println("我");
        System.out.println("经");
        System.out.println("常");
        System.out.println("逛");
        flag = 2;
        c2.signal();
        r.unlock();

    }

    public void print2() throws InterruptedException {
        r.lock();//获得锁
        if(flag != 2){
            this.wait();
        }
        System.out.println("bilibili");
        flag = 3;
        c3.signal();
        r.unlock();
    }


    public void print3() throws InterruptedException {
        r.lock();//获得锁
        if(flag != 3){
            this.wait();
        }
        System.out.println("真开心");
        System.out.println("---------");
        flag = 1;
        c1.signal();
        r.unlock();
    }

}