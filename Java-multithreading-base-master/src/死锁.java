public class 死锁 {
    private static String s1 = "金锁";

    private static String s2 = "银锁";

    /**
     * 多线程同步的时候, 如果同步代码嵌套, 使用相同锁, 就有可能出现死锁 尽量不要嵌套使用
     * @param args
     */
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (s1){
                        System.out.println(getName() + "拿到：" + s1 + "。。准备获取：" + s2);
                        synchronized (s2){
                            System.out.println(getName() + "拿到：" + s2 + "，睡觉");
                        }
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (s2){
                        System.out.println(getName() + "拿到：" + s2 + "。。准备获取：" + s1);
                        synchronized (s1){
                            System.out.println(getName() + "拿到：" + s1 + "，睡觉");
                        }
                    }
                }
            }
        }.start();

    }

}

