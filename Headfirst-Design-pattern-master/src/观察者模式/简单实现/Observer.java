package 观察者模式.简单实现;

public interface Observer {

    /**
     * 在这种情况中，无论观察者需要的是多少数据，
     * 它接受到的都是统一的份完整数据，这里确实比较不完善，不够优雅，我希望不同的观察者只接收它关心的数据，而不是所有数据
     * JAVA内置的观察者模式就提供了这两种方式
     *
     * @param templete
     * @param pressure
     * @param humidity
     */
    void update(Float templete, Float pressure, Float humidity);//接收消息，既然消息源是统一的，那么入参也一定是一致的

}
