public class Test {
    /**
     * 1.演示线程创建的三种方式(1.继承Thread，重写run方法。2.实现Runnable接口，实现run方法，Thread构造函数中传入 3.new Thread("线程名"){//匿名内部类  重写run方法}.start() 的方式)
     * 2.给线程命名的两种方式 （1.构造函数传入name 2.Thread(父类)对象.setName( "名称")方式传入）
     * 3.获取当前线程对象：Thread.currentThread()---main方法本身就是一个线程，“获取当前线程的对象”就好像是在其中一跟管道中获取这根管道一样
     *
     * 以前学过的线程安全的类:
     * Vector 是线程安全的,ArrayList 是线程不安全的
     * StringBuffer 是线程安全的,StringBuilder 是线程不安全的
     * Hashtable 是线程安全的,HashMap 是线程不安全的
     *
     * 因为这些类中的所有方法都是使用 synchronized 关键字修饰
     * @param args
     */
    public static void main(String[] args) {
        //方式一，继承Thread类
        DemoExtendThread demo = new DemoExtendThread();
        demo.start();
        //方式二：实现Runnable接口，重写run方法后传递给Thread类作为target参数，并调用Thread类的start方法
        DemoImpementsRunnable demo2 = new DemoImpementsRunnable();
        Thread th = new Thread(demo2);
        th.start();
        //方式三：匿名内部类的形式
        //匿名内部类概述:前提条件存在一个类或者一个接口,匿名内部类就是这个类的子类对象或者接口实现类(干儿子类)对象,就是(干儿)子类对象的简化格式
        new Thread(){//这个Thread就是匿名内部类的父类或者实现的接口---如果一个类只在这里使用一次，不需要单独创建一个，直接这样就可以了
          @Override
          public void run(){
              for (int i = 0; i < 100000; i++) {
                  System.out.println("线程三打印"+ i);
              }
          }
        }.start();

        for (int i = 0; i < 100000; i++) {
            System.out.println("主进程打印"+ i);
        }
        //四：线程在创建的时候可以给线程起名字
        //五：Thread.currentThread()可获取当前线程对象
        new Thread("奶奶线程"){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("我是：  " + Thread.currentThread().getName() + "打印" + i);
                }
            }
        }.start();

    }
}

class DemoExtendThread extends Thread {

    public void run(){
        for (int i = 0; i < 100000; i++) {
            System.out.println("线程一打印" +i);
        }
    }
}

class DemoImpementsRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("线程二打印" +i);
        }
    }
}


