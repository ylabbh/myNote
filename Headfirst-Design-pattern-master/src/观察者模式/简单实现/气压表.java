package 观察者模式.简单实现;

/**
 * 可以看到，对于观察者来说，它根本不知道主题这个东西。
 */
public class 气压表 implements Observer, DisplayElement {

    private float pressure;

    @Override
    public void display() {
        System.out.println("我是气压表，当前大气压力：" + pressure);
    }

    /**
     * 可以看到，在这种结构下，任何观察者接收的都是所有的数据。这显然有点“耦合”，我气压表，只关心气压。
     * @param templete
     * @param pressure
     * @param humidity
     */
    @Override
    public void update(Float templete, Float pressure, Float humidity) {
        this.pressure = pressure;
        display();
    }

}
