import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 多个线程之间的通信 {
    /**
     * ！！两个线程间的通信
     * 1.什么时候需要通信 多个线程并发执行时, 在默认情况下 CPU 是随机切换线程的，如果我们希望他们有规律的执行(按照一定的顺序), 就可以使用通信, 例如每个线程执行 一次打印
     *
     *  2.怎么通信
     *  如果希望线程等待, 就调用 wait()
     *  如果希望唤醒等待的线程, 就调用 notify();
     *  !!这两个方法必须在同步代码中执行, 并且使用同步锁对象来调用
     *  “等待”的意思是暂时放弃对锁的争夺和持有。“唤醒”的意思刚好相反，重新开始争夺锁
     *
     *  3.注意！！
     *  锁对象.wait()
     *  锁对象.notify()
     *  锁对象.notifyAll()
     *  Thread.sleep()
     *
     *  1,在同步代码块中,用哪个对象作为锁,就用 哪个对象调用 wait 和 notify nofityAll 方法
     *  2,为什么 wait 方法和 notify 方法定义在 Object 这个类中?
     *   因为锁对象可以是任意对象,Object是所有的类的基类,所以
     * wait方法和notify方法需要定义在Object这个类中
     *
     *  sleep()和wait()的区别--
     *  1.sleep()是线程的方法。wait()是锁对象的方法。
     *  2.sleep方法在同步函数或同步代码块中,不释放锁,睡着了也抱着锁睡。wait 方法在同步函数或者同步代码块中,释放锁
     *  3,sleep方法必须传入参数,参数就是时间,时间到了自动醒来
     *     wait方法可以传入参数也可以不传入参数,传入参数就是等
     * 待指定的时间,时间到了会自动醒来,不传入参数就是直接等待
     *
     *
     * ！！线程池
     * 1.线程池概述
     * 程序启动一个新线程成本是比较高的因为它涉及到要与操作系统进行交互。
     * 而使用线程池可以很好的提高性能，尤其是当程序中要创建大量生存期很短的线程 时，更应该考虑使用线程池。
     * 线程池里的每一个线程代码结束后，并不会死亡，而是再次回到线程池中成为空闲状态，等待下一个对象来使用。
     * 在 JDK5 之前， 我们必须手动实现自己的线程池，从 JDK5 开始，Java 内置支持线程池
     *
     * 2.内置线程池的使用概述
     * JDK5 新增了一个 Executors 工厂类来产生线程池，有如下几个方法
     * public static ExecutorService newFixedThreadPool(int nThreads)
     * public static ExecutorService newSingleThreadExecutor()
     * 这些方法的返回值是 ExecutorService 对象，该对象表示一个线程池，可以执行 Runnable 对象或者 Callable 对象代表的线程。
     * 它提供了如下方法
     * Future<?> submit(Runnable task)
     * <T> Future<T> submit(Callable<T> task)
     *
     * 通过线程池实现多线程
     * 好处: 可以有返回值, 并且可以抛出异常，Future类就是指将来线程返回可能的东西，值或者异常。
     *
     *
     * 使用步骤：
     * 1.创建线程池对象
     * 2.创建 Runnable 实例
     * 3.提交 Runnable 实例
     * .关闭线程池
     *
     */
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new MyThread1(printer));
        pool.submit(new MyThread2(printer));
        pool.submit(new MyThread3(printer));
        pool.shutdown();
    }

}

class MyThread1 implements Runnable{

    private Printer printer;

    public MyThread1(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            while (true){
                printer.print1();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyThread2 implements Runnable{

    private Printer printer;

    public MyThread2(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            while (true){
                printer.print2();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread3 implements Runnable{

    private Printer printer;

    public MyThread3(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            while (true){
                printer.print3();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



//
class Printer{

    private int flag = 1;

    public void print1() throws InterruptedException {
        synchronized(this){
            while(flag != 1){
                this.wait();
            }
            System.out.println("我");
            System.out.println("经");
            System.out.println("常");
            System.out.println("逛");
            flag = 2;
            this.notifyAll();
        }
    }

    public void print2() throws InterruptedException {
        synchronized(this){
            while(flag != 2){
                this.wait();
            }
            System.out.println("bilibili");
            flag = 3;
            this.notifyAll();
        }
    }


    public void print3() throws InterruptedException {
        synchronized(this){
            while(flag != 3){
                this.wait();
            }
            System.out.println("真开心");
            System.out.println("---------");
            flag = 1;
            this.notifyAll();
        }
    }

}





