public class ThreadTest2 {
    /**
     * 1.线程休眠Thread.sleep(1000);----让当前线程休眠指定时间
     * 2.th2.setDaemon(true);  (Thread th2) ---设置一个线程 为守护, 该线程不会单独执行 ,
     *  当其他非守 护线程都执行结束后 , 自动退出
     * ------可以看到，线程2要打印1000次才会结束，但是如果变成守护进程，它将在其它非守护线程都结束后立刻自动退出
     * ------可以看到，两个线程同时启动，一号 sleep 10秒钟，二号先起来了，当一号开始打印1，2，结束后，二号立刻跟着结束了。
     *
     * @param args
     */
    public static void main(String[] args) {
        /*------------演示线程休眠------------*/
        Thread th1 = new Thread("   线程一"){
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 2; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   打印：" + i);
                }
            }
        };
        Thread th2 = new Thread("线程二"){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   打印：" + i);
                }
            }
        };
        /*------------守护线程------------*/
        th2.setDaemon(true);
        th1.start();
        th2.start();

    }



}
