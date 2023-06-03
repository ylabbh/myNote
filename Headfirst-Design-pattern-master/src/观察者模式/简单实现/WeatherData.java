package 观察者模式.简单实现;

import java.util.ArrayList;

/**
 * 被观察对象，一旦数据发生改变，就会发送通知
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private float templete;//温度

    private float pressure;//气压

    private float humidity;//湿度

    public WeatherData(float templete, float pressure, float humidity) {
        this.templete = templete;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    /**
     * 注册观察者
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i < 0){
            observers.add(observer);
        }
    }

    /**
     * 移除观察者
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {

        int i = observers.indexOf(observer);
        if (i >= 0){
            observers.remove(observer);
        }
    }

    /**
     * 向观察者们推送消息,内用
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(templete,pressure,humidity);
        }
    }

    /**
     * 获取消息（数据改变，准备发送通知）
     * @param templete
     * @param pressure
     * @param humidity
     */
    public void getMessage(float templete,float pressure,float humidity){
        System.out.println("WeatherData接收到了最新数据，准备推送消息");
        this.templete = templete;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObserver();
    }
}
