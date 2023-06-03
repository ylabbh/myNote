public class ThreadTest3 {
    /**
     * 1.线程加入th1.join(); （Thread th1）: 当前线程暂停 , 等待指定的线程执行结束后 , 当前线程再继续
     *           th1.join(long): 可以等待指定的毫秒之后继续
     * 2.Thread.yield(); 线程礼让-让出CPU执行权，但是可以看到，并没有什么明显的效果，因为只是在一瞬间让出执行权，又立刻重新争夺CPU执行权，
     *  ------可以看作是sleep()了一瞬间
     * 3.th1.setPriority(Thread.MIN_PRIORITY)  ----可以看到，
     * @param args
     */
    public static void main(String[] args) {
        Thread th1 = new Thread("线程一"){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + "打印" + i);
                }
            }
        };

        Thread th2 = new Thread("               线程二"){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (i % 10 == 0){
                        //th1.join();//如果不加时间，先等线程一全部打完再打线程二。也可以指定时间（插队/等待的时间）
                        Thread.yield();//相当于sleep了一瞬间
                    }
                    System.out.println(Thread.currentThread().getName() + "打印" + i);
                }
            }
        };
        th1.setPriority(Thread.MIN_PRIORITY);//1,最低优先级，
        th2.setPriority(Thread.MAX_PRIORITY);//10.最高优先级
        //可以看到，虽然是线程一先start，但是由于优先级较低，却是线程二先开始运行。而且线程二有更高的优先级去占用CUP，总是先于线程一完成。
        th1.start();
        th2.start();
    }
}
