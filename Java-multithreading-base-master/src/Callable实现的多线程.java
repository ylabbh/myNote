import java.util.concurrent.*;

public class Callable实现的多线程 {

    /**
     * 通过线程池实现多线程
     * 好处: 可以有返回值, 并且可以抛出异常
     *
     * 示例：输入一个正整数，如5，得到1+2+3+4+5 = 15，多线程实现
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        System.out.println(pool.submit(new Count(5)).get());
        System.out.println(pool.submit(new Count(10)).get());
        System.out.println(pool.submit(new Count(15)).get());
        pool.shutdown();
    }


}

class Count implements Callable<Integer> {

    private Integer sum = 0;

    public Count(Integer sum) {
        this.sum = sum;
    }

    @Override
    public Integer call() throws Exception {
        Integer count = 0;
        for (Integer i = 0; i < sum; i++) {
            count += i;
        }
        return count;

    }
}
