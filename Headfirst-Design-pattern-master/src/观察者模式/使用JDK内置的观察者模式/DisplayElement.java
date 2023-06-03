package 观察者模式.使用JDK内置的观察者模式;

/**
 * 每一个观察者针对收到的消息可能有不同的展示方法，抽取成接口
 */
public interface DisplayElement {

    void display();

}
