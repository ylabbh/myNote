package 观察者模式.使用JDK内置的观察者模式;

import 观察者模式.简单实现.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * 可以看到，对于观察者来说，它根本不知道主题这个东西。
 */
public class 温度计 implements Observer, DisplayElement {

    private float templete;

    @Override
    public void display() {
        System.out.println("我是温度计，当前：" + templete);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.templete = weatherData.getTemplete();
            display();
        }
    }
}
