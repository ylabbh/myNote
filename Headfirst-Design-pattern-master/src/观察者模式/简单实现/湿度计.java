package 观察者模式.简单实现;

public class 湿度计 implements Observer, DisplayElement {

    private float humidity;

    @Override
    public void display() {
        System.out.println("我是湿度计，当前空气湿度：" + humidity);
    }

    @Override
    public void update(Float templete, Float pressure, Float humidity) {
        this.humidity = humidity;
        display();
    }

}
