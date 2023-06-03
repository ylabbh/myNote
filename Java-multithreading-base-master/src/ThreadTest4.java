public class ThreadTest4 {

    /**
     * 1.什么情况下需要同步
     *  当多线程并发, 有多段代码同时执行时, 我们希望某一段代码执行的过程中 CPU 不要切换到其他线程工作. 这时就需要同步.
     *  如果两段代码是同步的, 那么同一时间只能执行一段, 在一段代码没执行结 束之前, 不会执行另外一段代码.
     *
     * 2. 同步代码块
     *  使用 synchronized 关键字加上一个锁对象来定义一段代码, 这就叫同步代码块
     *  多个同步代码块如果使用相同的锁对象, 那么他们就是同步的
     *
     * 3.同步方法
     * 使用 synchronized 关键字修饰一个方法, 该方法中所有的代码都是同步的
     *
     * ！！！注意:
     * 非静态同步方法的同步锁对象是 this
     * 静态同步方法的同步锁对象是 类名.class
     *
     *  ------同步代码块必须要指定锁。
     *  ------同步方法隐性地指定了。即：凡是同步相关的，必定需要一个锁的概念
     * @param args
     */
    public static void main(String[] args) {
        final Killer killer = new Killer();
        final Teacher teacher = new Teacher();
        /*------------同步代码块*/
        /*new Thread(){
            @Override
            public void run() {
                killer.kongFu();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {//run方法
                killer.gunSkill();
            }
        }.start();*/
        /*------------同步方法--------*/
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    teacher.sayHello();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    teacher.sayGoodNight();
                }
            }
        }.start();

    }



}


class Clock{}

/**
 * 演示同步代码块
 */
class Killer{

    Clock c = new Clock();

    public void kongFu(){
        synchronized(c){
            for (int i = 0; i < 10; i++) {
                System.out.println("   独");
                System.out.println("   孤");
                System.out.println("   九");
                System.out.println("   剑");
                System.out.println("--------------");
            }
        }

    }

    public void gunSkill(){
        synchronized(c){
            for (int i = 0; i < 10; i++) {
                System.out.println("天");
                System.out.println("堂");
                System.out.println("一");
                System.out.println("闪");
            }
        }

    }
}

/**
 * 演示同步方法
 */
class Teacher{
    /**
     * 看下面这两个方法，一个是静态同步方法，一个是非静态同步方法。由于它们的锁对象是不同的，所以并不能实现同步
     * 1.同：都是隐式地指定了锁
     * 2.异：锁对象是不同的。一个是this，一个是类名.class
     */
    //非静态同步方法的同步锁对象是 this  --锁呢？这里隐式地指定了，锁对象是this即调用这个方法的对象。
    public synchronized void sayHello(){
        System.out.println("------------------");
        System.out.println("同");
        System.out.println("学");
        System.out.println("们");
        System.out.println("早");
        System.out.println("上");
        System.out.println("好");
        System.out.println("------------------");
    }

    //静态同步方法的同步锁对象是 类名.class
    public static synchronized void sayGoodNight(){
        System.out.println("****************");
        System.out.println("*同");
        System.out.println("*学");
        System.out.println("*们");
        System.out.println("*晚");
        System.out.println("*安");
        System.out.println("****************");
    }

}