package 观察者模式.使用JDK内置的观察者模式;

import java.util.Observable;

public class WeatherData extends Observable {

    private float templete;//温度

    private float pressure;//气压

    private float humidity;//湿度

    public WeatherData() {

    }

    /**
     * 状态改变时，被观察对象可以先对数据做一些检查，并决定是否要推送消息
     */
    public void measurementsChanged(){
        //JDK实现的方法，可以在更新消息时有更多“弹性”。比如数据变化不大，我不需要再次推送，那么就可以进行控制。
        setChanged();
        notifyObservers();
    }

    /**
     * 接受数据
     * @param templete
     * @param pressure
     * @param humidity
     */
    public void setMessage(float templete, float pressure, float humidity) {
        this.templete = templete;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementsChanged();
    }

    public float getTemplete() {
        return templete;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

}
