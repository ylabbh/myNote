public class ThreadTest5 {
    /**
     * 演示线程安全问题----多个线程同时操作一个数据，可能出现冲突问题，由于线程切换执行太快，导致数据出现几个线程间不同步的问题。
     * ----线程同步：是指多个线程间数据的一致性。
     * ----什么时候需要加锁？当多个线程操作的是操作同一份数据的时候，就需要确保同步。
     *
     * ----不必要的锁不要加，因为由于加入锁移交环节，会导致效率变差。
     *
     */
    public static void main(String[] args) {
        new Window().start();
        new Window().start();
        new Window().start();
        new Window().start();
    }
}


class Window extends Thread{

    //！！注意，关于加锁，我们常常拿成员变量作为锁。
    //private static Object obj = new Object();
    //如果用引用数据类型成员变量当作锁对象,必须是静态的 --- 确保锁的唯一
    private static int count = 300;

    /**
     * \不错的例子，这种情况下，依旧不能保证线程安全。并不是“哪个位置操作的是共有数据就在哪里加锁”这么简单
     *
     */
    @Override
    public void run() {
        while(count > 0){
            //1.注意，很有可能当Window.count==1时，四个线程同时完成count>0 ?的判断进来操作数据。这种情况下，虽然是加了锁的，但count--的操作还是会被执行四次
            synchronized(Window.class){
                //2.因此，需要在索内部再加一层检查
                if(count > 0){
                    count --;
                    System.out.println(getName() + "卖出去1张票，还剩：" + count +" 张");
                }
            }
        }
        System.out.println(getName()+"票已经买完了");

    }

}
