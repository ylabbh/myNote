package 观察者模式.自己的一些升级;

/**
 * 主题
 */
public interface Subject {

    void registerObserver(Observer observer);//注册

    void removeObserver(Observer observer);//取消订阅

    void notifyObserver();//推送消息


}
