package 观察者模式.使用JDK内置的观察者模式;

/**
 * 任何继承Subject的，都可以兼容任何Observer。每次更新就调动Observer的update方法。
 */
public class Test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.addObserver(new 气压表());
        weatherData.addObserver(new 温度计());
        weatherData.setMessage(50f,100f,100f);
    }
}
