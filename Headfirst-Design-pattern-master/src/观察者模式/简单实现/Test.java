package 观察者模式.简单实现;

/**
 * 在简单实现中，主题Subject持有所有观察者。主动让别人来观察自己（registerObserver），而观察者不知道自己观察的是谁，它只知道接收(update)
 */
public class Test {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(100,200,300);
        气压表 q = new 气压表();
        湿度计 s = new 湿度计();
        weatherData.registerObserver(q);
        weatherData.registerObserver(s);
        weatherData.getMessage(10,30,50);
    }
}
