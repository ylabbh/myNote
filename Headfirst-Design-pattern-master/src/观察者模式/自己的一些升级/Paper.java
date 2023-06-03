package 观察者模式.自己的一些升级;

import java.util.ArrayList;
import java.util.List;

public class Paper implements Subject{

    public String name;

    public List<Observer> observerList = new ArrayList<Observer>();

    public String message;

    private Paper(){

    }

    public Paper(String name) {
        this.name = name;
    }

    @Override
    public void registerObserver(Observer observer) {
        System.out.println("新用户订阅了： " + this.name);
        if (observerList.indexOf(observer) < 0){
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observerList.indexOf(observer)>=0){
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(message,this.name);
        }
    }

    public void getMessage(String message){
        this.message = message;
        notifyObserver();
    }


}
